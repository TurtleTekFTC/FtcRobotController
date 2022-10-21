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
        while (!objectRecognized && opModeIsActive()){
            List<Recognition> updatedRecognitions = robot.recognition();
            if (updatedRecognitions != null) {
                for (Recognition recognition : updatedRecognitions) {
                    if (recognition.getLabel() == robot.LABELS[0]) {
                        //Bolts: 1.go forward 2.turn left 3.forward 4.turn right 5.forward
                        objectRecognized = true;
                        recognizedObject = 0;
                        telemetry.addLine("Lightning bolt");
                    } else if (recognition.getLabel() == robot.LABELS[1]) {
                        //spin left
                        objectRecognized = true;
                        recognizedObject = 1;
                        telemetry.addLine("Light bulb");
                    } else if (recognition.getLabel() == robot.LABELS[2]) {
                        //spin right
                        objectRecognized = true;
                        recognizedObject = 2;
                        telemetry.addLine("panel");
                    }
                }
            }
            telemetry.update();
        }
        if (objectRecognized) {
            if (recognizedObject == 0) {
                robot.tankDrive(0.85, 0.85);
                sleep(10);
                robot.TurnLeft();
                sleep(40);
                robot.tankDrive(1, 1);
                sleep(1000);
                robot.TurnRight();
            } else if (recognizedObject == 1) {
                robot.tankDrive(0.5, 0.5);
                sleep(100);
            } else if (recognizedObject == 2) {
                robot.tankDrive(0.85, 0.85);
                sleep(10);
                robot.TurnRight();
                sleep(40);
                robot.tankDrive(0.5, 0.5);
                sleep(500);
                //robot.TurnLeft();
            }
        }
    }

}
