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
        double heightArm = 0;
        robot.init();
        waitForStart();
        while (opModeIsActive()) {
            if (gamepad1.dpad_up == true){
                isUsingArcade = true;
            }
            if (gamepad1.dpad_down == true) {
                isUsingArcade = false;
            }

            if (isUsingArcade == false){
                robot.tankDrive(-gamepad1.left_stick_y*0.8, -gamepad1.right_stick_y*0.8);
            }

            if (isUsingArcade == true){
                robot.arcadeDrive(-gamepad1.left_stick_y*0.8, gamepad1.right_stick_x*0.9);
            }

            robot.setArmPower(-gamepad2.left_stick_y*0.4);
            telemetry.addData("Arm motor Encoder: ", robot.getArmEncoderValue());
            telemetry.addData("Arm Inches: ", robot.getArmInches());
            telemetry.update();

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
            }
            telemetry.update();

            if (gamepad2.a) {
                heightArm = 3;
                robot.armHeight(heightArm);
            }
            else if (gamepad2.b) {
                heightArm = 17.5;
                robot.armHeight(heightArm);
            }
            else if (gamepad2.y) {
                heightArm = 27.5;
                robot.armHeight(heightArm);
            }
            else if (gamepad2.x) {
                heightArm = 37.5;
                robot.armHeight(heightArm);
            }
        }
    }
}

