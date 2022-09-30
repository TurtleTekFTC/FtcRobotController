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
    Servo claw1;
    Servo claw2;

    @Override
    public void runOpMode() {
        motorLeft = hardwareMap.get(DcMotor.class, "motorLeft");
        motorRight = hardwareMap.get(DcMotor.class, "motorRight");
        motorArm = hardwareMap.get(DcMotor.class, "motorArm");
        claw1 = hardwareMap.get(Servo.class, "claw1");
        claw2 = hardwareMap.get(Servo.class, "claw2");


        waitForStart();

        while (opModeIsActive()) {
            motorLeft.setPower(-0.5);
            motorRight.setPower(0.5);
            sleep(1000);
            motorLeft.setPower(0);
            motorRight.setPower(0);
            motorArm.setPower(-0.5);
            claw1.setPosition(0.25);
            claw2.setPosition(0.25);
            sleep(1000);
            claw1.setPosition(0);
            claw2.setPosition(0);
            motorArm.setPower(0);
        }
    }
}
