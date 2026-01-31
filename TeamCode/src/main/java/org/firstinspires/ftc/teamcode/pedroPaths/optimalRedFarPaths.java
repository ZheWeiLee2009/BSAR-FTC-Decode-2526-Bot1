package org.firstinspires.ftc.teamcode.pedroPaths;

import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.BezierCurve;
import com.pedropathing.geometry.BezierLine;
import com.pedropathing.geometry.Pose;
import com.pedropathing.paths.PathChain;

public class optimalRedFarPaths {
    public PathChain preload;
    public PathChain align3;
    public PathChain entry3;
    public PathChain exit3;
    public PathChain leave;

    public optimalRedFarPaths(Follower follower) {
        preload = follower.pathBuilder().addPath(
                        new BezierLine(
                                new Pose(88.000, 8.000),

                                new Pose(88.000, 90.000)
                        )
                ).setLinearHeadingInterpolation(Math.toRadians(90.000), Math.toRadians(46.000))

                .build();

        align3 = follower.pathBuilder().addPath(
                        new BezierLine(
                                new Pose(88.000, 90.000),

                                new Pose(100.782, 34.924)
                        )
                ).setLinearHeadingInterpolation(Math.toRadians(46.000), Math.toRadians(0.000))

                .build();

        entry3 = follower.pathBuilder().addPath(
                        new BezierLine(
                                new Pose(100.782, 34.924),

                                new Pose(133.730, 34.924)
                        )
                ).setTangentHeadingInterpolation()

                .build();

        exit3 = follower.pathBuilder().addPath(
                        new BezierCurve(
                                new Pose(133.730, 34.924),
                                new Pose(87.280, 38.860),
                                new Pose(87.857, 89.799)
                        )
                ).setLinearHeadingInterpolation(Math.toRadians(0.000), Math.toRadians(46.000))

                .build();

        leave = follower.pathBuilder().addPath(
                        new BezierLine(
                                new Pose(87.857, 89.799),

                                new Pose(88.000, 38.000)
                        )
                ).setLinearHeadingInterpolation(Math.toRadians(46.000), Math.toRadians(0.000))

                .build();
    }
}
