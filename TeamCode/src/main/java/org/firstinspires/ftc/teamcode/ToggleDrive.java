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
        double y;
        double x;
        boolean front = true;
        robot.initAuto();
        waitForStart();
        while (opModeIsActive()) {
            if (gamepad1.dpad_up == true){
                isUsingArcade = true;
            }
            if (gamepad1.dpad_down == true) {
                isUsingArcade = false;
            }

           
            if (gamepad1.x) {
                front = false;
            } else {
                front = true;
            }

            if (front==false) {
                if (isUsingArcade == false){
                    x = -getSquare(-gamepad1.right_stick_y);
                    y = -getSquare(-gamepad1.left_stick_y);
                    robot.tankDrive(y*0.8, x*0.8);
                }

                if (isUsingArcade == true){
                    x = -getSquare(-gamepad1.right_stick_x);
                    y = -getSquare(-gamepad1.left_stick_y);
                    robot.arcadeDrive(y*0.8, x*0.8);

                }
            } else {
                if (isUsingArcade == false){
                    x = getSquare(-gamepad1.right_stick_y);
                    y = getSquare(-gamepad1.left_stick_y);
                    robot.tankDrive(y*0.8, x*0.8);
                }

                if (isUsingArcade == true){
                    x = getSquare(-gamepad2.right_stick_x);
                    y = getSquare(-gamepad1.left_stick_y);
                    robot.arcadeDrive(y*0.8, x*0.8);
                }
            }







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


            if (gamepad2.a) {
                heightArm = 3;
            }
            else if (gamepad2.b) {
                heightArm = 16;
            }
            else if (gamepad2.y) {
                heightArm = 27.5;
            }
            else if (gamepad2.x) {
                heightArm = 37.5;
            }


            if (gamepad2.left_stick_y > 0.05 || gamepad2.left_stick_y < -0.05) {
                robot.setArmPower(-gamepad2.left_stick_y);
            } else {
                robot.armHeight(heightArm);
            }

            telemetry.addData("Arm motor Encoder: ", robot.getArmEncoderValue());
            telemetry.addData("Arm Inches: ", robot.getArmInches());

            telemetry.update();
        }
    }

    private double getSquare(double stick) {
        double a;
        if (stick > 0) {
            a = -Math.pow(stick, 2);
        } else {
            a = Math.pow(stick, 2);
        }
        return a;
    }


}

