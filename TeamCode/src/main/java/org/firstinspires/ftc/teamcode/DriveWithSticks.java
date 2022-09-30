package org.firstinspires.ftc.teamcode;

import android.view.animation.GridLayoutAnimationController;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name="DriveWithSticksJava", group="Turtle Group")
public class DriveWithSticks extends LinearOpMode {
    DcMotor motorLeft;
    DcMotor motorRight;
    DcMotor motorArm;

    @Override
    public void runOpMode() {
        motorLeft = hardwareMap.get(DcMotor.class, "motorLeft");
        motorRight = hardwareMap.get(DcMotor.class, "motorRight");
        motorArm = hardwareMap.get(DcMotor.class, "motorArm");
        Claw = hardwareMap.get(.class, "Claw");


        // Put initialization blocks here
        waitForStart();
        // Put run blocks here
        while (opModeIsActive()) {

            motorLeft.setPower(gamepad1.left_stick_y);
            motorRight.setPower(gamepad1.right_stick_y);

        }
    }
}