package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
import java.util.List;

@Autonomous(name="Autonomous_TT", group="Turtle Group")
public class SignalScanMove2 extends LinearOpMode {
    RobotHardware_TT   robot       = new RobotHardware_TT(this);

    @Override
    public void runOpMode() {
        robot.initAuto();
        robot.initCamera();
        // Signal sleeve!!!
        // SignalScanMove!!
        //Gyro turning!!!!
        // Due Feb 15!

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
                    } else if (recognition.getLabel() == robot.LABELS[1]) {
                        //spin left
                        objectRecognized = true;
                        recognizedObject = 1;
                        telemetry.addLine("Light Bulb");
                    } else if (recognition.getLabel() == robot.LABELS[2]) {
                        //spin right
                        objectRecognized = true;
                        recognizedObject = 2;
                        telemetry.addLine("Solar Panel");
                    }
                }
            }
            telemetry.update();
        }
        if (objectRecognized) {
            if (recognizedObject == 0) {
                robot.driveDistance(0.2);
                sleep(100);
                robot.TurnLeft();
                sleep(100);
                robot.driveDistance(1.5);
                sleep(100);
                robot.TurnRight();
                sleep(100);
                robot.driveDistance(2.3);
                sleep(100);
            } else if (recognizedObject == 1) {
                robot.driveDistance(2.66);
                sleep(2);
            } else if (recognizedObject == 2) {
                robot.driveDistance(0.2);
                sleep(100);
                robot.TurnRight1();
                sleep(100);
                robot.driveDistance(2);
                sleep(100);
                robot.TurnLeft1();
                sleep(100);
                robot.driveDistance(2.3);
                sleep(100);
            }
        }
    }

}
