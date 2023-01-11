package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.tfod.Recognition;

import java.util.List;

//@Autonomous(name="Autonomous_TT-2", group="Turtle Group")
public class SignalScanMove extends LinearOpMode {
    RobotHardware_TT   robot       = new RobotHardware_TT(this);

    @Override
    public void runOpMode() {
        robot.initAuto();
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
                        telemetry.addLine("Lightning Bolt");
                        robot.armHeight(3);
                        robot.setHandPosition(0.1,0.5);
                        robot.armHeight(5);
                    } else if (recognition.getLabel() == robot.LABELS[1]) {
                        //spin left
                        objectRecognized = true;
                        recognizedObject = 1;
                        telemetry.addLine("Light Bulb");
                        robot.armHeight(3);
                        robot.setHandPosition(0.1,0.5);
                        robot.armHeight(5);
                    } else if (recognition.getLabel() == robot.LABELS[2]) {
                        //spin right
                        objectRecognized = true;
                        recognizedObject = 2;
                        telemetry.addLine("Solar Panel");
                        robot.armHeight(3);
                        robot.setHandPosition(0.1,0.5);
                        robot.armHeight(5);
                    }
                }
            }
            telemetry.update();
        }
        if (objectRecognized) {
            if (recognizedObject == 0) {
                robot.driveDistance(0.5);
                robot.wake(100);
                robot.TurnLeft();
                robot.wake(100);
                robot.driveDistance(2.3);
                robot.wake(100);
                robot.TurnRight();
                robot.wake(100);
                robot.driveDistance(2.6);
                robot.wake(100);
            } else if (recognizedObject == 1) {
                robot.driveDistance(2.66);
                robot.wake(2);
            } else if (recognizedObject == 2) {
                robot.driveDistance(0.083);
                robot.wake(100);
                robot.TurnRight1();
                robot.wake(100);
                robot.driveDistance(2);
                robot.wake(100);
                robot.TurnLeft1();
                robot.wake(100);
                robot.driveDistance(2.6);
                robot.wake(100);
            }
        }
    }



}
