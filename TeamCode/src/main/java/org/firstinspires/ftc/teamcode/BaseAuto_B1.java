package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ReadWriteFile;

import org.firstinspires.ftc.robotcore.internal.system.AppUtil;

import java.io.File;

@Autonomous(name="Blue Backdrop", group="Bots on Base")
public class BaseAuto_B1 extends LinearOpMode {

    RobotHardware_TT   robot       = new RobotHardware_TT(this);
    @Override
    public void runOpMode() {

        waitForStart();

        while (opModeIsActive()) {
            robot.setHandPosition(0.30,0.60);
            robot.wake(100);
            robot.driveDistance(0.33);
            robot.wake(100);
            robot.TurnLeft();
            robot.wake(100);
            robot.driveDistance(3.25);
            robot.armHeight(0);
            robot.setHandPosition(0,1);
            robot.tankDrive(-0.3,-0.3);
            sleep(800);
            robot.tankDrive(0,0);
        }
    }
}
