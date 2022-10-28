package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="TurtleTestMode", group="Turtle Group")
public class TurtleTest extends LinearOpMode {
    RobotHardware_TT robot = new RobotHardware_TT(this);

    double servoPosition = 0;
    public void runOpMode() {
        robot.init();
        // Put initialization blocks here
        waitForStart();
        // Put run blocks here
        while (opModeIsActive()) {

            if (gamepad2.left_bumper && gamepad2.right_bumper) {
            }
            else if (gamepad2.right_bumper){
                servoPosition = servoPosition + 0.01;
                robot.setHandPosition(servoPosition,servoPosition);
            }
            else if (gamepad2.left_bumper){
                servoPosition = 0;
                robot.setHandPosition(servoPosition,servoPosition);
        }
        }

    }
}
