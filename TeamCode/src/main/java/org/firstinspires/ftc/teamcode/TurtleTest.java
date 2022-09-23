package org.firstinspires.ftc.teamcode;

import android.view.animation.GridLayoutAnimationController;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name="TurtleTestMode", group="Turtle Group")
public class TurtleTest extends LinearOpMode {
        DcMotor motorLeft;
        DcMotor motorRight;

        @Override
        public void runOpMode() {
            motorLeft = hardwareMap.get(DcMotor.class, "motorLeft");
            motorRight = hardwareMap.get(DcMotor.class, "motorRight");
            // Put initialization blocks here
            waitForStart();
            // Put run blocks here
            while (opModeIsActive()) {

                boolean test = gamepad1.dpad_up;
                if  (gamepad1.dpad_up) {
                    motorLeft.setPower(1);
                    motorRight.setPower(-1);
                }
                else {
                    motorLeft.setPower(0);
                    motorRight.setPower(0);
                }
                boolean test2 = gamepad1.dpad_right;
                if  (gamepad1.dpad_right) {
                    motorLeft.setPower(1);
                    motorRight.setPower(1);
                }
                else {
                    motorLeft.setPower(0);
                    motorRight.setPower(0);
                }
                boolean test3 = gamepad1.dpad_left;
                if  (gamepad1.dpad_left) {
                    motorLeft.setPower(-1);
                    motorRight.setPower(-1);
                }
                else {
                    motorLeft.setPower(0);
                    motorRight.setPower(0);
                }
                boolean test4 = gamepad1.dpad_down;
                if  (gamepad1.dpad_down) {
                    motorLeft.setPower(-1);
                    motorRight.setPower(1);
                }
                else {
                    motorLeft.setPower(0);
                    motorRight.setPower(0);
                }

                // Put loop blocks here
            }
        }
}

