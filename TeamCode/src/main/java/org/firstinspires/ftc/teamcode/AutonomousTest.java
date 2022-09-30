package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name="TurtleTestAutonomous", group="Turtle Group")
public class AutonomousTest extends LinearOpMode{
    DcMotor motorLeft;
    DcMotor motorRight;
    DcMotor motorArm;
    Servo claw;

    @Override
    public void runOpMode() {
        motorLeft = hardwareMap.get(DcMotor.class, "motorLeft");
        motorRight = hardwareMap.get(DcMotor.class, "motorRight");
        motorArm = hardwareMap.get(DcMotor.class, "motorArm");
        claw = hardwareMap.get(Servo.class, "claw");


        waitForStart();

        while (opModeIsActive()) {
            motorLeft.setPower(-0.5);
            motorRight.setPower(0.5);
            sleep(1000);
            motorLeft.setPower(0);
            motorRight.setPower(0);
            motorArm.setPower(-0.5);
            sleep(1000);
            motorArm.setPower(0);
            sleep(10000);
            claw.setPosition(0.25);
            sleep(1000);
            claw.setPosition(0);
        }
    }
}
