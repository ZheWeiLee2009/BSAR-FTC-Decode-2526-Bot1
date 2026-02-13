package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.teamcode.Config.RobotConstants.fullCloseShootingVelocity;
import static org.firstinspires.ftc.teamcode.Config.RobotConstants.midCloseShootingVelocity;
import static org.firstinspires.ftc.teamcode.Config.RobotConstants.recoveryDelay;

import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.Pose;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Config.Drivetrain;
import org.firstinspires.ftc.teamcode.pedroPathing.Constants;
import org.firstinspires.ftc.teamcode.pedroPaths.optimalRedPathsGate;

@Autonomous(name = "optimalRedHighGate", group = ".")
public class optimalRedHighGate extends LinearOpMode {

    private Drivetrain bot;
    private Follower follower;

    private final int standardShootingVel = fullCloseShootingVelocity;
    private final int closerShootingVel = midCloseShootingVelocity;


    public void runOpMode() throws InterruptedException{

        // initialization
        bot = new Drivetrain(hardwareMap, new ElapsedTime());
        bot.setServoPos(true);
        bot.setIntake("off");

        follower = Constants.createFollower(hardwareMap);

        // Starting position of Robot
        follower.setStartingPose(new Pose(125.845, 121.307, Math.toRadians(37)));

        optimalRedPathsGate paths;
        paths = new optimalRedPathsGate(follower);

        telemetry.addLine("Red Auto Ready!");
        telemetry.update();

        waitForStart();
        if (isStopRequested()) return;

        // Start
        bot.Flywheel.setVelocity(standardShootingVel);
        follower.setMaxPower(.85);
        bot.setIntake("full");

        // Cycle 1 (Preload)
        follow(paths.preload);
        bot.Flywheel.setVelocity(standardShootingVel);
        triRelease();

        // Cycle 2
        follower.setMaxPower(.80);
        follow(paths.entry1);
        follow(paths.gateOpen);
        follower.setMaxPower(.85);
        follow(paths.exit1);
        triRelease();

        // Cycle 3
        follower.setMaxPower(.80);
        follow(paths.align2);
        follow(paths.entry2);
        follower.setMaxPower(.85);
        follow(paths.exit2);
        triRelease();

        // Cycle 4
        follower.setMaxPower(.80);
        follow(paths.align3);
        follow(paths.entry3);
        follower.setMaxPower(.85);
        follow(paths.exit3);
        triRelease();

        //Exit
        bot.setIntake("off");
        bot.Flywheel.setVelocity(0);
        follower.setMaxPower(1.0);

        follow(paths.leave);
        telemetry.addLine("Auto Complete.");
        telemetry.update();
    }

    // methods
    public void triRelease() throws InterruptedException {
        bot.Flywheel.setVelocity(standardShootingVel);
        bot.fullDown();
        sleep(recoveryDelay + 50);
        bot.setServoPos(true);
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