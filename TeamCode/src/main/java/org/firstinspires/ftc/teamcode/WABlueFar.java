package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.teamcode.Config.RobotConstants.FarShootingVelocity;
import static org.firstinspires.ftc.teamcode.Config.RobotConstants.recoveryDelay;
import static org.firstinspires.ftc.teamcode.Config.RobotConstants.autoRecoveryPause;

import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.Pose;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Config.Drivetrain;
import org.firstinspires.ftc.teamcode.pedroPathing.Constants;
import org.firstinspires.ftc.teamcode.pedroPaths.WA.WABlueFarShootAuto;

@Autonomous(name = "WABlueFar", group = "Weeping Angels")
public class WABlueFar extends LinearOpMode {

    private Drivetrain bot;
    private Follower follower;

    private final int standardShootingVel = FarShootingVelocity;


    public void runOpMode() throws InterruptedException{

        // initialization
        bot = new Drivetrain(hardwareMap, new ElapsedTime());
        bot.setServoPos(true);
        bot.setIntake("off");

        follower = Constants.createFollower(hardwareMap);

        // Starting position of Robot
        follower.setStartingPose(new Pose(56.000, 9.000, Math.toRadians(90)));

        WABlueFarShootAuto paths;
        paths = new WABlueFarShootAuto(follower);

        telemetry.addLine("Blue Auto Ready!");
        telemetry.update();

        waitForStart();
        if (isStopRequested()) return;

        // Start
        bot.Flywheel.setVelocity(standardShootingVel);
        follower.setMaxPower(.85);
        bot.setIntake("full");

        // Cycle 1 (Preload)
        follow(paths.exit);
        follower.setMaxPower(.8);
        follow(paths.preload);
        bot.Flywheel.setVelocity(standardShootingVel);
        sleep(1500);
        triTimedRelease();

        // extra Cycles 1 (gamble)
        bot.setIntake("full");
        follower.setMaxPower(.85);
        follow(paths.grab1);
        follower.setMaxPower(.8);
        follow(paths.exit1);
        bot.Flywheel.setVelocity(standardShootingVel);
        sleep(1500);
        triTimedRelease();

        // extra Cycles 1 (gamble)
        bot.setIntake("full");
        follower.setMaxPower(.85);
        follow(paths.grab1);
        follower.setMaxPower(.8);
        follow(paths.exit1);
        bot.Flywheel.setVelocity(standardShootingVel);
        sleep(1500);
        triTimedRelease();


        //Exit
        bot.setIntake("off");
        bot.Flywheel.setVelocity(0);
        follower.setMaxPower(1.0);

        follow(paths.leave);
        telemetry.addLine("Auto Complete.");
        telemetry.update();

    }

    // methods
    public void triTimedRelease() throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            bot.Flywheel.setVelocity(standardShootingVel);
            bot.setIntake("full");
            bot.fullDown();
            sleep(autoRecoveryPause);
            bot.setServoPos(true);
            bot.setIntake("half");
            sleep(recoveryDelay + 50);
        }
            sleep(recoveryDelay + 50);
            bot.Flywheel.setVelocity(standardShootingVel); //redundancy

    }

    private void follow(com.pedropathing.paths.PathChain path) {
        follower.followPath(path);

        while (opModeIsActive() && follower.isBusy()) {
            follower.update();

            telemetry.addData("Following", path);
            telemetry.addData("X", follower.getPose().getX());
            telemetry.addData("Y", follower.getPose().getY());
            telemetry.addData("Heading", Math.toDegrees(follower.getPose().getHeading()));

            telemetry.addData("\n\nFlywheel: ", bot.Flywheel.getPower());
            telemetry.addData("TPS:", bot.Flywheel.getVelocity());
            telemetry.addData("Intake: ", bot.Intake.getPower());

            telemetry.addData("\nFL: ", bot.leftFrontDrive.getPower());
            telemetry.addData("BL: ", bot.leftBackDrive.getPower());
            telemetry.addData("FR: ", bot.rightFrontDrive.getPower());
            telemetry.addData("BR: ", bot.rightBackDrive.getPower());

            telemetry.update();
        }

        follower.breakFollowing();
        sleep(50);
    }
}