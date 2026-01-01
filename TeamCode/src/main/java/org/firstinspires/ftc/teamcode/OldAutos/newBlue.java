package org.firstinspires.ftc.teamcode.OldAutos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.util.ElapsedTime;

import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.Pose;

import org.firstinspires.ftc.teamcode.Config.Drivetrain;
import org.firstinspires.ftc.teamcode.Config.EthanPaths;
import org.firstinspires.ftc.teamcode.pedroPathing.Constants;

@Disabled
@Autonomous(name = "newBlue", group = "Autonomous")
public class newBlue extends LinearOpMode {

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


        bot.setMotorPowers(1, 1, 1, 1, .6);
        follower.setMaxPower(.7);
        bot.setIntake("full");

        follow(paths.Path1);

        // PRELOAD SHOOTING
        bot.setIntake("half");
        shootTriple();

        bot.setFlywheel("off", 0);
        bot.setIntake("off");

        bot.setServoPos(true);

        // ------- CYCLE 1 -------
        bot.setIntake("full");
        follow(paths.Path2);
        sleep(900);
        follow(paths.Path3);

        shootTriple();

        bot.setFlywheel("off", 0);
        bot.setIntake("off");
        bot.setServoPos(true);

        // ------- CYCLE 2 -------
        bot.setIntake("full");
        follow(paths.Path4);
        sleep(900);
        follow(paths.Path5);

        follower.setPose(
                new Pose(
                        53.226,
                        89.948,
                        Math.toRadians(143)
                ));

        shootTriple();

        bot.setFlywheel("off", 0);
        bot.setIntake("off");

        follow(paths.Path6);

        telemetry.addLine("Auton Complete.");
        telemetry.update();
        sleep(500);
    }

    // ========================
    // Helper Methods
    // ========================

    private void shootTriple() throws InterruptedException {
        Flywheel.setVelocity(1375);
        sleep(1500);
        bot.setServoPos(false);
        sleep(2500);
    }

//    private void shootTripleHalf() throws InterruptedException {
//        for (int i = 0; i < 3; i++) {
//            bot.setFlywheel("half", 0);
//            sleep(1400);
//            bot.setServoPos(false);
//            sleep(160);
//            bot.setServoPos(true);
//            sleep(1200);
//        }
//    }

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
