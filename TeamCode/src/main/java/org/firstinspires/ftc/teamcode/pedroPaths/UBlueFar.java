package org.firstinspires.ftc.teamcode.pedroPaths;

import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.BezierCurve;
import com.pedropathing.geometry.BezierLine;
import com.pedropathing.geometry.Pose;
import com.pedropathing.paths.PathChain;

public class UBlueFar {
    public PathChain exit;
    public PathChain preload;
    public PathChain grab1;
    public PathChain exit1;
    public PathChain leave;

    public UBlueFar(Follower follower) {
        exit = follower.pathBuilder().addPath(
                        new BezierLine(
                                new Pose(56.000, 9.000),

                                new Pose(56.000, 14.000)
                        )
                ).setLinearHeadingInterpolation(Math.toRadians(90), Math.toRadians(90))

                .build();

        preload = follower.pathBuilder().addPath(
                        new BezierLine(
                                new Pose(56.000, 14.000),

                                new Pose(60.000, 14.000)
                        )
                ).setConstantHeadingInterpolation(Math.toRadians(105))
                .setTimeoutConstraint(500)
                .build();

        grab1 = follower.pathBuilder().addPath(
                        new BezierLine(
                                new Pose(60.000, 14.000),

                                new Pose(13.592, 11.745)
                        )
                ).setTangentHeadingInterpolation()

                .build();

        exit1 = follower.pathBuilder().addPath(
                        new BezierLine(
                                new Pose(13.592, 11.745),

                                new Pose(60.000, 14.000)
                        )
                ).setLinearHeadingInterpolation(Math.toRadians(180), Math.toRadians(105))
                .setTimeoutConstraint(500)
                .build();

        leave = follower.pathBuilder().addPath(
                        new BezierLine(
                                new Pose(60.000, 14.000),

                                new Pose(32.847, 14.013)
                        )
                ).setTangentHeadingInterpolation()
                .setNoDeceleration()
                .build();
    }
}