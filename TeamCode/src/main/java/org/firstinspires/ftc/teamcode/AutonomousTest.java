/*package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;


public class AutonomousTest extends LinearOpMode{
    RobotHardware_TT   robot       = new RobotHardware_TT(this);

    @Override
    public void runOpMode() {
        robot.init();

        waitForStart();

        while (opModeIsActive()) {
            robot.tankDrive(0.5, 0.5);
            sleep(100);
            robot.tankDrive(0, 0);
            robot.setArmPower(0.5);
            sleep(100);
            robot.setArmPower(0);
            robot.setHandPosition(0.25,0.25);
            sleep(100);
            robot.setHandPosition(0,0);
            robot.setArmPower(-0.5);
            sleep(100);
            robot.setArmPower(0);
        }
    }
}
*/