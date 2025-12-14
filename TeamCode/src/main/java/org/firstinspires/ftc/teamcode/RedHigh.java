package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.teamcode.Config.RobotConstants.*;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.util.ElapsedTime;

import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.Pose;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Pose2D;
import org.firstinspires.ftc.teamcode.Config.Drivetrain;
import org.firstinspires.ftc.teamcode.Config.EthanPaths;
import org.firstinspires.ftc.teamcode.Config.Odometry;
import org.firstinspires.ftc.teamcode.Config.RedPaths;
import org.firstinspires.ftc.teamcode.pedroPathing.Constants;

import java.util.Locale;

@Autonomous(name = "RedHigh", group = "Autonomous")
public class RedHigh extends LinearOpMode {

    private Drivetrain bot;
    private Follower follower;
    private RedPaths paths;
    private DcMotorEx Flywheel;

    @Override
    public void runOpMode() throws InterruptedException {

        bot = new Drivetrain(hardwareMap, new ElapsedTime());
        bot.setServoPos(true);
        bot.setIntake("off");

        follower = Constants.createFollower(hardwareMap);

        // Mirrored start of (24,129,143°) → (-24,129,37°)
        follower.setStartingPose(new Pose(126.03973509933775, 120.95364238410596, Math.toRadians(37)));

        paths = new RedPaths(follower);

        telemetry.addLine("Red Auto Ready!");
        telemetry.update();
        Flywheel = hardwareMap.get(DcMotorEx.class, "Flywheel");
        waitForStart();
        if (isStopRequested()) return;

        // ============================
        //       AUTON SEQUENCE
        // ============================

        bot.setMotorPowers(1, 1, 1, 1, .6);
        follower.setMaxPower(.7);
        bot.setIntake("full");
        Flywheel.setVelocity(1502);
        follow(paths.Path1);

        // PRELOAD SHOOTING
        bot.setIntake("half");
        release();

        bot.setIntake("off");

        // ------- CYCLE 1 -------
        bot.setIntake("full");
        follower.setMaxPower(.5);
        follow(paths.Path2);
        sleep(900);
        follower.setMaxPower(.7);
        Flywheel.setVelocity(1502);
        follow(paths.Path3);

        bot.setIntake("half");
        release();

        bot.setIntake("off");

        // ------- CYCLE 2 -------
        bot.setIntake("half");
        release();

        bot.setIntake("off");

        follow(paths.Path6);

        telemetry.addLine("Auton Complete.");
        telemetry.update();
        sleep(500);
    }

    // ========================
    // Helper Methods
    // ========================
    private void release() throws InterruptedException{
        bot.setServoPos(false);
        sleep(3000);
        bot.setServoPos(true);
    }

    private void shootTriple() throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            sleep(160);
            bot.setServoPos(false);
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

//            Pose2D pos = odometry.odo.getPosition();
//            String data = String.format(Locale.US, "{X: %.3f, Y: %.3f, H: %.3f}", pos.getX(DistanceUnit.MM), pos.getY(DistanceUnit.MM), pos.getHeading(AngleUnit.DEGREES));
//            telemetry.addData("Position", data);

        }

        follower.breakFollowing();
        sleep(200);
    }
}