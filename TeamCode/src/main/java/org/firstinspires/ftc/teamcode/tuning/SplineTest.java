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

            waitForStart();

            Actions.runBlocking(
                drive.actionBuilder(beginPose)
                        .setTangent(0)
                        .splineToConstantHeading(new Vector2d(15, 340), Math.PI / 2)
                        //.splineTo(new Vector2d(0, 60), Math.PI)

                        .build());
        }
        else {

            throw new RuntimeException();
        }
    }
    public void armToggle(){

    }
}
