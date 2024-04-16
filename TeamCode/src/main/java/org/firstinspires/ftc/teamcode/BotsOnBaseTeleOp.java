package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ReadWriteFile;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.internal.system.AppUtil;

import java.io.File;

@TeleOp(name="BotsOnBase-TeleOp", group="Bots On Base")
public class BotsOnBaseTeleOp extends LinearOpMode {
    RobotHardware_TT robot = new RobotHardware_TT(this);
    //Squirt Code

    @Override
    public void runOpMode() {
        boolean isUsingArcade = true;
        double servoPositionLeft = 0;
        double servoPositionRight = 1;
        double setWristPosition = 0;
        double y = Double.NEGATIVE_INFINITY;
        double x = Double.NEGATIVE_INFINITY;
        boolean front = true;
        robot.init();
        waitForStart();
        while (opModeIsActive()) {


            if (front==false) {

                if (isUsingArcade == true){
                    x = getSquare(-gamepad1.right_stick_x);
                    y = getSquare(-gamepad1.left_stick_y);
                    robot.arcadeDrive(y*0.8, x*0.8);

                }
            } else {

                if (isUsingArcade == true){
                    x = -getSquare(-gamepad1.right_stick_x);
                    y = -getSquare(-gamepad1.left_stick_y);
                    robot.arcadeDrive(y*0.8, x*0.8);
                }
            }


            if (gamepad2.left_bumper) {
                servoPositionLeft = 0;
                servoPositionRight = 1;
                robot.setHandPosition(servoPositionLeft,servoPositionRight);
            }
            else if (gamepad2.right_bumper) {
                servoPositionLeft = servoPositionLeft + 0.01;
                servoPositionRight = servoPositionRight - 0.01;
                robot.setHandPosition(servoPositionLeft,servoPositionRight);
            }

            //Servos for claw.

            if (gamepad2.left_trigger > 0.2) {
                setWristPosition = 0;
                robot.setWrist(setWristPosition);
            } else if (gamepad2.right_trigger > 0.2) {
                setWristPosition = setWristPosition +0.01;
                robot.setWrist(setWristPosition);
            }
            //Wrist Servo


            robot.setArmPower(-getSquare(-gamepad2.left_stick_y));


            telemetry.addData("Left Servo: ",servoPositionLeft);
            telemetry.addData("Right Servo: ",servoPositionRight);
            telemetry.addData("Orientation: ", robot.imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.DEGREES));
            telemetry.update();
        }

        if (gamepad2.x && gamepad2.back) {
            //launch method
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
    //Squaring for joysticks.


}
