package org.firstinspires.ftc.teamcode;

import android.view.animation.GridLayoutAnimationController;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name="TurtleTestMode", group="Turtle Group")
public class TurtleTest extends LinearOpMode {
    RobotHardware_TT   robot       = new RobotHardware_TT(this);

        @Override
        public void runOpMode() {
            robot.init();
            // Put initialization blocks here
            waitForStart();
            // Put run blocks here
            while (opModeIsActive()) {

                if  (gamepad1.dpad_right) {
                    robot.setDrivePower(0.5, -0.5);
                } else if (gamepad1.dpad_left){
                    robot.setDrivePower(-0.5, 0.5);
                } else if  (gamepad1.dpad_down) {
                    robot.setDrivePower(-0.5, -0.5);
                } else if (gamepad1.dpad_up){
                    robot.setDrivePower(0.5, 0.5);
                } else {
                    robot.setDrivePower(0, 0);
                }

                if (gamepad1.left_bumper) {
                    robot.setArmPower(0.75);
                }
               else if (gamepad1.right_bumper) {
                   robot.setArmPower(-0.75);
                }else {
                   robot.setArmPower(0);
                }
            }
        }
}

