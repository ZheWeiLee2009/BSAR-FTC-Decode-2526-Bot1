package org.firstinspires.ftc.teamcode.Config;


import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Pose2D;

public class FieldOrientedCalc {
    Odometry odometry;

    // ****** Field Oriented Calculations ******* //
    // ~ Rotation Matrix Calculations
    public double[] calculateFODMotorPowers(double axial, double lateral, double yaw, double heading) {

        double[] motorPowers = new double[4];
        // rotation matrix
        double rotX = lateral * Math.cos(-heading) - axial * Math.sin(-heading);
        double rotY = lateral * Math.sin(-heading) + axial * Math.cos(-heading);

        motorPowers[0] = (rotY + rotX + yaw);
        motorPowers[1] = (rotY - rotX + yaw);
        motorPowers[2] = (rotY - rotX - yaw);
        motorPowers[3] = (rotY + rotX - yaw);

        return motorPowers;

    }

    // Distance calculation
    public double calculateDistance(double currentPosX, double currentPosY,
                                    double offsetX, double offsetY) {
        double deltaX = offsetX - currentPosX;
        double deltaY = offsetY - currentPosY;


        double distance = Math.sqrt(deltaX * deltaX + deltaY * deltaY);

        return distance; // Returns distance in MM
    }
}
