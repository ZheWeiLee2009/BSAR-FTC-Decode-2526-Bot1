package org.firstinspires.ftc.teamcode.Config;

import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.BezierCurve;
import com.pedropathing.geometry.BezierLine;
import com.pedropathing.geometry.Pose;
import com.pedropathing.paths.PathChain;

public class EthanPaths {

    public PathChain Path1;
    public PathChain Path2;
    public PathChain Path3;
    public PathChain Path4;
    public PathChain Path5;
    public PathChain Path6;
    public PathChain Path7;

    public EthanPaths(Follower follower) {

        Path1 = follower
                .pathBuilder()
                .addPath(
                        new BezierLine(
                                new Pose(18.155, 121.307),
                                new Pose(53.020, 89.948)
                        )
                )
                .setLinearHeadingInterpolation(
                        Math.toRadians(143),
                        Math.toRadians(134)
                )
                .build();

        Path2 = follower
                .pathBuilder()
                .addPath(
                        new BezierCurve(
                                new Pose(53.020, 89.948),
                                new Pose(81.060, 73.748),
                                new Pose(21.775, 83.762)
                        )
                )
                .setLinearHeadingInterpolation(
                        Math.toRadians(134),
                        Math.toRadians(180)
                )
                .build();

        Path3 = follower
                .pathBuilder()
                .addPath(
                        new BezierCurve(
                                new Pose(21.775, 83.762),
                                new Pose(85.616, 63.748),
                                new Pose(53.433, 89.948)
                        )
                )
                .setLinearHeadingInterpolation(
                        Math.toRadians(180),
                        Math.toRadians(134)
                )
                .build();

        Path4 = follower
                .pathBuilder()
                .addPath(
                        new BezierCurve(
                                new Pose(53.433, 89.948),
                                new Pose(66.842, 61.891),
                                new Pose(19.393, 59.209)
                        )
                )
                .setLinearHeadingInterpolation(
                        Math.toRadians(134),
                        Math.toRadians(-177)
                )
                .build();

        Path5 = follower
                .pathBuilder()
                .addPath(
                        new BezierCurve(
                                new Pose(19.393, 59.209),
                                new Pose(84.585, 66.842),
                                new Pose(53.226, 89.948)
                        )
                )
                .setLinearHeadingInterpolation(
                        Math.toRadians(-177),
                        Math.toRadians(134)
                )
                .build();

        Path6 = follower
                .pathBuilder()
                .addPath(
                        new BezierCurve(
                                new Pose(53.226, 89.948),
                                new Pose(82.315, 34.659),
                                new Pose(16.298, 35.691)
                        )
                )
                .setLinearHeadingInterpolation(
                        Math.toRadians(134),
                        Math.toRadians(180)
                )
                .build();

        Path7 = follower
                .pathBuilder()
                .addPath(
                        new BezierCurve(
                                new Pose(16.298, 35.691),
                                new Pose(85.822, 56.115),
                                new Pose(53.226, 89.742)
                        )
                )
                .setLinearHeadingInterpolation(
                        Math.toRadians(180),
                        Math.toRadians(134)
                )
                .build();
    }
}
