package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="Build", group="Turtle Group")
public class Build extends LinearOpMode {

    RobotHardware_TT   robot       = new RobotHardware_TT(this);

    @Override
    public void runOpMode() {
        robot.init();

        waitForStart();
        while (opModeIsActive()) {
            if (gamepad2.a) {
                robot.setHandPosition(0.55,0.45);
            }
            else {
                robot.setHandPosition(1, 0);
            }
        }
    }
}