package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="ToggleDrive", group="Turtle Group")
public class ToggleDrive extends LinearOpMode {
    RobotHardware_TT robot = new RobotHardware_TT(this);

    @Override
    public void runOpMode() {
        boolean isUsingArcade = false;
        robot.init();
        waitForStart();
        while (opModeIsActive()) {
            if (gamepad1.y == true){
                isUsingArcade = true;
            }
            if (gamepad1.x == true) {
                isUsingArcade = false;
            }

            if (isUsingArcade == false){
                robot.tankDrive(-gamepad1.left_stick_y, -gamepad1.right_stick_y);
            }

            if (isUsingArcade == true){
                robot.arcadeDrive(-gamepad1.left_stick_y, gamepad1.right_stick_x);
            }

            robot.setArmPower(-gamepad2.left_stick_y);

            robot.setHandPosition();
            if (gamepad2.right_bumper == true) {
                robot.setHandPosition(0,0);
            }
            if (gamepad2.left_bumper) {
                robot.setHandPosition(0.5,0.5);
            }



        }
    }
}

