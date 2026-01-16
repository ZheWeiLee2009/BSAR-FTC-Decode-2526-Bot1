package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.Pose;

import org.firstinspires.ftc.teamcode.Config.Drivetrain;
import org.firstinspires.ftc.teamcode.pedroPaths.bluePaths;
import org.firstinspires.ftc.teamcode.pedroPathing.Constants;

import static org.firstinspires.ftc.teamcode.Config.RobotConstants.fullCloseShootingVelocity;
import static org.firstinspires.ftc.teamcode.Config.RobotConstants.midCloseShootingVelocity;
import static org.firstinspires.ftc.teamcode.Config.RobotConstants.recoveryDelay;

@Autonomous(name = "BlueHigh", group = "Autonomous")
public class blueHigh extends LinearOpMode {

    private Drivetrain bot;
    private Follower follower;
    private bluePaths paths;

    private final int shootingVel1 = fullCloseShootingVelocity;
    private final int shootingVel2 = midCloseShootingVelocity;

    @Override
    public void runOpMode() throws InterruptedException {

        bot = new Drivetrain(hardwareMap, new ElapsedTime());
        bot.setServoPos(true);
        bot.setIntake("off");

        follower = Constants.createFollower(hardwareMap);

        // Starting position of Robot
        follower.setStartingPose(new Pose(18.155, 121.307, Math.toRadians(143)));

        paths = new bluePaths(follower);

        telemetry.addLine("Blue Auto Ready!");
        telemetry.update();

        waitForStart();
        if (isStopRequested()) return;


        // ============================
        //       AUTON SEQUENCE
        // ============================

        bot.Flywheel.setVelocity(shootingVel2);

        bot.setMotorPowers(1, 1, 1, 1, .85);
        follower.setMaxPower(.85);
        bot.setIntake("full");

        follow(paths.Path1);

        // PRELOAD SHOOTING
        bot.setIntake("half");
        bot.Flywheel.setVelocity(shootingVel1);
        shootTriple();

//        bot.setIntake("off");
//        bot.Flywheel.setVelocity(0);

        // ------- CYCLE 1 -------
        bot.Flywheel.setVelocity(shootingVel1);

        bot.setIntake("full");
        bot.setMotorPowers(1, 1, 1, 1, .70);
        follower.setMaxPower(.70);
        follow(paths.Path2);
        sleep(10);
        bot.setMotorPowers(1, 1, 1, 1, .85);
        follower.setMaxPower(.85);
        follow(paths.Path3);
        bot.setIntake("half");
        shootTriple();


//        bot.setIntake("off");
//        Flywheel.setVelocity(0);

        // ------- CYCLE 2 -------
        bot.setIntake("full");
        bot.setMotorPowers(1, 1, 1, 1, .8);
        follower.setMaxPower(.8);
        follow(paths.Path4);
        bot.setMotorPowers(1, 1, 1, 1, .85);
        follower.setMaxPower(.85);
        sleep(10);
        follow(paths.Path5);

//        bot.setIntake("half");
        bot.Flywheel.setVelocity(shootingVel1);
        shootTriple();

//        bot.Flywheel.setVelocity(0);
//        bot.setIntake("off");
        // ----CYCLE 3---------
        bot.setIntake("full");
        bot.setMotorPowers(1, 1, 1, 1, .7);
        follower.setMaxPower(.7);
        follow(paths.Path6);
        bot.setMotorPowers(1, 1, 1, 1, .85);
        follower.setMaxPower(.85);
        sleep(10);
        follow(paths.Path7);

//        bot.setIntake("half");
        shootTriple();

        bot.setIntake("off");
        bot.Flywheel.setVelocity(0);
        follower.setMaxPower(1.0);
        follow(paths.Path8);

        telemetry.addLine("Auton Complete.");
        telemetry.update();
    }

    // ========================
    // Helper Methods
    // ========================

    private void shootTriple() throws InterruptedException {
        bot.Flywheel.setVelocity(shootingVel1-17);
//        sleep(1600); // orig: 1600
        bot.fullDown();
//        for (int i = 0; i < 3; i++) {
//
//            sleep(160);
//            bot.setServoPos(true);
//            sleep(1200); // orig: 1200
//        }
        sleep(recoveryDelay + 150);
        bot.setServoPos(true);
    }

    private void shootTripleHalf() throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            bot.setFlywheel("half", 0);
            sleep(1400);
            bot.fullDown();
            sleep(160);
            bot.setServoPos(true);
            sleep(1200);
        }
    }

    private void follow(com.pedropathing.paths.PathChain path) {
        follower.followPath(path);

        while (opModeIsActive() && follower.isBusy()) {
            follower.update();

            telemetry.addData("Following", path);
            telemetry.addData("X", follower.getPose().getX());
            telemetry.addData("Y", follower.getPose().getY());
            telemetry.addData("Heading", Math.toDegrees(follower.getPose().getHeading()));
            telemetry.update();
        }

        follower.breakFollowing();
        sleep(200);
    }
}
