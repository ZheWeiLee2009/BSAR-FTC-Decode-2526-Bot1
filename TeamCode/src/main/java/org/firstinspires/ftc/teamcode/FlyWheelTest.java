package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import org.firstinspires.ftc.teamcode.Config.Drivetrain;
@Disabled
@Autonomous(name = "FlyWheelTest")
public class FlyWheelTest extends LinearOpMode {
    private DcMotorEx Flywheel;
    private Drivetrain bot;
    @Override
    public void runOpMode() throws InterruptedException {

        waitForStart();
        if (isStopRequested()) return;
        Flywheel = hardwareMap.get(DcMotorEx.class,"Flywheel");
        bot.setIntake("full");
        Flywheel.setVelocity(1507);
        telemetry.addLine("velocity" + Flywheel.getVelocity());
        sleep(1000);
        telemetry.addLine("velocity" + Flywheel.getVelocity());
        sleep(1000);
        telemetry.addLine("velocity" + Flywheel.getVelocity());
        sleep(1000);
        telemetry.addLine("velocity" + Flywheel.getVelocity());
        sleep(1000000);
    }

}
