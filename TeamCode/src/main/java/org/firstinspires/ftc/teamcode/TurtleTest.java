package org.firstinspires.ftc.teamcode;

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
                motorLeft.setPower(7);
                motorRight.setPower(-7);
                // Put loop blocks here
            }
        }
}

