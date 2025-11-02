package org.firstinspires.ftc.teamcode.Config;

import static org.firstinspires.ftc.teamcode.Config.OdometryConstants.odoOffsetX;
import static org.firstinspires.ftc.teamcode.Config.OdometryConstants.odoOffsetY;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Pose2D;

public class Odometry {

    HardwareMap hwMap;
    public GoBildaPinpointDriver odo;

    public Odometry (HardwareMap hwMapX, ElapsedTime runtime){
        hwMap = hwMapX;

        // Odometry Computer
        odo = hwMap.get(GoBildaPinpointDriver.class, "POC");
        odo.setOffsets(odoOffsetX, odoOffsetY, DistanceUnit.MM); // Not Calibrated
        odo.setEncoderResolution(GoBildaPinpointDriver.GoBildaOdometryPods.goBILDA_SWINGARM_POD);

        odo.setEncoderDirections(GoBildaPinpointDriver.EncoderDirection.FORWARD, GoBildaPinpointDriver.EncoderDirection.FORWARD); // Direction
        odo.resetPosAndIMU();

    }

    public Pose2D robotPos() {
        return odo.getPosition();
    }

}
