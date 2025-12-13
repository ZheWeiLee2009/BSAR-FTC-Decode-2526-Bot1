package org.firstinspires.ftc.teamcode;


import static org.firstinspires.ftc.teamcode.Config.RobotConstants.c_DriveSpeed;
import static org.firstinspires.ftc.teamcode.Config.RobotConstants.recoveryDelay;
import static org.firstinspires.ftc.teamcode.Config.RobotConstants.recoveryPause;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Pose2D;

import org.firstinspires.ftc.teamcode.Config.Drivetrain;
import org.firstinspires.ftc.teamcode.Config.FieldOrientedCalc;
import org.firstinspires.ftc.teamcode.Config.Odometry;

import java.util.Locale;

// --- VISION IMPORTS ---
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;
import java.util.List;
// ----------------------

@TeleOp(name = "Blue FO TeleOP", group = ".")
public class BlueFOTeleOp extends OpMode {
    Drivetrain bot;
    FieldOrientedCalc FOcalc;
    Odometry odometry;

    private ElapsedTime opmodeTimer = new ElapsedTime();
    private ElapsedTime gateTimer = new ElapsedTime();
    private double SPEED_MULTIPLIER = c_DriveSpeed;

    FtcDashboard dashboard = FtcDashboard.getInstance();
    Telemetry dashboardTelemetry = dashboard.getTelemetry();

    private boolean GateState = true;
    private boolean isWaitingGateState = false;

    private int MAX_CYCLES = 3;
    private int cycleCounter = 0;
    private int flyWheelOffset = 0;

    // --- APRILTAG DECLARATIONS ---
    private static final int TARGET_TAG_ID = 20;      // Target ID set to 20 for Blue Alliance
    private static final double HEADING_P_GAIN = 0.03; // Tuned P-Gain for rotation
    private static final double MAX_TURN_POWER = 0.5; // Max speed for the auto-correction

    private VisionPortal visionPortal;
    private AprilTagProcessor aprilTagProcessor;
    private boolean isLocked = false;
    private boolean lockButtonPrevState = false; // Tracks L3 button state for toggle
    // ---------------------------------
    
    // --- IMU CALIBRATION DECLARATION ---
    private boolean backButtonPrevState = false; // Tracks SHARE/BACK button for IMU reset
    // ---------------------------------------


    @Override
    public void init() {
        opmodeTimer.reset();

        bot = new Drivetrain(hardwareMap, opmodeTimer);
        bot.setServoPos(true);

        FOcalc = new FieldOrientedCalc();

        odometry = new Odometry(hardwareMap, opmodeTimer);

        odometry.odo.resetPosAndIMU();
        
        // --- VISION INITIALIZATION ---
        aprilTagProcessor = new AprilTagProcessor.Builder().build();

        // Use the Camera Name c
        visionPortal = new VisionPortal.Builder()
                .setCamera(hardwareMap.get(WebcamName.class, "Webcam"))
                .addProcessor(aprilTagProcessor)
                .build();

        telemetry.addData("Vision", "AprilTag Vision Ready.");
        // -----------------------------
        
        Telemetry telemetry = new MultipleTelemetry(this.telemetry, FtcDashboard.getInstance().getTelemetry());
    }


    @Override
    public void start() {
        opmodeTimer.reset();

        odometry.odo.resetPosAndIMU();
        bot.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    @Override
    public void loop() {

        odometry.odo.update();

        // --- IMU CALIBRATION LOGIC (SHARE/BACK BUTTON) ---
        boolean backButtonCurrState = gamepad1.back;
        // Check for a press: only run if button is currently pressed AND was NOT pressed last loop
        if (backButtonCurrState && !backButtonPrevState) { 
            // Trigger the position reset and IMU recalibration
            odometry.odo.resetPosAndIMU(); 
            telemetry.addLine("*** IMU Recalibrated & Position Reset! ***");
        }
        backButtonPrevState = backButtonCurrState;
        // -------------------------------------------------


        // ************* DRIVE **************//
        // Directional Movements
        double y = -gamepad1.left_stick_y;
        double x = gamepad1.left_stick_x;
        double rx = gamepad1.right_stick_x; // Driver rotational input

        
        // --- APRILTAG CONTROL LOGIC (L3 BUTTON) ---
        
        // L3 Button Toggle Logic
        boolean lockButtonCurrState = gamepad1.left_stick_button;
        if (lockButtonCurrState && !lockButtonPrevState) {
            isLocked = !isLocked; // Flip the lock state
        }
        lockButtonPrevState = lockButtonCurrState;


        // AprilTag Tracking and Correction Calculation
        double turnCorrection = 0.0;
        AprilTagDetection targetDetection = findTargetTag(); // Get detection via helper method

        if (isLocked) {
            if (targetDetection != null) {
                // Tag Found: P-Loop correction
                double headingError = targetDetection.ftcPose.yaw;
                
                // Negated headingError to flip the correction direction (if needed for centering)
                turnCorrection = -headingError * HEADING_P_GAIN; 
                
                // Clamp the correction power
                turnCorrection = Math.min(turnCorrection, MAX_TURN_POWER);
                turnCorrection = Math.max(turnCorrection, -MAX_TURN_POWER);

            } else {
                // Tag Lost: Stop auto-turning but keep lock active
                telemetry.addData("AprilTag Lock", "!! LOCKED BUT TAG LOST: Correction stopped !!");
                turnCorrection = 0.0;
            }
        }

        // Determine final rotational input (finalRx)
        // This is the auto-correction when locked, or the driver's input (rx) when unlocked.
        double finalRx = isLocked ? turnCorrection : rx;

        // Pass y, x (Field-Oriented translation) and finalRx (Rotation) to the calculator
        double[] powers = FOcalc.calculateFODMotorPowers(y,x,finalRx, odometry.robotPos().getHeading(AngleUnit.RADIANS));
        bot.setMotorPowers(powers[0], powers[1], powers[2], powers[3], SPEED_MULTIPLIER);
        // ------------------------------------------
        
        
        // ************* FlyWheel **************//
        // Flywheel
        if (gamepad1.dpad_right) {
            bot.setFlywheel("full", flyWheelOffset);
        } else if (gamepad1.dpad_up) {
            bot.setFlywheel("half", flyWheelOffset);
        } else if (gamepad1.dpad_left) { // lt - 2
            bot.setFlywheel("full", -0.1);
        } else if (gamepad1.dpad_down) {
            bot.setFlywheel("less-half", flyWheelOffset);
        }

        if(gamepad1.left_trigger > 0.5) {
            bot.setFlywheel("off", 0);
        }

        // Flywheel Offsets
//        if (gamepad2.circle) {
//            flyWheelOffset +=1;
//        } else if (gamepad2.square){
//            flyWheelOffset -=1;
//        }

        // Intake
        if (gamepad1.circle) {
            bot.setIntake("full");
        } else if (gamepad1.triangle) {
            bot.setIntake("half");
        } else if (gamepad1.square) {
            bot.setIntake("off");
        }

        if (gamepad1.cross) {
            bot.setIntake("out");
        }

        // Gate single
        if (gamepad1.leftBumperWasPressed() && gateTimer.milliseconds() >= recoveryPause) {
            GateState = isWaitingGateState;
            bot.setServoPos(GateState);
            if (!isWaitingGateState) {
                gateTimer.reset();
            } else {
                cycleCounter =0;
            }
            isWaitingGateState = !isWaitingGateState;
        }

        // Gate multi
        if (gamepad1.rightBumperWasPressed() && gateTimer.milliseconds() >= recoveryPause){
            GateState = isWaitingGateState;
            bot.setServoPos(GateState);
            if (!isWaitingGateState) {
                gateTimer.reset();
                cycleCounter = 1; // Start multi-cycle
            } else {
                cycleCounter = 0; // Cancel cycles
            }
            isWaitingGateState = !isWaitingGateState;
        }

        // Check
        if (isWaitingGateState && gateTimer.milliseconds() >= recoveryPause) {
            GateState = true;
            bot.setServoPos(true);
            isWaitingGateState = false;

            if (cycleCounter > 0 && cycleCounter < MAX_CYCLES) {
                cycleCounter++;
                gateTimer.reset();
            } else {
                cycleCounter = 0;
            }
        }
        // multi cycle Continuation

        if (!isWaitingGateState && cycleCounter > 0 && gateTimer.milliseconds() >= recoveryDelay) {
            GateState = false;
            bot.setServoPos(false);
            isWaitingGateState = true;
            gateTimer.reset();
        }

        // redundancy
        if (GateState) {
            bot.setServoPos(true);
        }

        // Telemetry
        telemetry.addData("Flywheel: ", bot.Flywheel.getPower());
        telemetry.addData("Intake: ", bot.Intake.getPower());
        telemetry.addData("GatePOS: ", bot.Gate.getPosition());
        telemetry.addData("GateTimer:", gateTimer.milliseconds());
        telemetry.addData("GateState", GateState);
        telemetry.addData("GatePause:", recoveryPause);
        telemetry.addData("IMU Status:", backButtonCurrState ? "RESETTING..." : "Ready (Press SHARE)");


        // --- APRILTAG TELEMETRY ---
        telemetry.addData("--- AprilTag Lock (L3) ---", "");
        telemetry.addData("Lock Status", isLocked ? "LOCKED" : "UNLOCKED");
        if (targetDetection != null) {
            telemetry.addData("Tag ID / Yaw Error", "%d / %.2f deg", targetDetection.id, targetDetection.ftcPose.yaw);
        } else {
            telemetry.addData("Tag Status", "NOT FOUND (ID %d)", TARGET_TAG_ID);
        }
        telemetry.addData("Turn Correction", isLocked ? turnCorrection : "N/A");
        // --------------------------------------

        telemetry.addData("\nFL: ", bot.leftFrontDrive.getPower());
        telemetry.addData("BL: ", bot.leftBackDrive.getPower());
        telemetry.addData("FR: ", bot.rightFrontDrive.getPower());
        telemetry.addData("BR: ", bot.rightBackDrive.getPower());

        telemetry.addData("\n\n Full Power: ", SPEED_MULTIPLIER);

        telemetry.update();


        // FTC Dashboard Telemetry + Graph
        dashboardTelemetry.addData("Flywheel Power: ", bot.Flywheel.getPower());
        dashboardTelemetry.addData("Intake Power: ", bot.Intake.getPower());
        dashboardTelemetry.addData("FL: ", bot.leftFrontDrive.getPower());
        dashboardTelemetry.addData("BL: ", bot.leftBackDrive.getPower());
        dashboardTelemetry.addData("FR: ", bot.rightFrontDrive.getPower());
        dashboardTelemetry.addData("BR: ", bot.rightBackDrive.getPower());

        dashboardTelemetry.addData("\nGateTimer:", gateTimer.milliseconds());
        dashboardTelemetry.addData("GateState", GateState);
        dashboardTelemetry.addData("GatePause:", recoveryPause);

        telemetry.addData("\n\n Power: ", SPEED_MULTIPLIER);

        dashboardTelemetry.update();

    }

    @Override
    public void stop() {
        // Close the vision portal safely when the OpMode ends
        if (visionPortal != null) {
            visionPortal.close();
        }
        super.stop();
    }


    /** Helper method to find the target AprilTag in the current list of detections. */
    private AprilTagDetection findTargetTag() {
        // The processor might not be ready right at the start of loop()
        if (aprilTagProcessor == null) return null; 
        
        List<AprilTagDetection> currentDetections = aprilTagProcessor.getDetections();
        for (AprilTagDetection detection : currentDetections) {
            // Look for the specific target tag ID
            if (detection.id == TARGET_TAG_ID) {
                return detection;
            }
        }
        return null;
    }
}