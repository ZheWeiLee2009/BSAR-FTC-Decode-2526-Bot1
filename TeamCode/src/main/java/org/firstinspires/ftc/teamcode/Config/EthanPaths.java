package org.firstinspires.ftc.teamcode.Config;

import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.BezierCurve;
import com.pedropathing.geometry.Pose;
import com.pedropathing.paths.PathChain;

public class EthanPaths {
    public PathChain Path1;
    public PathChain Path2;
    public PathChain Path3;
    public PathChain Path4;
    public PathChain Path5;

    public EthanPaths(Follower follower) {
        Path1 = follower.pathBuilder()
                .addPath(new BezierCurve(
                        new Pose(23.931, 129.765),
                        new Pose(48.481, 96.138),
                        new Pose(58.178, 84.172)
                ))
                .setLinearHeadingInterpolation(Math.toRadians(143), Math.toRadians(131))
                .build();

        Path2 = follower.pathBuilder()
                .addPath(new BezierCurve(
                        new Pose(58.178, 84.172),
                        new Pose(43.530, 83.966),
                        new Pose(21.249, 83.966)
                ))
                .setTangentHeadingInterpolation()
                .build();

        Path3 = follower.pathBuilder()
                .addPath(new BezierCurve(
                        new Pose(21.249, 83.966),
                        new Pose(71.794, 72.413),
                        new Pose(58.590, 83.966)
                ))
                .setTangentHeadingInterpolation()
                .build();

        Path4 = follower.pathBuilder()
                .addPath(new BezierCurve(
                        new Pose(58.590, 83.966),
                        new Pose(101.501, 61.066),
                        new Pose(20.011, 59.415)
                ))
                .setTangentHeadingInterpolation()
                .build();

        Path5 = follower.pathBuilder()
                .addPath(new BezierCurve(
                        new Pose(20.011, 59.415),
                        new Pose(88.298, 63.542),
                        new Pose(58.590, 84.172)
                ))
                .setTangentHeadingInterpolation()
                .build();
    }
}