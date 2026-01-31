package org.firstinspires.ftc.teamcode.pedroPaths;

import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.BezierCurve;
import com.pedropathing.geometry.BezierLine;
import com.pedropathing.geometry.Pose;
import com.pedropathing.paths.PathChain;

public class U_bluePartnerPaths {
    public PathChain preload;
    public PathChain entry1;
    public PathChain gateOpen;
    public PathChain exit1;
    public PathChain align2;
    public PathChain entry2;
    public PathChain exit2;
    public PathChain grabN1;
    public PathChain ExitN1;
    public PathChain leave;

    public U_bluePartnerPaths(Follower follower) {
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
                                new Pose(35.563, 83.510),
                                new Pose(15.700, 83.760)
                        )
                ).setTangentHeadingInterpolation()

                .build();

        gateOpen = follower.pathBuilder().addPath(
                        new BezierCurve(
                                new Pose(15.700, 83.760),
                                new Pose(25.460, 77.335),
                                new Pose(15.200, 76.098)
                        )
                ).setConstantHeadingInterpolation(Math.toRadians(180))
                .setTimeoutConstraint(500)
                .build();

        exit1 = follower.pathBuilder().addPath(
                        new BezierLine(
                                new Pose(15.200, 76.098),

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
                .setTimeoutConstraint(50)
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
                                new Pose(43.300, 59.200),
                                new Pose(53.226, 89.948)
                        )
                ).setLinearHeadingInterpolation(Math.toRadians(180), Math.toRadians(134))
                .setTimeoutConstraint(50)
                .build();

        grabN1 = follower.pathBuilder().addPath(
                        new BezierLine(
                                new Pose(53.226, 89.948),

                                new Pose(11.818, 20.630)
                        )
                ).setTangentHeadingInterpolation()

                .build();

        ExitN1 = follower.pathBuilder().addPath(
                        new BezierLine(
                                new Pose(11.818, 20.630),

                                new Pose(53.226, 89.948)
                        )
                ).setLinearHeadingInterpolation(Math.toRadians(238), Math.toRadians(134))
                .setTimeoutConstraint(50)
                .build();

        leave = follower.pathBuilder().addPath(
                        new BezierLine(
                                new Pose(53.226, 89.948),

                                new Pose(32.412, 77.323)
                        )
                ).setLinearHeadingInterpolation(Math.toRadians(134), Math.toRadians(180))
                .setNoDeceleration()
                .build();
    }
}
  