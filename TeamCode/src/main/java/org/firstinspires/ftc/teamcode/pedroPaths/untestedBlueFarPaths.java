package org.firstinspires.ftc.teamcode.pedroPaths;

import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.BezierCurve;
import com.pedropathing.geometry.BezierLine;
import com.pedropathing.geometry.Pose;
import com.pedropathing.paths.PathChain;

public class untestedBlueFarPaths {
    public PathChain preload;
    public PathChain align3;
    public PathChain entry3;
    public PathChain exit3;
    public PathChain leave;

    public untestedBlueFarPaths(Follower follower) {
        preload = follower.pathBuilder().addPath(
                        new BezierLine(
                                new Pose(56.000, 8.000),

                                new Pose(56.000, 90.000)
                        )
                ).setLinearHeadingInterpolation(Math.toRadians(90), Math.toRadians(134))

                .build();

        align3 = follower.pathBuilder().addPath(
                        new BezierLine(
                                new Pose(56.000, 90.000),

                                new Pose(43.218, 34.924)
                        )
                ).setLinearHeadingInterpolation(Math.toRadians(134), Math.toRadians(180))

                .build();

        entry3 = follower.pathBuilder().addPath(
                        new BezierLine(
                                new Pose(43.218, 34.924),

                                new Pose(10.270, 34.924)
                        )
                ).setTangentHeadingInterpolation()

                .build();

        exit3 = follower.pathBuilder().addPath(
                        new BezierCurve(
                                new Pose(10.270, 34.924),
                                new Pose(56.720, 38.860),
                                new Pose(56.143, 89.799)
                        )
                ).setLinearHeadingInterpolation(Math.toRadians(180), Math.toRadians(134))

                .build();

        leave = follower.pathBuilder().addPath(
                        new BezierLine(
                                new Pose(56.143, 89.799),

                                new Pose(56.000, 38.000)
                        )
                ).setLinearHeadingInterpolation(Math.toRadians(134), Math.toRadians(180))

                .build();
    }
}
