package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name="DriveWithSticksJava", group="Turtle Group")
public class DriveWithSticks extends LinearOpMode {

    DcMotor motorLeft;
    DcMotor motorRight;
    DcMotor motorArm;
    Servo claw1;
    Servo claw2;

    @Override
    public void runOpMode() {
        motorLeft = hardwareMap.get(DcMotor.class, "motorLeft");
        motorRight = hardwareMap.get(DcMotor.class, "motorRight");
        motorArm = hardwareMap.get(DcMotor.class, "motorArm");
        claw1 = hardwareMap.get(Servo.class, "claw1");
        claw2 = hardwareMap.get(Servo.class, "claw2");

        // Put initialization blocks here
        waitForStart();
        // Put run blocks here
        while (opModeIsActive()) {

            motorLeft.setPower(-gamepad1.left_stick_y);
            motorRight.setPower(gamepad1.right_stick_y);
            motorArm.setPower(gamepad2.left_stick_y);

            if (gamepad2.left_bumper) {

                claw1.setPosition(0.2);
                claw2.setPosition(0.8);
            }
            else if (gamepad2.right_bumper) {

                claw1.setPosition(0);
                claw2.setPosition(0);
            }
        }
    }
}