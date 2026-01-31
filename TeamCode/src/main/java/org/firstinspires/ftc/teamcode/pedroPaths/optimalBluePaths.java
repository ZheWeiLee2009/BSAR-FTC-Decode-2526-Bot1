package org.firstinspires.ftc.teamcode.pedroPaths;

import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.BezierCurve;
import com.pedropathing.geometry.BezierLine;
import com.pedropathing.geometry.Pose;
import com.pedropathing.paths.PathChain;

public class optimalBluePaths {
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

    public optimalBluePaths(Follower follower) {
        preload = follower.pathBuilder().addPath(
                        new BezierLine(
                                new Pose(18.155, 121.307),

                                new Pose(53.020, 89.948)
                        )
                ).setLinearHeadingInterpolation(Math.toRadians(143), Math.toRadians(134))
                .setTimeoutConstraint(50)
                .build();

        entry1 = follower.pathBuilder().addPath(
                        new BezierCurve(
                                new Pose(53.020, 89.948),
                                new Pose(44.523, 82.909),
                                new Pose(14.700, 83.760)
                        )
                ).setTangentHeadingInterpolation()
                .build();

        exit1 = follower.pathBuilder().addPath(
                        new BezierLine(
                                new Pose(14.700, 83.760),

                                new Pose(53.433, 89.948)
                        )
                ).setLinearHeadingInterpolation(Math.toRadians(180), Math.toRadians(134))
                .setTimeoutConstraint(50)
                .build();

        align2 = follower.pathBuilder().addPath(
                        new BezierLine(
                                new Pose(53.433, 89.948),

                                new Pose(43.218, 59.209)
                        )
                ).setLinearHeadingInterpolation(Math.toRadians(134), Math.toRadians(180))
                .setTimeoutConstraint(100)
                .build();

        entry2 = follower.pathBuilder().addPath(
                        new BezierLine(
                                new Pose(43.218, 59.209),

                                new Pose(11.500, 59.209)
                        )
                ).setTangentHeadingInterpolation()

                .build();

        exit2 = follower.pathBuilder().addPath(
                        new BezierCurve(
                                new Pose(11.500, 59.209),
                                new Pose(47.162, 57.495),
                                new Pose(53.226, 89.948)
                        )
                ).setLinearHeadingInterpolation(Math.toRadians(180), Math.toRadians(134))
                .setTimeoutConstraint(50)
                .build();

        align3 = follower.pathBuilder().addPath(
                        new BezierLine(
                                new Pose(53.226, 89.948),

                                new Pose(43.218, 36.000)
                        )
                ).setLinearHeadingInterpolation(Math.toRadians(134), Math.toRadians(180))
                .setTimeoutConstraint(100)
                .build();

        entry3 = follower.pathBuilder().addPath(
                        new BezierLine(
                                new Pose(43.218, 36.000),

                                new Pose(10.270, 36.000)
                        )
                ).setTangentHeadingInterpolation()

                .build();

        exit3 = follower.pathBuilder().addPath(
                        new BezierLine(
                                new Pose(10.270, 36.000),

                                new Pose(53.226, 89.948)
                        )
                ).setLinearHeadingInterpolation(Math.toRadians(180), Math.toRadians(134))

                .build();

        leave = follower.pathBuilder().addPath(
                        new BezierLine(
                                new Pose(53.226, 89.948),

                                new Pose(40.377, 63.111)
                        )
                ).setLinearHeadingInterpolation(Math.toRadians(134), Math.toRadians(180))
                .setNoDeceleration()
                .build();
    }
}
