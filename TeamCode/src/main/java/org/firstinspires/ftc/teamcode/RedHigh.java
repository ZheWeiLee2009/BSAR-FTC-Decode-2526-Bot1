package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.util.ElapsedTime;

import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.Pose;

import org.firstinspires.ftc.teamcode.Config.Drivetrain;
import org.firstinspires.ftc.teamcode.Config.RedPaths;
import org.firstinspires.ftc.teamcode.pedroPathing.Constants;

import static org.firstinspires.ftc.teamcode.Config.RobotConstants.recoveryDelay;

@Autonomous(name = "RedHigh", group = "Autonomous")
public class RedHigh extends LinearOpMode {

    private Drivetrain bot;
    private Follower follower;
    private RedPaths paths;
    private DcMotorEx Flywheel;

    private final int shootingVelocity = 1480;
    private final int shootingV2 = 1330;

    @Override
    public void runOpMode() throws InterruptedException {

        bot = new Drivetrain(hardwareMap, new ElapsedTime());
        bot.setServoPos(true);
        bot.setIntake("off");

        follower = Constants.createFollower(hardwareMap);

        // Mirrored start of (24,129,143°) → (-24,129,37°)
        follower.setStartingPose(new Pose(125.84527220630372, 121.30659025787965, Math.toRadians(37)));

        paths = new RedPaths(follower);

        telemetry.addLine("Red Auto Ready!");
        telemetry.update();
        Flywheel = hardwareMap.get(DcMotorEx.class, "Flywheel");
        waitForStart();
        if (isStopRequested()) return;


        // ============================
        //       AUTON SEQUENCE
        // ============================

        Flywheel.setVelocity(shootingV2);

        bot.setMotorPowers(1, 1, 1, 1, .85);
        follower.setMaxPower(.85);
        bot.setIntake("full");
        Flywheel.setVelocity(shootingV2);

        follow(paths.Path1);

        // PRELOAD SHOOTING
        bot.setIntake("half");
        Flywheel.setVelocity(shootingV2);
        shootTriple();

        //bot.setIntake("off");=
        //Flywheel.setVelocity(0);

        // ------- CYCLE 1 -------
        Flywheel.setVelocity(shootingVelocity);

        bot.setIntake("full");
        follow(paths.Path2);
        sleep(10);
        follow(paths.Path3);
        bot.setIntake("half");
        shootTriple();


        //bot.setIntake("off");=
        //Flywheel.setVelocity(0);

        // ------- CYCLE 2 -------
        bot.setIntake("full");
        follow(paths.Path4);
        sleep(10);
        follow(paths.Path5);

        //bot.setIntake("half");=
        Flywheel.setVelocity(shootingVelocity);
        shootTriple();

        //Flywheel.setVelocity(0);
        //bot.setIntake("off");=
        // ----CYCLE 3---------
        bot.setIntake("full");
        follow(paths.Path6);
        sleep(10);
        follow(paths.Path7);

        //bot.setIntake("half");=
        shootTriple();

       // bot.setIntake("off");=

        telemetry.addLine("Auton Complete.");
        telemetry.update();
//        sleep(500);
    }

    // ========================
    // Helper Methods
    // ========================

    private void shootTriple() throws InterruptedException {
        Flywheel.setVelocity(shootingVelocity);
//        sleep(1600); // orig: 1600
        bot.fullDown();
//        for (int i = 0; i < 3; i++) {
//            bot.fullDown();
//            sleep(160);
//            bot.setServoPos(true);
//            sleep(1200); // orig: 1200
//        }
        sleep(recoveryDelay);
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
