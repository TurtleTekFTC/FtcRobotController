package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ReadWriteFile;

import org.firstinspires.ftc.robotcore.internal.system.AppUtil;

import java.io.File;

@Autonomous(name="Red Backdrop", group="Bots on Base")
public class BaseAuto_B2 extends LinearOpMode {

    RobotHardware_TT   robot       = new RobotHardware_TT(this);
    @Override
    public void runOpMode() {

        waitForStart();

        while (opModeIsActive()) {
            robot.setHandPosition(0.30,0.60);
            sleep(100);
            robot.driveDistance(4.25);
            sleep(100);
            robot.TurnLeft();
            sleep(100);
            robot.driveDistance(7);
            sleep(100);
            robot.setHandPosition(0,1);
            robot.tankDrive(-0.3,-0.3);
            sleep(800);
            robot.tankDrive(0,0);
        }
    }
}
