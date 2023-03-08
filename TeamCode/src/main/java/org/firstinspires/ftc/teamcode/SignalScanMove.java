package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ReadWriteFile;

import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
import org.firstinspires.ftc.robotcore.internal.system.AppUtil;

import java.io.File;
import java.util.List;

@Autonomous(name="Autonomous_TT", group="Turtle Group")
public class SignalScanMove extends LinearOpMode {
    RobotHardware_TT   robot       = new RobotHardware_TT(this);

    @Override
    public void runOpMode() {
        robot.initAuto();
       //robot.initCamera();
        String filename = "AutoEncoder.txt";
        File file = AppUtil.getInstance().getSettingsFile(filename);
        ReadWriteFile.writeFile(file, "0");

        waitForStart();
        boolean objectRecognized = false;
        int recognizedObject = -1;
        while (!objectRecognized && opModeIsActive()){
            if (CustomSignalPipeline.PossibilitiesForTheSignalSleeveToBe.ZILCH != robot.lastResult()) {
                if (CustomSignalPipeline.PossibilitiesForTheSignalSleeveToBe.ONE == robot.lastResult()) {
                    objectRecognized = true;
                    recognizedObject = 0;
                    telemetry.addLine("Loiogohotonoionog Booolot");
                } else if (CustomSignalPipeline.PossibilitiesForTheSignalSleeveToBe.TWO == robot.lastResult()) {
                    objectRecognized = true;
                    recognizedObject = 1;
                    telemetry.addLine("Liiigihit Biuilib");
                } else if (CustomSignalPipeline.PossibilitiesForTheSignalSleeveToBe.THREE == robot.lastResult()) {
                    objectRecognized = true;
                    recognizedObject = 2;
                    telemetry.addLine("Seoeleaer Peaeneeel");
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
                robot.driveDistance(1.8);
                robot.wake(100);
                robot.TurnRight();
                robot.wake(100);
                robot.driveDistance(1.9);
                robot.armHeight(0);
                ReadWriteFile.writeFile(file, Double.toString(robot.getArmEncoderValue()));
            } else if (recognizedObject == 1) {
                robot.setHandPosition(0.30,0.60);
                robot.driveDistance(2.3);
                robot.armHeight(0);
                ReadWriteFile.writeFile(file, Double.toString(robot.getArmEncoderValue()));
            } else if (recognizedObject == 2) {
                robot.setHandPosition(0.30,0.60);
                robot.driveDistance(0.083);
                robot.wake(100);
                robot.TurnRight1();
                robot.wake(100);
                robot.driveDistance(2);
                robot.wake(100);
                robot.TurnLeft1();
                robot.wake(100);
                robot.driveDistance(1.8);
                robot.armHeight(0);
                ReadWriteFile.writeFile(file, Double.toString(robot.getArmEncoderValue()));
            }

        }
    }
}
