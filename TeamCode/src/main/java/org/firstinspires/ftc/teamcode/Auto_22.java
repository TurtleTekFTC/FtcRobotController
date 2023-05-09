package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ReadWriteFile;

import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
import org.firstinspires.ftc.robotcore.internal.system.AppUtil;

import java.io.File;
import java.util.List;

@Autonomous(name="Autonomous_TT", group="Turtle Group")
public class Auto_22 extends LinearOpMode {
    RobotHardware_TT   robot       = new RobotHardware_TT(this);
    //Squirt Code

    @Override
    public void runOpMode() {
        robot.initAuto(); //Takes from robot class to init auto sequence for Squirt.
        robot.initCamera(); //From robot. Inits camera.
        String filename = "AutoEncoder.txt";
        File file = AppUtil.getInstance().getSettingsFile(filename);
        ReadWriteFile.writeFile(file, "0");
        //Sets a file to store encoder.

        waitForStart();
        boolean objectRecognized = false;
        int recognizedObject = -1;
        while (!objectRecognized && opModeIsActive()){ //2022-23 Signal Cone recognition.
            List<Recognition> updatedRecognitions = robot.recognition();
            if (updatedRecognitions != null) {
                for (Recognition recognition : updatedRecognitions) {
                    if (recognition.getLabel() == robot.LABELS[0]) {
                        objectRecognized = true;
                        recognizedObject = 0;
                        telemetry.addLine("Lightning Bolt");
                    } else if (recognition.getLabel() == robot.LABELS[1]) {
                        objectRecognized = true;
                        recognizedObject = 1;
                        telemetry.addLine("Light Bulb");
                    } else if (recognition.getLabel() == robot.LABELS[2]) {
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
                robot.setHandPosition(0.30,0.60);
                robot.driveDistance(0.25);
                robot.wake(100);
                robot.TurnLeft();
                robot.wake(100);
                robot.driveDistance(1.6);
                robot.wake(100);
                robot.TurnRight();
                robot.wake(100);
                robot.driveDistance(2.1);
                robot.armHeight(0);
                ReadWriteFile.writeFile(file, Double.toString(robot.getArmEncoderValue())); //writes to file the encoder.
            } else if (recognizedObject == 1) {
                robot.setHandPosition(0.30,0.60);
                robot.driveDistance(2.3);
                robot.armHeight(0);
                ReadWriteFile.writeFile(file, Double.toString(robot.getArmEncoderValue()));
            } else if (recognizedObject == 2) {
                robot.setHandPosition(0.30,0.60);
                robot.driveDistance(0.25);
                robot.wake(100);
                robot.TurnRight();
                robot.wake(100);
                robot.driveDistance(1.9);
                robot.wake(100);
                robot.TurnLeft();
                robot.wake(100);
                robot.driveDistance(1.8);
                robot.armHeight(0);
                ReadWriteFile.writeFile(file, Double.toString(robot.getArmEncoderValue()));
            }

        }
    }
}
