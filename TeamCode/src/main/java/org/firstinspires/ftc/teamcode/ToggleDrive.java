package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="TeleOp_TT", group="Turtle Group")
public class ToggleDrive extends LinearOpMode {
    RobotHardware_TT robot = new RobotHardware_TT(this);

    @Override
    public void runOpMode() {
        boolean isUsingArcade = false;
        double servoPositionLeft = 0;
        double servoPositionRight = 1;
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

            robot.setArmPower(-gamepad2.left_stick_y*0.4);
            telemetry.addData("Arm motor Encoder: ", robot.getArmEncoderValue());

            if (gamepad2.left_bumper && gamepad2.right_bumper) {
            }
            else if (gamepad2.right_bumper) {
                servoPositionLeft = servoPositionLeft + 0.01;
                servoPositionRight = servoPositionRight - 0.01;
                robot.setHandPosition(servoPositionLeft,servoPositionRight);
            }
            else if (gamepad2.left_bumper) {
                servoPositionLeft = 0;
                servoPositionRight = 1;
                robot.setHandPosition(servoPositionLeft,servoPositionRight);
            }telemetry.update();
        }
    }
}

