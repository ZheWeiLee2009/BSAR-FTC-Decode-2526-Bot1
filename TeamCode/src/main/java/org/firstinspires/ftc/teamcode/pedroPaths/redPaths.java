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
    public PathChain Path8;


    public redPaths(Follower follower) {

        Path1 = follower
                .pathBuilder()
                .addPath(
                        new BezierLine(
                                new Pose(125.845, 121.307),
                                new Pose(90.980, 89.948)
                        )
                )
                .setLinearHeadingInterpolation(
                        Math.toRadians(37),
                        Math.toRadians(46)
                )
                .build();

        Path2 = follower
                .pathBuilder()
                .addPath(
                        new BezierCurve(
                                new Pose(90.980, 89.948),
                                new Pose(98.940, 73.748),
                                new Pose(130.134, 83.760)
                        )
                )
                .setLinearHeadingInterpolation(
                        Math.toRadians(46),
                        Math.toRadians(0)
                )
                .build();

        Path3 = follower
                .pathBuilder()
                .addPath(
                        new BezierCurve(
                                new Pose(130.134, 83.760),
                                new Pose(58.384, 63.748),
                                new Pose(90.567, 89.948)
                        )
                )
                .setLinearHeadingInterpolation(
                        Math.toRadians(0),
                        Math.toRadians(46)
                )
                .build();

        Path4 = follower
                .pathBuilder()
                .addPath(
                        new BezierCurve(
                                new Pose(90.567, 89.948),
                                new Pose(74.225, 58.490),
                                new Pose(131.607, 59.209)
                        )
                )
                .setTangentHeadingInterpolation()
                .build();

        Path5 = follower
                .pathBuilder()
                .addPath(
                        new BezierCurve(
                                new Pose(131.607, 59.209),
                                new Pose(73.596, 73.37),
                                new Pose(90.774, 89.948)
                        )
                )
                .setTangentHeadingInterpolation()
                .build();

        Path6 = follower
                .pathBuilder()
                .addPath(
                        new BezierCurve(
                                new Pose(90.774, 89.948),
                                new Pose(54.532, 14.156),
                                new Pose(133.549, 35.846)
                        )
                )
                .setLinearHeadingInterpolation(
                        Math.toRadians(46),
                        Math.toRadians(0)
                )
                .build();

        Path7 = follower
                .pathBuilder()
                .addPath(
                        new BezierCurve(
                                new Pose(133.549, 35.846),
                                new Pose(49.235, 62.764),
                                new Pose(85.500, 92.035)
                        )
                )
                .setLinearHeadingInterpolation(
                        Math.toRadians(0),
                        Math.toRadians(46)//Math.toRadians(140)
                )
                .build();

        Path8 = follower
                .pathBuilder()
                .addPath(
                        new BezierLine(
                                new Pose(85.500, 92.035),
                                new Pose(103.924, 57.726)
                        )
                )
                .setLinearHeadingInterpolation(
                        Math.toRadians(37),
                        Math.toRadians(46)
                )
                .build();
    }
}
