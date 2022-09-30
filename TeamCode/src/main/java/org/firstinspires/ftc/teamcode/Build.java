package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name="Build", group="Turtle Group")
public class Build extends LinearOpMode {

    Servo claw1;
    Servo claw2;

    @Override
    public void runOpMode() {

        claw1 = hardwareMap.get(Servo.class, "claw1");
        claw2 = hardwareMap.get(Servo.class, "claw2");

        // Put initialization blocks here
        waitForStart();
        // Put run blocks here
        while (opModeIsActive()) {
            
            claw1.setPosition(0);
            claw2.setPosition(0);
        }
    }
}