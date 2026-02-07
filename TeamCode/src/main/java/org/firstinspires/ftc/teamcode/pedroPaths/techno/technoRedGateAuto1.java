package org.firstinspires.ftc.teamcode.pedroPaths.techno;

import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.BezierCurve;
import com.pedropathing.geometry.BezierLine;
import com.pedropathing.geometry.Pose;
import com.pedropathing.paths.PathChain;

public class technoRedGateAuto1 {
    public PathChain preload;
    public PathChain entry1;
    public PathChain exit1;
    public PathChain gateOpen;
    public PathChain align2;
    public PathChain entry2;
    public PathChain exit2;
    public PathChain grabN1;
    public PathChain ExitN1;
    public PathChain leave;

    public technoRedGateAuto1(Follower follower) {
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
                                new Pose(108.437, 83.510),
                                new Pose(128.300, 83.760)
                        )
                ).setTangentHeadingInterpolation()

                .build();

        exit1 = follower.pathBuilder().addPath(
                        new BezierLine(
                                new Pose(128.300, 83.760),

                                new Pose(90.567, 89.948)
                        )
                ).setLinearHeadingInterpolation(Math.toRadians(0.000), Math.toRadians(46.000))
                .setTimeoutConstraint(50)
                .build();

        gateOpen = follower.pathBuilder().addPath(
                        new BezierCurve(
                                new Pose(90.567, 89.948),
                                new Pose(118.540, 77.335),
                                new Pose(128.800, 76.098)
                        )
                ).setConstantHeadingInterpolation(Math.toRadians(0.000))
                .setTimeoutConstraint(500)
                .build();

        align2 = follower.pathBuilder().addPath(
                        new BezierCurve(
                                new Pose(128.800, 76.098),
                                new Pose(68.078, 69.736),
                                new Pose(100.782, 59.209)
                        )
                ).setConstantHeadingInterpolation(Math.toRadians(0.000))
                .setTimeoutConstraint(50)
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
                                new Pose(100.700, 59.200),
                                new Pose(90.774, 89.948)
                        )
                ).setLinearHeadingInterpolation(Math.toRadians(0.000), Math.toRadians(46.000))
                .setTimeoutConstraint(50)
                .build();

        grabN1 = follower.pathBuilder().addPath(
                        new BezierLine(
                                new Pose(90.774, 89.948),

                                new Pose(130.000, 14.000)
                        )
                ).setTangentHeadingInterpolation()
                .setTimeoutConstraint(50)
                .build();

        ExitN1 = follower.pathBuilder().addPath(
                        new BezierLine(
                                new Pose(130.000, 14.000),

                                new Pose(90.774, 89.948)
                        )
                ).setLinearHeadingInterpolation(Math.toRadians(302.000), Math.toRadians(46.000))
                .setTimeoutConstraint(50)
                .build();

        leave = follower.pathBuilder().addPath(
                        new BezierLine(
                                new Pose(90.774, 89.948),

                                new Pose(111.588, 92)
                        )
                ).setLinearHeadingInterpolation(Math.toRadians(46.000), Math.toRadians(0.000))
                .setNoDeceleration()
                .build();
    }
}

  