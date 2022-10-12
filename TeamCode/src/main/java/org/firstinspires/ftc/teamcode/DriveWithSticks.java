package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="DriveWithSticksJava", group="Turtle Group")
public class DriveWithSticks extends LinearOpMode {
    RobotHardware_TT   robot       = new RobotHardware_TT(this);
    @Override
    public void runOpMode() {
        robot.init();
        waitForStart();
        while (opModeIsActive()) {
            robot.tankDrive(-gamepad1.left_stick_y, -gamepad1.right_stick_y);
           /* robot.setArmPower(-gamepad2.left_stick_y);

            if (gamepad2.left_bumper) {

                robot.setHandPosition(0.2,0.8);

            }
            else if (gamepad2.right_bumper) {

                robot.setHandPosition(0,0);
            }*/
        }
    }
}