package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpModeRegistrar;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="TurtleTestMode", group="Turtle Group")
public class TurtleTest extends LinearOpMode {
    RobotHardware_TT robot = new RobotHardware_TT(this);

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