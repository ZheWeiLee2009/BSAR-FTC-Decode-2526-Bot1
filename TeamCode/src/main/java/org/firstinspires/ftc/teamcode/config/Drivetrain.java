package org.firstinspires.ftc.teamcode.Config;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Pose2D;

import java.util.Arrays;
import java.util.List;

public class Drivetrain {

    HardwareMap hwMap;


    public double oldTime=0;


    // Drive
    public DcMotorEx leftFrontDrive, leftBackDrive, rightFrontDrive, rightBackDrive;
    private final  List<DcMotorEx> motors;


    // Aux
    public DcMotorEx Flywheel, Intake;

    public Servo Gate;
    // States
    public String flywheelState, intakeState;

    public Drivetrain(HardwareMap hwMapX, ElapsedTime runtime) {
        hwMap = hwMapX;

        // Drive
        leftFrontDrive = hwMap.get(DcMotorEx.class,"FL");
        leftBackDrive = hwMap.get(DcMotorEx.class,"BL");
        rightFrontDrive = hwMap.get(DcMotorEx.class,"FR");
        rightBackDrive = hwMap.get(DcMotorEx.class,"BR");

        motors = Arrays.asList(leftFrontDrive, leftBackDrive, rightFrontDrive, rightBackDrive);

        // Aux
        Intake = hwMap.get(DcMotorEx.class,"Intake");
        Flywheel = hwMap.get(DcMotorEx.class,"Flywheel");

        Gate = hwMap.get(Servo.class, "Gate");

        // Set Modes:
        setMotorsMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        leftFrontDrive.setDirection(DcMotorSimple.Direction.REVERSE);
        leftBackDrive.setDirection(DcMotorSimple.Direction.REVERSE);
        rightFrontDrive.setDirection(DcMotorSimple.Direction.FORWARD);
        rightBackDrive.setDirection(DcMotorSimple.Direction.FORWARD);

    }

    public double[] calculateMotorPowers(double axial, double lateral, double yaw) {
        double[] motorPowers = new double[4];
        motorPowers[0] = (axial + lateral + yaw);
        motorPowers[1] = (axial - lateral + yaw);
        motorPowers[2] = (axial - lateral - yaw);
        motorPowers[3] = (axial + lateral - yaw);
        return motorPowers;
    }


    public void setMotorsMode(DcMotorEx.RunMode mode) {
        for (DcMotorEx motor : motors) {
            motor.setMode(mode);
        }
    }
    public void setZeroPowerBehavior(DcMotor.ZeroPowerBehavior zpb) {
        for (DcMotorEx motor : motors) {
            motor.setZeroPowerBehavior(zpb);
        }
    }

    public String getFlywheelState() {
        return flywheelState;
    }



    public String getIntakeState() {
        return intakeState;
    }


}