package org.firstinspires.ftc.teamcode.pedroPaths;

import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.BezierCurve;
import com.pedropathing.geometry.BezierLine;
import com.pedropathing.geometry.Pose;
import com.pedropathing.paths.PathChain;

public class redPaths {

    public PathChain Path1;
    public PathChain Path2;
    public PathChain Path3;
    public PathChain Path4;
    public PathChain Path5;
    public PathChain Path6;
    public PathChain Path7;

    public redPaths(Follower follower) {

        // ------------------ Path 1 ------------------

        Path1 = follower.pathBuilder()
                .addPath(new BezierLine(
                        new Pose(125.845, 121.307),
                        new Pose(90.980, 89.948))                )
                .setLinearHeadingInterpolation(
                        Math.toRadians(37),
                        Math.toRadians(46))
                .build();

        // ------------------ Path 2 ------------------
        Path2 = follower.pathBuilder()
                .addPath(new BezierCurve(
                        new Pose(90.980, 89.948),
                        new Pose(62.940, 73.748),
                        new Pose(125.134, 83.269)
                ))
                .setLinearHeadingInterpolation(
                        Math.toRadians(46),
                        Math.toRadians(0)
                )
                .build();

        // ------------------ Path 3 ------------------
        Path3 = follower.pathBuilder()
                .addPath(new BezierCurve(
                        new Pose(125.134, 83.269),
                        new Pose(58.384, 63.748),
                        new Pose(90.567, 89.948)
                ))
                .setLinearHeadingInterpolation(
                        Math.toRadians(0),
                        Math.toRadians(46)
                )
                .build();

        // ------------------ Path 4 ------------------
        Path4 = follower.pathBuilder()
                .addPath(new BezierCurve(
                        new Pose(90.567, 89.948),
                        new Pose(77.158, 61.891),
                        new Pose(124.607, 59.209)
                ))
                .build();

        // ------------------ Path 5 ------------------
        Path5 = follower.pathBuilder()
                .addPath(new BezierCurve(
                        new Pose(124.607, 59.209),
                        new Pose(59.415, 66.842),
                        new Pose(90.774, 89.948)
                ))
                .setLinearHeadingInterpolation(
                        Math.toRadians(46),
                        Math.toRadians(46)
                )
                .build();

        // ------------------ Path 6 (BACKWARDS!!) ------------------
        Path6 = follower.pathBuilder()
                .addPath(new BezierCurve(
                        new Pose(90.774, 89.948),
                        new Pose(48.237, 24.220),
                        new Pose(128.549, 35.846)
                ))
                // Robot drives backward while facing 180°
                .setLinearHeadingInterpolation(
                        Math.toRadians(46),
                        Math.toRadians(0)
                )
                .build();

        // ------------------ Path 7 ------------------
        Path7 = follower.pathBuilder()
                .addPath(new BezierCurve(
                        new Pose(128.549, 35.846),
                        new Pose(58.178, 56.115),
                        new Pose(90.774, 89.742)
                ))
                .setLinearHeadingInterpolation(
                        Math.toRadians(0),
                        Math.toRadians(46)
                )
                .build();
    }
}