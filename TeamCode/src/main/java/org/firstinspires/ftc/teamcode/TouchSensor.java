package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


public class TouchSensor extends LinearOpMode {
    RobotHardware_TT   robot       = new RobotHardware_TT(this);


    @Override
    public void runOpMode() {
        robot.init();

        // Put initialization blocks here
        waitForStart();
        // Put run blocks here
        while (opModeIsActive()) {

            if (robot.touchSensorIsPressed())
            {
                robot.arcadeDrive(-1, 0);
            }
            else{
                robot.arcadeDrive(0,0);
            }
        }
    }
}