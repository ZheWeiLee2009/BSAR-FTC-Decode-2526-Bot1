package org.firstinspires.ftc.teamcode.Config;

import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.BezierCurve;
import com.pedropathing.geometry.BezierLine;
import com.pedropathing.geometry.Pose;
import com.pedropathing.paths.PathChain;

public class RedPaths {

    public PathChain Path1;
    public PathChain Path2;
    public PathChain Path3;
    public PathChain Path4;
    public PathChain Path5;
    public PathChain Path6;
    public PathChain Path7;

    public RedPaths(Follower follower) {

        // ------------------ Path 1 ------------------
        Path1 = follower.pathBuilder()
                .addPath(new BezierLine(
                        new Pose(126.040, 120.954),
                        new Pose(81.536, 80.424)
                ))
                .setLinearHeadingInterpolation(
                        Math.toRadians(37),
                        Math.toRadians(37)
                )
                .build();

        // ------------------ Path 2 ------------------
        Path2 = follower.pathBuilder()
                .addPath(new BezierCurve(
                        new Pose(81.536, 80.424),
                        new Pose(84.238, 89.166),
                        new Pose(125.722, 83.126)
                ))
                .setLinearHeadingInterpolation(
                        Math.toRadians(37),
                        Math.toRadians(1)
                )
                .build();

        // ------------------ Path 3 ------------------
        Path3 = follower.pathBuilder()
                .addPath(new BezierCurve(
                        new Pose(125.722, 83.126),
                        new Pose(65.960, 67.073),
                        new Pose(81.536, 80.583)
                ))
                .setLinearHeadingInterpolation(
                        Math.toRadians(1),
                        Math.toRadians(37)
                )
                .build();

        // ------------------ Path 4 ------------------
        Path4 = follower.pathBuilder()
                .addPath(new BezierCurve(
                        new Pose(81.536, 80.583),
                        new Pose(97.272, 57.377),
                        new Pose(129.854, 59.285)
                ))
                .setLinearHeadingInterpolation(
                        Math.toRadians(37),
                        Math.toRadians(37)
                )
                .build();

        // ------------------ Path 5 ------------------
        Path5 = follower.pathBuilder()
                .addPath(new BezierCurve(
                        new Pose(129.854, 59.285),
                        new Pose(62.305, 61.828),
                        new Pose(81.536, 80.742)
                ))
                .setLinearHeadingInterpolation(
                        Math.toRadians(37),
                        Math.toRadians(37)
                )
                .build();

        // ------------------ Path 6 (BACKWARDS!!) ------------------
        Path6 = follower.pathBuilder()
                .addPath(new BezierCurve(
                        new Pose(81.536, 80.742),
                        new Pose(64.689, 30.675),
                        new Pose(130.172, 35.126)
                ))
                // Robot drives backward while facing 180°
                .setLinearHeadingInterpolation(
                        Math.toRadians(180),
                        Math.toRadians(180)
                )
                .build();

        // ------------------ Path 7 ------------------
        Path7 = follower.pathBuilder()
                .addPath(new BezierCurve(
                        new Pose(130.172, 35.126),
                        new Pose(64.530, 63.258),
                        new Pose(81.536, 80.583)
                ))
                .setLinearHeadingInterpolation(
                        Math.toRadians(37),
                        Math.toRadians(37)
                )
                .build();
    }
}