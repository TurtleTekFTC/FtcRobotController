package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ReadWriteFile;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.internal.system.AppUtil;

import java.io.File;

@TeleOp(name="TeleOp_TT", group="Turtle Group")
public class TeleOp_22 extends LinearOpMode {
    RobotHardware_TT robot = new RobotHardware_TT(this);
    //Squirt Code

    @Override
    public void runOpMode() {
        String filename = "AutoEncoder.txt";
        boolean isUsingArcade = true;
        double servoPositionLeft = 0;
        double servoPositionRight = 1;
        double heightArm = 0;
        double y = Double.NEGATIVE_INFINITY;
        double x = Double.NEGATIVE_INFINITY;
        boolean front = true;
        robot.init();
        waitForStart();
        while (opModeIsActive()) {
            if (gamepad1.dpad_up == true){
                isUsingArcade = true;
            }
            if (gamepad1.dpad_down == true) {
                isUsingArcade = false;
            }
            //Changes drive mode for omni wheels
           
            if (gamepad1.left_bumper) {
                front = false;
            } else {
                front = true;
            }
            //Switches front

            if (front==false) {
                if (isUsingArcade == false){
                    x = getSquare(-gamepad1.right_stick_y);
                    y = getSquare(-gamepad1.left_stick_y);
                    robot.tankDrive(y*0.8, x*0.8);
                }

                if (isUsingArcade == true){
                    x = getSquare(-gamepad1.right_stick_x);
                    y = getSquare(-gamepad1.left_stick_y);
                    robot.arcadeDrive(y*0.8, x*0.8);

                }
            } else {
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
            //Servos for claw.


            if (gamepad2.a) {
                heightArm = 0;
            }
            else if (gamepad2.b) {
                heightArm = 13;
            }
            else if (gamepad2.y) {
                heightArm = 24.5;
            }
            else if (gamepad2.x) {
                heightArm = 34.5;
            }
            //auto height buttons.

            if (gamepad2.left_stick_y > 0.05 || gamepad2.left_stick_y < -0.05) {
                robot.setArmPower(-getSquare(-gamepad2.left_stick_y));
            } else {
                robot.armHeight(heightArm);
            }
            //Arm power

            //telemetry.addData("Arm motor Encoder: ", robot.getArmEncoderValue());
            //telemetry.addData("Arm Inches: ", robot.getArmInches());
            telemetry.addData("Left Servo: ",servoPositionLeft);
            telemetry.addData("Right Servo: ",servoPositionRight);
            telemetry.addData("Orientation: ", robot.imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.DEGREES));
            telemetry.addData("Arm Stick: ", robot.getArmEncoderValue());



            telemetry.update();
        }
        File file = AppUtil.getInstance().getSettingsFile(filename);
        ReadWriteFile.writeFile(file, "0");
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
    //Squaring for joysticks.


}


