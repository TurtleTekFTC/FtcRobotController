package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name="TurtleTestMode", group="Tests")
public class TestingZoneTT extends LinearOpMode {
    RobotHardware_TT robot = new RobotHardware_TT(this);
    //Testing Zone

    @Override
    public void runOpMode() {
        robot.init();
        // Put initialization blocks here
        waitForStart();
        // Put run blocks here
        while (opModeIsActive()) {
            while (robot.getArmInches() < 12) {
                robot.setArmPower(0.1);
                telemetry.addData("Arm inches: ", robot.getArmInches());
                telemetry.update();
            }
        }
    }
}