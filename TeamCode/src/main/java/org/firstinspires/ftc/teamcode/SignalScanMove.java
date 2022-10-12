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
        boolean objectRecognized = false;
        int recognizedObject = -1;
        while (!objectRecognized){
            List<Recognition> updatedRecognitions = robot.recognition();
            if (updatedRecognitions != null) {
                for (Recognition recognition : updatedRecognitions) {
                    if (recognition.getLabel() == robot.LABELS[0]) {
                        //Bolts: 1.go forward 2.turn left 3.forward 4.turn right 5.forward
                        objectRecognized = true;
                        recognizedObject = 0;
                        telemetry.addLine("Drive Backwards");
                    } else if (recognition.getLabel() == robot.LABELS[1]) {
                        //spin left
                        objectRecognized = true;
                        recognizedObject = 1;
                        telemetry.addLine("Spin Left");
                    } else if (recognition.getLabel() == robot.LABELS[2]) {
                        //spin right
                        objectRecognized = true;
                        recognizedObject = 2;
                        telemetry.addLine("Spin Right");
                    }
                }
            }
            telemetry.update();
        }
        if (objectRecognized) {
            if (recognizedObject == 0) {
                robot.tankDrive(1, 1);
                sleep(1000);
                robot.TurnLeft();
                robot.tankDrive(1, 1);
                sleep(1000);
                robot.TurnRight();
            } else if (recognizedObject == 1) {
                robot.tankDrive(1, 1);
                sleep(1000);
            } else if (recognizedObject == 2) {
                robot.tankDrive(1, 1);
                sleep(1000);
                robot.TurnRight();
                robot.tankDrive(1, 1);
                sleep(1000);
                robot.TurnLeft();
            }
        }
    }

}
