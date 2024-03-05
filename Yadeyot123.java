package org.firstinspires.ftc.teamcode.OpenCV;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import java.util.Locale;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import java.util.Locale;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;


@TeleOp
public class Yadeyot123 extends LinearOpMode {

    // Declare OpMode members.
   

    private DcMotor upright = null;
    private DcMotor upleft = null;
    private DcMotor eshab = null;
    private DcMotor halichon = null;
    private DcMotor bleft = null;
    private DcMotor bright = null;
    private DcMotor fright = null;
    private DcMotor fleft = null;
    private ElapsedTime     runtime = new ElapsedTime();
    
    Servo flip;
    Servo hold;
    Servo teer;
    Servo plainhold;
    Servo open;
    @Override
    public void runOpMode() {

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        upright = hardwareMap.get(DcMotor.class, "upright");
        upleft = hardwareMap.get(DcMotor.class, "upleft");
        eshab = hardwareMap.get(DcMotor.class, "eshab");
        halichon = hardwareMap.get(DcMotor.class, "halichon");
        flip = hardwareMap.get(Servo.class, "flip");
        hold = hardwareMap.get(Servo.class, "hold");
        teer = hardwareMap.get(Servo.class, "teer");
        open = hardwareMap.get(Servo.class, "open");
        plainhold = hardwareMap.get(Servo.class, "plainhold");
        //servo3 = hardwareMap.get(Servo.class, "servo3");
        fleft = hardwareMap.get(DcMotor.class, "fleft");
        fright = hardwareMap.get(DcMotor.class, "fright");
        bleft =    hardwareMap.get(DcMotor.class, "bleft");
        bright = hardwareMap.get(DcMotor.class, "bright");

        
        fright.setDirection(DcMotor.Direction.REVERSE);
        bright.setDirection(DcMotor.Direction.REVERSE);
        waitForStart();
        runtime.reset();
        while (opModeIsActive())
        {
            double turn =  (gamepad1.right_stick_x); //turn the robot right
           
            double strafe = (gamepad1.left_stick_x);
            double dforward = (gamepad1.left_stick_y);   //Drive Forward
           
            double x =  gamepad1.right_trigger;
            double y =  gamepad1.left_trigger;
            double up = gamepad2.left_stick_y;
             

            bright.setPower(dforward + strafe + turn);
            fright.setPower(dforward - strafe + turn);
            bleft.setPower(dforward - strafe - turn);
            fleft.setPower(dforward + strafe - turn);
    
            eshab.setPower (x);
            halichon.setPower (0.8*x);
            eshab.setPower (-y);
            halichon.setPower (0.8*-y);
            


            upleft.setPower(-up);
            upright.setPower(-up);

            if(gamepad2.left_stick_y < 0){
                
                flip.setPosition(0.1);
                open.setPosition(0.06);
                
            }
            
             if(gamepad2.right_bumper){
                hold.setPosition(0.6);
            }else{
                hold.setPosition(1);
            }
           if(gamepad1.right_bumper){
                teer.setPosition(-0.5);
            }else{
                teer.setPosition(0.7);
            }
            
            if(gamepad2.a){
                plainhold.setPosition(1);
            }else{
                plainhold.setPosition(-1);
            }
            if(gamepad2.b){
                flip.setPosition(-0.4);
                open.setPosition(-0.15);
            }
             

        }
    }
}
