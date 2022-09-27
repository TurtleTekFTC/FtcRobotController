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
                
                if  (gamepad1.dpad_right) {
                    motorLeft.setPower(0.1);
                    motorRight.setPower(0.1);
                } else if (gamepad1.dpad_left){
                    motorLeft.setPower(0);
                    motorRight.setPower(0);
                } else if  (gamepad1.dpad_down == true) {
                    motorLeft.setPower(-0.1);
                    motorRight.setPower(-0.1);
                } else if (gamepad1.dpad_up){
                    motorLeft.setPower(0);
                    motorRight.setPower(0);
                } else {
                    motorLeft.setPower(0);
                    motorRight.setPower(0);
                }

                // Put loop blocks here
            }
        }
}

