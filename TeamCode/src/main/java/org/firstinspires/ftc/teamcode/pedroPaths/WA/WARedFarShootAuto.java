package org.firstinspires.ftc.teamcode.pedroPaths.WA;

import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.BezierLine;
import com.pedropathing.geometry.Pose;
import com.pedropathing.paths.PathChain;

public class WARedFarShootAuto {
    public PathChain exit;
    public PathChain preload;
    public PathChain grab1;
    public PathChain exit1;
    public PathChain leave;

    public WARedFarShootAuto(Follower follower) {
        exit = follower.pathBuilder().addPath(
                        new BezierLine(
                                new Pose(88.000, 9.000),

                                new Pose(88.000, 14.000)
                        )
                ).setLinearHeadingInterpolation(Math.toRadians(90.000), Math.toRadians(90.000))

                .build();

        preload = follower.pathBuilder().addPath(
                        new BezierLine(
                                new Pose(88.000, 14.000),

                                new Pose(84.000, 14.000)
                        )
                ).setConstantHeadingInterpolation(Math.toRadians(72.000))
                .setTimeoutConstraint(500)
                .build();

        grab1 = follower.pathBuilder().addPath(
                        new BezierLine(
                                new Pose(84.000, 14.000),

                                new Pose(130.408, 11.745)
                        )
                ).setTangentHeadingInterpolation()

                .build();

        exit1 = follower.pathBuilder().addPath(
                        new BezierLine(
                                new Pose(130.408, 11.745),

                                new Pose(84.000, 14.000)
                        )
                ).setLinearHeadingInterpolation(Math.toRadians(0.000), Math.toRadians(72.000))
                .setTimeoutConstraint(500)
                .build();

        leave = follower.pathBuilder().addPath(
                        new BezierLine(
                                new Pose(84.000, 14.000),

                                new Pose(111.153, 14.013)
                        )
                ).setTangentHeadingInterpolation()
                .setNoDeceleration()
                .build();
    }
}