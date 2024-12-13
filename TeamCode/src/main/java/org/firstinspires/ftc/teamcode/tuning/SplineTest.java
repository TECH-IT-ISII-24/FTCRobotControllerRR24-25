package org.firstinspires.ftc.teamcode.tuning;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.MecanumDrive;
import org.firstinspires.ftc.teamcode.TankDrive;

public final class SplineTest extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        DcMotor angularArmDrive;
        DcMotor extensionArmDrive;
        Servo handArmServo;

        angularArmDrive = hardwareMap.get(DcMotor.class, "angular_arm_drive");
        extensionArmDrive = hardwareMap.get(DcMotor.class, "extension_arm_drive");
        handArmServo = hardwareMap.get(Servo.class, "hand_arm_servo");

        angularArmDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        extensionArmDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        
        Pose2d beginPose = new Pose2d(0, 0, 0);
        if (TuningOpModes.DRIVE_CLASS.equals(MecanumDrive.class)) { //10% increase from cm to inch
            MecanumDrive drive = new MecanumDrive(hardwareMap, beginPose);

<<<<<<< Updated upstream

            waitForStart();
            float posTarget = 0.5F;
            while(opModeIsActive()) {

                if(gamepad1.dpad_down){
                    handArmServo.setPosition(posTarget);
                }
                if(gamepad1.left_stick_y > 0.5F){
                    posTarget += 0.01F;
                    sleep(10);
                }
                if(gamepad1.left_stick_y < -0.5F){
                    posTarget -= 0.01F;
                    sleep(10);
                }
                if(gamepad1.dpad_left){
                    handArmServo.setPosition(0.45F);
                }
                if(gamepad1.dpad_right){
                    handArmServo.setPosition(0.55F);
                }

                telemetry.addData("Angle: %4.2f", posTarget);
                telemetry.update();
            }
=======
>>>>>>> Stashed changes

            waitForStart();
            

            /*Actions.runBlocking(
                drive.actionBuilder(beginPose)
                        .setTangent(0)
                        .splineToConstantHeading(new Vector2d(14, 44), Math.PI / 2)
                        //.splineTo(new Vector2d(0, 60), Math.PI)
<<<<<<< HEAD
                        .build());
<<<<<<< Updated upstream
        }
        else {
=======
        } else if (TuningOpModes.DRIVE_CLASS.equals(TankDrive.class)) {
            TankDrive drive = new TankDrive(hardwareMap, beginPose);

            waitForStart();

            Actions.runBlocking(
                    drive.actionBuilder(beginPose)
                            .splineTo(new Vector2d(44, 31), Math.PI / 2)
                            .splineTo(new Vector2d(0, 60), Math.PI)
                            .build());
        } else {
=======
                        .build());*/
        }
        else {
>>>>>>> 7cda46d8123db4d053283f8a42d1d23e12c51ff4
>>>>>>> Stashed changes
            throw new RuntimeException();
        }
    }
    public void armToggle(){

    }
}
