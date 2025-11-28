package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.Pose;

import org.firstinspires.ftc.teamcode.Config.Drivetrain;
import org.firstinspires.ftc.teamcode.Config.RedPaths;
import org.firstinspires.ftc.teamcode.pedroPathing.Constants;

@Autonomous(name = "RedHighAuto", group = "Autonomous")
public class RedHigh extends LinearOpMode {

    private Drivetrain bot;
    private Follower follower;
    private RedPaths paths;

    @Override
    public void runOpMode() throws InterruptedException {

        bot = new Drivetrain(hardwareMap, new ElapsedTime());
        bot.setServoPos(true);
        bot.setIntake("off");
        bot.setFlywheel("half", 0);

        follower = Constants.createFollower(hardwareMap);

        // Mirrored start of (24,129,143°) → (-24,129,37°)
        follower.setStartingPose(new Pose(-24, 129.77, Math.toRadians(37)));

        paths = new RedPaths(follower);

        telemetry.addLine("Red Auto Ready!");
        telemetry.update();

        waitForStart();
        if (isStopRequested()) return;

        // ===== PRELOADS =====
        bot.setIntake("full");
        follow(paths.Path1);

        // 3 SHOTS (MATCHING BLUE)
        bot.setIntake("half"); // half
        bot.setFlywheel("half", -0.05);

        sleep(2000);
        bot.setServoPos(true);
        sleep(250);
        bot.setServoPos(false);

        sleep(2000);
        bot.setFlywheel("half",0);
        bot.setServoPos(true);
        sleep(250);
        bot.setServoPos(false);

        sleep(2500);
        bot.setFlywheel("half",0);
        bot.setServoPos(true);
        sleep(500);
        bot.setServoPos(false);
        sleep(2500);

        bot.setFlywheel("off", 0);
        bot.setIntake("off");

        // ===== CYCLE 1 =====
        bot.setIntake("full");
        follow(paths.Path2);
        follow(paths.Path3);

        // 3 more SHOTS
        bot.setIntake("half");
        bot.setFlywheel("half", -0.1);

        sleep(2000); bot.setServoPos(true); sleep(167); sleep (6000); // bot.setServoPos(true); sleep(2000);
//        sleep(2000); bot.setServoPos(false); sleep(167); bot.setServoPos(true); sleep(2000);
//        sleep(2000); bot.setServoPos(false); sleep(167); bot.setServoPos(true); sleep(2000);

        bot.setFlywheel("off",0);
        bot.setIntake("off");

        // ===== CYCLE 2 =====
        bot.setIntake("half");
        follow(paths.Path4);
        follow(paths.Path5);
        bot.setFlywheel("half", -0.1);

        sleep(2000); bot.setServoPos(false); sleep(167); bot.setServoPos(true); sleep(2000);
        sleep(2000); bot.setServoPos(false); sleep(167); bot.setServoPos(true); sleep(2000);
        sleep(2000); bot.setServoPos(false); sleep(167); bot.setServoPos(true); sleep(2000);

        bot.setFlywheel("off",0);
        bot.setIntake("off");

        // Parking
        follow(paths.Path6);

        telemetry.addLine("✓ RED AUTO FINISHED");
        telemetry.update();
    }

    private void follow(com.pedropathing.paths.PathChain path) {
        follower.followPath(path);

        while (opModeIsActive() && follower.isBusy()) {
            follower.update();
        }

        follower.breakFollowing();
        sleep(250);
    }
}
