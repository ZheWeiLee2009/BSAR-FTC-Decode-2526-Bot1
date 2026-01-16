package org.firstinspires.ftc.teamcode.OldAutos;

import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.Pose;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Config.Drivetrain;
import org.firstinspires.ftc.teamcode.pedroPaths.bluePaths;
import org.firstinspires.ftc.teamcode.pedroPathing.Constants;

@Disabled
@Autonomous(name = "TestAuto")
public class TestAuto extends LinearOpMode {
    private Drivetrain bot;
    private Follower follower;
    private bluePaths paths;
    private DcMotorEx Flywheel;
    int doer = 0;

    @Override
    public void runOpMode() throws InterruptedException {

        bot = new Drivetrain(hardwareMap, new ElapsedTime());
        bot.setServoPos(true);
        bot.setIntake("off");
        bot.setFlywheel("off", 0);

        follower = Constants.createFollower(hardwareMap);
        follower.setStartingPose(new Pose(18.155, 121.307, Math.toRadians(143)));

        paths = new bluePaths(follower);

        Flywheel = hardwareMap.get(DcMotorEx.class, "Flywheel");

        waitForStart();
        if (isStopRequested()) return;
        Flywheel.setVelocity(700);
        bot.setIntake("full");
        for (int i = 0; i < 50; i++){
            Flywheel.setVelocity(700);
            bot.fullDown();
            sleep(160);
            bot.setServoPos(true);
            sleep(1200);
        }

    }
}
