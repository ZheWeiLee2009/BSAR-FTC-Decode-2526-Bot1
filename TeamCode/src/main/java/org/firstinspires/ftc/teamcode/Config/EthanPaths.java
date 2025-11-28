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

    public EthanPaths(Follower follower) {
        Path1 = follower
                .pathBuilder()
                .addPath(
                        new BezierCurve(
                                new Pose(23.931, 129.765),
                                new Pose(48.481, 96.138),
                                new Pose(63.865, 84.462)
                        )
                )
                .setLinearHeadingInterpolation(Math.toRadians(143), Math.toRadians(131))
                .build();

        Path2 = follower
                .pathBuilder()
                .addPath(
                        new BezierLine(new Pose(63.865, 84.462), new Pose(23.538, 84.981))
                )
                .setTangentHeadingInterpolation()
                .build();

        Path3 = follower
                .pathBuilder()
                .addPath(
                        new BezierCurve(
                                new Pose(23.538, 84.981),
                                new Pose(60.577, 70.615),
                                new Pose(63.692, 84.635)
                        )
                )
                .setTangentHeadingInterpolation()
                .build();

        Path4 = follower
                .pathBuilder()
                .addPath(
                        new BezierCurve(
                                new Pose(63.692, 84.635),
                                new Pose(61.615, 54.346),
                                new Pose(20.011, 59.415)
                        )
                )
                .setTangentHeadingInterpolation()
                .build();

        Path5 = follower
                .pathBuilder()
                .addPath(
                        new BezierCurve(
                                new Pose(20.011, 59.415),
                                new Pose(66.288, 58.154),
                                new Pose(63.692, 84.115)
                        )
                )
                .setTangentHeadingInterpolation()
                .build();

        Path6 = follower
                .pathBuilder()
                .addPath(
                        new BezierCurve(
                                new Pose(63.692, 84.115),
                                new Pose(52.788, 57.981),
                                new Pose(10.904, 61.615)
                        )
                )
                .setTangentHeadingInterpolation()
                .build();
    }
}
