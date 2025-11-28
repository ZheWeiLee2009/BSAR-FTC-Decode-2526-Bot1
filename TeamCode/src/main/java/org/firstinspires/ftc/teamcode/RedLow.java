package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.Pose;

import org.firstinspires.ftc.teamcode.Config.Drivetrain;
import org.firstinspires.ftc.teamcode.Config.RedPaths;
import org.firstinspires.ftc.teamcode.pedroPathing.Constants;

@Autonomous(name = "RedLowAuto", group = "Autonomous")
public class RedLow extends LinearOpMode {

    private Drivetrain bot;
    private Follower follower;
    private RedPaths paths;

    @Override
    public void runOpMode() throws InterruptedException {

        // --- Drivetrain & mechanisms ---
        bot = new Drivetrain(hardwareMap, new ElapsedTime());
        bot.setServoPos(true);      // gate closed start
        bot.setIntake("off");
        bot.setFlywheel("off", 0);

        // --- Follower + paths (RED mirrored) ---
        follower = Constants.createFollower(hardwareMap);

        // Blue (24,129,143°) → Red (-24,129,37°)
        follower.setStartingPose(new Pose(-24, 129.77, Math.toRadians(37)));

        paths = new RedPaths(follower);

        telemetry.addLine("Red Low Auto Ready!");
        telemetry.update();

        waitForStart();
        if (isStopRequested()) return;

        // =========================================
        //               PRELOADS
        // =========================================
        bot.setIntake("full");
        follow(paths.Path1);

        // --- 3 SHOTS (FULL flywheel for LOW AUTO) ---
        bot.setIntake("half");
        bot.setFlywheel("full", -0.1);

        sleep(1400); bot.setServoPos(false); sleep(200); bot.setServoPos(true); sleep(1400);
        sleep(1400); bot.setServoPos(false); sleep(200); bot.setServoPos(true); sleep(1400);
        sleep(1400); bot.setServoPos(false); sleep(200); bot.setServoPos(true); sleep(1400);

        bot.setFlywheel("off", 0);
        bot.setIntake("off");

        // =========================================
        //              CYCLE 1
        // =========================================
        bot.setIntake("full");
        follow(paths.Path2);
        follow(paths.Path3);

        bot.setIntake("half");
        bot.setFlywheel("full", -0.1);

        sleep(1400); bot.setServoPos(false); sleep(200); bot.setServoPos(true); sleep(1400);
        sleep(1400); bot.setServoPos(false); sleep(200); bot.setServoPos(true); sleep(1400);
        sleep(1400); bot.setServoPos(false); sleep(200); bot.setServoPos(true); sleep(1400);

        bot.setFlywheel("off", 0);
        bot.setIntake("off");

        // =========================================
        //              CYCLE 2
        // =========================================
        bot.setIntake("half");
        bot.setFlywheel("full", -0.1);

        sleep(1400); bot.setServoPos(false); sleep(200); bot.setServoPos(true); sleep(1400);
        sleep(1400); bot.setServoPos(false); sleep(200); bot.setServoPos(true); sleep(1400);
        sleep(1400); bot.setServoPos(false); sleep(200); bot.setServoPos(true); sleep(1400);

        bot.setFlywheel("off", 0);
        bot.setIntake("off");

        // =========================================
        //                 PARK
        // =========================================
        follow(paths.Path6);

        telemetry.addLine("✓ RED LOW AUTO FINISHED");
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
