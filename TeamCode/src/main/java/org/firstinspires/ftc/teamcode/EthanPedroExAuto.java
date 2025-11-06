package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.teamcode.Config.EthanPaths.Paths;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Config.EthanPaths;
import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.Pose;
import com.pedropathing.follower.FollowerConstants;

/**
 * Runs your EthanPaths.Path1 using PedroPathing
 */
@Autonomous(name = "EthanEXPedro", group = "Autonomous")
public class EthanPedroExAuto extends LinearOpMode {

    private Follower follower;
    private EthanPaths.Paths paths;

    @Override
    public void runOpMode() throws InterruptedException {

        // Initialize Pedro follower
        follower = org.firstinspires.ftc.teamcode.pedroPathing.Constants.createFollower(hardwareMap);

        // Set starting position
        follower.setStartingPose(new Pose(72, 8, Math.toRadians(90)));

        // Build paths from EthanPaths
        paths = new EthanPaths.Paths(follower);

        telemetry.addLine("Ethan Pedro Pathing Ready!");
        telemetry.update();

        waitForStart();

        if (isStopRequested()) return;

        // Follow your first path
        follower.followPath(paths.Path1);

        // Keep updating follower until done
        while (opModeIsActive() && follower.isBusy()) {
            follower.update();

            telemetry.addData("X", follower.getPose().getX());
            telemetry.addData("Y", follower.getPose().getY());
            telemetry.addData("Heading", Math.toDegrees(follower.getPose().getHeading()));
            telemetry.update();
        }

        // Stop motors when path finishes
        follower.breakFollowing();
    }
}
