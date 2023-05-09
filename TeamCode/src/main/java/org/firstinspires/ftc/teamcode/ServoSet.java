package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="ServoSet", group="Turtle Group")
public class ServoSet extends LinearOpMode {

    RobotHardware_TT   robot       = new RobotHardware_TT(this);

    @Override
    public void runOpMode() {
        robot.init();

        waitForStart();
        while (opModeIsActive()) {
            if (gamepad2.a) {
                robot.setHandPosition(0.35,0.65);
            }
            else {
                robot.setHandPosition(0, 1);
            }
        }
    }
}