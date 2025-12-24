package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.teamcode.Config.RobotConstants.*;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.util.ElapsedTime;

import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.Pose;

import org.firstinspires.ftc.teamcode.Config.Drivetrain;
import org.firstinspires.ftc.teamcode.Config.EthanPaths;
import org.firstinspires.ftc.teamcode.pedroPathing.Constants;

@Autonomous(name = "BlueHigh", group = "Autonomous")
public class blueHigh extends LinearOpMode {

    private Drivetrain bot;
    private Follower follower;
    private EthanPaths paths;
    private DcMotorEx Flywheel;

    @Override
    public void runOpMode() throws InterruptedException {

        bot = new Drivetrain(hardwareMap, new ElapsedTime());
        bot.setServoPos(true);
        bot.setIntake("off");
        bot.setFlywheel("off", 0);

        follower = Constants.createFollower(hardwareMap);
        follower.setStartingPose(new Pose(18.155, 121.307, Math.toRadians(143)));

        paths = new EthanPaths(follower);

        Flywheel = hardwareMap.get(DcMotorEx.class, "Flywheel");

        waitForStart();
        if (isStopRequested()) return;

        // ============================
        //       AUTON SEQUENCE
        // ============================


        bot.setMotorPowers(1, 1, 1, 1, .85);
        follower.setMaxPower(.85);
        bot.setIntake("full");

        follow(paths.Path1);

        // PRELOAD SHOOTING
        bot.setIntake("half");
        Flywheel.setVelocity(1387);
        shootTriple();

        bot.setIntake("off");
        Flywheel.setVelocity(0);

        // ------- CYCLE 1 -------
        bot.setIntake("full");
        follow(paths.Path2);
        sleep(100);
        follow(paths.Path3);

        bot.setIntake("half");
        Flywheel.setVelocity(1387);
        shootTriple();


        bot.setIntake("off");
        Flywheel.setVelocity(0);

        // ------- CYCLE 2 -------
        bot.setIntake("full");
        follow(paths.Path4);
        sleep(100);
        follow(paths.Path5);

        bot.setIntake("half");
        Flywheel.setVelocity(1387);
        shootTriple();

        Flywheel.setVelocity(0);
        bot.setIntake("off");
        // ----CYCLE 3---------
        bot.setIntake("full");
        follow(paths.Path6);
        sleep(100);
        follow(paths.Path7);

        bot.setIntake("half");
        shootTriple();

        bot.setIntake("off");

        telemetry.addLine("Auton Complete.");
        telemetry.update();
        sleep(500);
    }

    // ========================
    // Helper Methods
    // ========================

    private void shootTriple() throws InterruptedException {
        Flywheel.setVelocity(1387);
        sleep(1600); // orig: 1600
        for (int i = 0; i < 3; i++) {
            bot.fullDown();
            sleep(160);
            bot.setServoPos(true);
            sleep(1200); // orig: 1200
        }
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
