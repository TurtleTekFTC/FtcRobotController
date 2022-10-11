package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.tfod.Recognition;

import java.util.List;

@Autonomous(name="TurtleTestCamera", group="Turtle Group")
public class SignalScanMove extends LinearOpMode {
    RobotHardware_TT   robot       = new RobotHardware_TT(this);

    @Override
    public void runOpMode() {
        robot.init();
        robot.initCamera();

        waitForStart();
        while (opModeIsActive()) {
            List<Recognition> updatedRecognitions = robot.recognition();
            if (updatedRecognitions != null) {
                for (Recognition recognition : updatedRecognitions) {
                    if (recognition.getLabel() == robot.LABELS[0]) {
                    //drive backwards
                    telemetry.addLine("Drive Backwards");
                    } else if (recognition.getLabel() == robot.LABELS[1]) {
                    //spin left
                    telemetry.addLine("Spin Left");
                    } else if (recognition.getLabel() == robot.LABELS[2]) {
                    //spin right
                    telemetry.addLine("Spin Right");
                    } else {
                    //nothing
                    telemetry.addLine("Do Nothing");
                    }
                }
            }
            telemetry.update();
        }
    }
}
