package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.Pose;
import org.firstinspires.ftc.teamcode.Config.Drivetrain; // Robo Config
import org.firstinspires.ftc.teamcode.Config.EthanPaths;
import org.firstinspires.ftc.teamcode.pedroPathing.Constants;

@Autonomous(name = "EthanEXPedroMulti", group = "Autonomous")
public class EthanPedroExAuto extends LinearOpMode {
    Drivetrain bot;
    private Follower follower;
    private EthanPaths paths;

    @Override
    public void runOpMode() throws InterruptedException {

        follower = Constants.createFollower(hardwareMap);
        follower.setStartingPose(new Pose(24, 129.77, Math.toRadians(143)));

        paths = new EthanPaths(follower);

        telemetry.addLine("Ethan Pedro Pathing Ready!");
        telemetry.update();

        waitForStart();

        if (isStopRequested()) return;

        // Sequentially follow all paths
        bot.setIntake("full");
        follow(paths.Path1);
        sleep(1000);
        bot.setFlywheel("full", 0);
        sleep(1000);
        follow(paths.Path2);
        follow(paths.Path3);
        follow(paths.Path4);
        follow(paths.Path5);

        telemetry.addLine("✅ All paths complete!");
        telemetry.update();
        sleep(1000);
    }

    /** Helper method to follow one path and wait for completion */
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
        sleep(250); // small pause between paths (optional)
    }
}