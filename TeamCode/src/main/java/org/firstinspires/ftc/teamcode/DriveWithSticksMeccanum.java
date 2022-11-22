package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;


public class DriveWithSticksMeccanum extends LinearOpMode {
    RobotHardware_TT   robot       = new RobotHardware_TT(this);
    @Override
    public void runOpMode() {
        robot.init();
        waitForStart();
        while (opModeIsActive()) {
            robot.tankDrive(-gamepad1.left_stick_y, -gamepad1.right_stick_y);

        }
    }
}