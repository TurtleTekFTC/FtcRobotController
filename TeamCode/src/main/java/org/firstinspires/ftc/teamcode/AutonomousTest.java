package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name="TurtleTestAutonomous", group="Turtle Group")
public class AutonomousTest extends LinearOpMode{
    DcMotor motorLeft;
    DcMotor motorRight;
    DcMotor motorArm;

    @Override
    public void runOpMode() {
        motorLeft = hardwareMap.get(DcMotor.class, "motorLeft");
        motorRight = hardwareMap.get(DcMotor.class, "motorRight");
        motorArm = hardwareMap.get(DcMotor.class, "motorArm");

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
        }
    }
}
