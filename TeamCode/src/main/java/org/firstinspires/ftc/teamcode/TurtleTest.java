package org.firstinspires.ftc.teamcode;

import android.view.animation.GridLayoutAnimationController;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

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

                motorLeft.setPower(-0.1);
                motorRight.setPower(0.1);
                sleep(1000);
                motorLeft.setPower(0);
                motorRight.setPower(0);
                sleep(500);
                motorLeft.setPower(0.1);
                motorRight.setPower(-0.1);
                sleep(1000);
                // Put loop blocks here
            }
        }
}

