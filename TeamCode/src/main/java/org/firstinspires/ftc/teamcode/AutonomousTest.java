package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcontroller.external.samples.RobotHardware;

@Autonomous(name="TurtleTestAutonomous", group="Turtle Group")
public class AutonomousTest extends LinearOpMode{
    RobotHardware_TT   robot       = new RobotHardware_TT(this);

    @Override
    public void runOpMode() {
        robot.init();

        waitForStart();

        while (opModeIsActive()) {
            robot.setDrivePower(0.5, 0.5);
            sleep(100);
            robot.setDrivePower(0, 0);
            robot.setArmPower(0.5);
            sleep(100);
            robot.setArmPower(0);
            robot.setHandPositions(0.25);
            sleep(100);
            robot.setHandPositions(0);
            robot.setArmPower(-0.5);
            sleep(100);
            robot.setArmPower(0);
        }
    }
}
