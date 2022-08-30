package org.firstinspires.ftc.teamcode;

    public class TurtleTest extends LinearOpMode {
        DcMotor motorLeft;
        DcMotor motorRight;
        ColorSensor color1;

        @Override
        public void runOpMode() {
            motorLeft = hardwareMap.get(DcMotor.class, "motorLeft");
            motorRight = hardwareMap.get(DcMotor.class, "motorRight");

            // Put initialization blocks here
            waitForStart();
            // Put run blocks here
            while (opModeIsActive()) {
                motorLeft.setPower(-7);
                motorRight.setPower(5);
                // Put loop blocks here
            }
        }

    }

