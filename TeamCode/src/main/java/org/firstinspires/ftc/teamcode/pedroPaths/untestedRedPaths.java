package org.firstinspires.ftc.teamcode.pedroPaths;

import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.BezierCurve;
import com.pedropathing.geometry.BezierLine;
import com.pedropathing.geometry.Pose;
import com.pedropathing.paths.PathChain;

public class untestedRedPaths {
    public PathChain preload;
    public PathChain entry1;
    public PathChain exit1;
    public PathChain align2;
    public PathChain entry2;
    public PathChain exit2;
    public PathChain align3;
    public PathChain entry3;
    public PathChain exit3;
    public PathChain leave;

    public untestedRedPaths(Follower follower) {
        preload = follower.pathBuilder().addPath(
                        new BezierLine(
                                new Pose(125.845, 121.307),

                                new Pose(90.980, 89.948)
                        )
                ).setLinearHeadingInterpolation(Math.toRadians(37.000), Math.toRadians(46.000))
                .setTimeoutConstraint(50)
                .build();

        entry1 = follower.pathBuilder().addPath(
                        new BezierCurve(
                                new Pose(90.980, 89.948),
                                new Pose(99.477, 82.909),
                                new Pose(129.300, 83.760)
                        )
                ).setTangentHeadingInterpolation()
                .build();

        exit1 = follower.pathBuilder().addPath(
                        new BezierLine(
                                new Pose(129.300, 83.760),

                                new Pose(90.567, 89.948)
                        )
                ).setLinearHeadingInterpolation(Math.toRadians(0.000), Math.toRadians(46.000))
                .setTimeoutConstraint(50)
                .build();

        align2 = follower.pathBuilder().addPath(
                        new BezierLine(
                                new Pose(90.567, 89.948),

                                new Pose(100.782, 59.209)
                        )
                ).setLinearHeadingInterpolation(Math.toRadians(46.000), Math.toRadians(0.000))
                .setTimeoutConstraint(100)
                .build();

        entry2 = follower.pathBuilder().addPath(
                        new BezierLine(
                                new Pose(100.782, 59.209),

                                new Pose(132.500, 59.209)
                        )
                ).setTangentHeadingInterpolation()

                .build();

        exit2 = follower.pathBuilder().addPath(
                        new BezierCurve(
                                new Pose(132.500, 59.209),
                                new Pose(96.838, 57.495),
                                new Pose(90.774, 89.948)
                        )
                ).setLinearHeadingInterpolation(Math.toRadians(0.000), Math.toRadians(46.000))
                .setTimeoutConstraint(50)
                .build();

        align3 = follower.pathBuilder().addPath(
                        new BezierLine(
                                new Pose(90.774, 89.948),

                                new Pose(100.782, 36.000)
                        )
                ).setLinearHeadingInterpolation(Math.toRadians(46.000), Math.toRadians(0.000))
                .setTimeoutConstraint(100)
                .build();

        entry3 = follower.pathBuilder().addPath(
                        new BezierLine(
                                new Pose(100.782, 36.000),

                                new Pose(133.730, 36.000)
                        )
                ).setTangentHeadingInterpolation()

                .build();

        exit3 = follower.pathBuilder().addPath(
                        new BezierLine(
                                new Pose(133.730, 36.000),

                                new Pose(90.774, 89.948)
                        )
                ).setLinearHeadingInterpolation(Math.toRadians(0.000), Math.toRadians(46.000))

                .build();

        leave = follower.pathBuilder().addPath(
                        new BezierLine(
                                new Pose(90.774, 89.948),

                                new Pose(103.623, 63.111)
                        )
                ).setLinearHeadingInterpolation(Math.toRadians(46.000), Math.toRadians(0.000))
                .setNoDeceleration()
                .build();
    }
}
