package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public class SignalScanMove extends LinearOpMode {
    RobotHardware_TT   robot       = new RobotHardware_TT(this);

    @Override
    public void runOpMode() {
        robot.init();
        robot.initCamera();

        waitForStart();
        while (opModeIsActive()) {

        }
    }
}
