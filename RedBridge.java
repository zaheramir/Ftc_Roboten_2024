package org.firstinspires.ftc.robotcontroller.external.samples;

import android.app.Activity;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.Servo;
import android.graphics.Color;
import android.view.View;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DistanceSensor;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

import java.util.Locale;

@Autonomous
public class RedBridge extends LinearOpMode {
    // Define a variable for our color sensor
    ColorSensor color;
    ColorSensor colorLeft;
    DistanceSensor distanceRight;
    DistanceSensor distanceLeft;
    double r;
    double l;
    private DcMotor upright = null;
    private DcMotor upleft = null;
    private DcMotor eshab = null;
    private DcMotor halichon = null;
    private DcMotorEx bleft = null;
    private DcMotorEx bright = null;
    private DcMotorEx fright = null;
    private DcMotorEx fleft = null;
    private ElapsedTime runtime = new ElapsedTime();
    
    Servo flip;
    Servo hold;
    Servo teer;
    Servo open;
    
    @Override
    public void runOpMode() {
        // get a reference to the color sensor.
        color = hardwareMap.get(ColorSensor.class, "sensor_color");
        distanceRight = hardwareMap.get(DistanceSensor.class, "sensor_color");
        distanceLeft = hardwareMap.get(DistanceSensor.class, "sensor_color_left");
        
        colorLeft = hardwareMap.get(ColorSensor.class, "sensor_color_left");
        upright = hardwareMap.get(DcMotor.class, "upright");
        upleft = hardwareMap.get(DcMotor.class, "upleft");
        eshab = hardwareMap.get(DcMotor.class, "eshab");
        halichon = hardwareMap.get(DcMotor.class, "halichon");
        flip = hardwareMap.get(Servo.class, "flip");
        hold = hardwareMap.get(Servo.class, "hold");
        teer = hardwareMap.get(Servo.class, "teer");
        open = hardwareMap.get(Servo.class, "open");
        //servo3 = hardwareMap.get(Servo.class, "servo3");
        fleft = hardwareMap.get(DcMotorEx.class, "fleft");
        fright = hardwareMap.get(DcMotorEx.class, "fright");
        bleft =  hardwareMap.get(DcMotorEx.class, "bleft");
        bright = hardwareMap.get(DcMotorEx.class, "bright");
        
        // hsvValues is an array that will hold the hue, saturation, and value information.
        float hsvValues[] = {0F, 0F, 0F};
        float hsvValues2[] = {0F, 0F, 0F};

        // values is a reference to the hsvValues array.
        final float values[] = hsvValues;

        // sometimes it helps to multiply the raw RGB values with a scale factor
        // to amplify/attentuate the measured values.
        final double SCALE_FACTOR = 255;

        // get a reference to the RelativeLayout so we can change the background
        // color of the Robot Controller app to match the hue detected by the RGB sensor.
        int relativeLayoutId = hardwareMap.appContext.getResources().getIdentifier("RelativeLayout", "id", hardwareMap.appContext.getPackageName());
        final View relativeLayout = ((Activity) hardwareMap.appContext).findViewById(relativeLayoutId);
        
        // wait for the start button to be pressed.
        
        //fright.setDirection(DcMotor.Direction.REVERSE);
        //bright.setDirection(DcMotor.Direction.REVERSE);
        bleft.setDirection(DcMotor.Direction.REVERSE);
        
        waitForStart();

       
       
        bleft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
           bright.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            fleft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            fright.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
         
           
       DriveForward(1295,750, 3000);
       StopDriving();
       sleep(300);
       bleft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            bright.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            fleft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            fright.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
       DriveLeft(120, 500, 800);
       StopDriving();
       sleep(300);

            
          
           
        while (opModeIsActive()) {
            // convert the RGB values to HSV values.
            // multiply by the SCALE_FACTOR.
            // then cast it back to int (SCALE_FACTOR is a double)

            Color.RGBToHSV((int) (color.red() * SCALE_FACTOR), (int) (color.green() * SCALE_FACTOR), (int) (color.blue() * SCALE_FACTOR), hsvValues);
            Color.RGBToHSV((int) (colorLeft.red() * SCALE_FACTOR), (int) (colorLeft.green() * SCALE_FACTOR), (int) (colorLeft.blue() * SCALE_FACTOR), hsvValues2);
            
                    //telemetry.addData("Alpha", color.alpha());
            //telemetry.addData("Red  ", color.red());
            //telemetry.addData("Green", color.green());
            //telemetry.addData("Blue ", color.blue());
           // telemetry.addData("color value: ", hsvValues[0]);
             sleep(200);
            r=distanceRight.getDistance(DistanceUnit.CM);           
            telemetry.addData("right distance: ", String.format(Locale.US, "%.02f", r));
            sleep(1000);
            l=distanceLeft.getDistance(DistanceUnit.CM);
            telemetry.addData("left distance: ", String.format(Locale.US, "%.02f", l));
            telemetry.addData("color2 value: ", hsvValues2[0]);
 
             telemetry.update();
            r=1000;
             sleep(200);
            //if(hsvValues[0] > 120 && hsvValues2[0] <= 120)
            if(l<20)
            {
                telemetry.addData("Left", ".");
                telemetry.update();
                LeftAutonomous();
            }
            
            StopDriving();
            sleep(300);
            bleft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            bright.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            fleft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            fright.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            
            DriveRight(250, 500, 800);
            
            StopDriving();
            sleep(500);
            Color.RGBToHSV((int) (color.red() * SCALE_FACTOR), (int) (color.green() * SCALE_FACTOR), (int) (color.blue() * SCALE_FACTOR), hsvValues);
            Color.RGBToHSV((int) (colorLeft.red() * SCALE_FACTOR), (int) (colorLeft.green() * SCALE_FACTOR), (int) (colorLeft.blue() * SCALE_FACTOR), hsvValues2);
            
                    //telemetry.addData("Alpha", color.alpha());
            //telemetry.addData("Red  ", color.red());
            //telemetry.addData("Green", color.green());
            //telemetry.addData("Blue ", color.blue());
           // telemetry.addData("color value: ", hsvValues[0]);
            
            r=distanceRight.getDistance(DistanceUnit.CM);           
            telemetry.addData("right distance: ", String.format(Locale.US, "%.02f", r));
            sleep(1000);
            l=distanceLeft.getDistance(DistanceUnit.CM);
            telemetry.addData("left distance: ", String.format(Locale.US, "%.02f", l));
            telemetry.addData("color2 value: ", hsvValues2[0]);
 
             telemetry.update();
            
             sleep(500);
            //if(hsvValues[0] > 120 && hsvValues2[0] <= 120)
            //else if (hsvValues2[0] >= 110 && hsvValues[0] < 110)
            l=1000;
            if(r<20)
            {
                telemetry.addData("Right",".");
                telemetry.update();
                RightAutonomous();
            }
            
            
            else 
            {
                telemetry.addData("Center",".");
                telemetry.update();
                
                CenterAutonomous();
            }
          
            // change the background color to match the color detected by the RGB sensor.
            // pass a reference to the hue, saturation, and value array as an argument
            // to the HSVToColor method.
            

            telemetry.update();
        }

        // Set the panel back to the default color
        relativeLayout.post(new Runnable() {
            public void run() {
                relativeLayout.setBackgroundColor(Color.WHITE);
                 
                             }
        });
        }
        public void RightAutonomous()
        {
            
            ResetEncoders();
            DriveBack(100,700,300);
            StopDriving();
            sleep(200);
            ResetEncoders();
            TurnRight(945,1200,1600);
            StopDriving();
            sleep(200);
            ResetEncoders();
            DriveBack(50,1000, 100);
            StopDriving();
            sleep(200);
            
            hold.setPosition(1);
            StopDriving();
            sleep(100);
            eshab.setPower(0.44);
            sleep(1200);
            halichon.setPower(0);
            eshab.setPower(0);
            sleep(300);
            StopDriving();
            sleep(100);
            ResetEncoders();
            DriveBack(150,1000, 200);
            StopDriving();
            sleep(200);
            ResetEncoders();
            TurnLeft(945,1200, 1600);
            StopDriving();
            sleep(200);
            
            
            ResetEncoders();
            DriveForward(1200,1000, 1250);
            StopDriving();
            sleep(300);
             flip.setPosition(-0.4);
            open.setPosition(-0.12);
            StopDriving();
            sleep(1000);
             ResetEncoders();
            TurnLeft(945,1200,1600);
            StopDriving();
            sleep(200);
            ResetEncoders();
            DriveBack(3600,1500,4000);
            StopDriving();
            sleep(300);
            ResetEncoders();
            DriveLeft(1600,2000,2500);
            StopDriving();
            sleep(300);
            
            flip.setPosition(0.1);
            open.setPosition(0.06);
            upleft.setPower(0.5);
            upright.setPower(0.5);
            sleep(300);
            upleft.setPower(0.05);
            upright.setPower(0.05);
            sleep(200);
            
           
           
          
            ResetEncoders();
            DriveBack(1300,490, 1350);
            StopDriving();
            sleep(1000);
            hold.setPosition(-1);
            sleep(300);
            upleft.setPower(0.4);
            upright.setPower(0.4);
            sleep(500);
            upleft.setPower(0.05);
            upright.setPower(0.05);
            sleep(200);
            StopDriving();
            sleep(100);
           
            DriveForward(300,750,350);
            StopDriving();
            sleep(100);
            ResetEncoders();
            DriveRight(850,1200, 950);
            StopDriving();
            sleep(300);
            
            StopDriving();
            sleep(30000);
            
        }
        
        public void CenterAutonomous()
        {
            
            ResetEncoders();
            DriveBack(50,300,800);
            StopDriving();
            sleep(200);
            
            hold.setPosition(1);
            StopDriving();
            sleep(100);
            eshab.setPower(0.44);
            sleep(1200);
            halichon.setPower(0);
            eshab.setPower(0);
            sleep(300);
            StopDriving();
            sleep(100);
            ResetEncoders();
            DriveLeft(800,1000, 850);
            StopDriving();
            sleep(200);
            ResetEncoders();
            DriveForward(1200,1000, 1250);
            StopDriving();
            sleep(300);
             flip.setPosition(-0.4);
            open.setPosition(-0.12);
            StopDriving();
            sleep(1000);
              ResetEncoders();
            TurnLeft(945,1200,1600);
            StopDriving();
            sleep(200);
             ResetEncoders();
            DriveBack(4000,1000,4500);
            StopDriving();
            sleep(200);
           
            ResetEncoders();
            DriveLeft(1450,1400,3000 );
            StopDriving();
            sleep(300);
            
            flip.setPosition(0.1);
            open.setPosition(0.06);
            upleft.setPower(0.5);
            upright.setPower(0.5);
            sleep(300);
            upleft.setPower(0.05);
            upright.setPower(0.05);
            sleep(200);
            
           
           
          
            ResetEncoders();
            DriveBack(1700,500, 1800);
            StopDriving();
            sleep(1000);
            hold.setPosition(-1);
            sleep(300);
            upleft.setPower(0.4);
            upright.setPower(0.4);
            sleep(500);
            upleft.setPower(0.05);
            upright.setPower(0.05);
            sleep(200);
            StopDriving();
            sleep(100);
           
            DriveForward(300,750,350);
            StopDriving();
            sleep(100);
            ResetEncoders();
            DriveRight(1200,1200, 2000);
            StopDriving();
            sleep(300);
            
            StopDriving();
            sleep(30000);
            
         
        }
        public void LeftAutonomous()
        {
           
            ResetEncoders();
            DriveBack(200,700,300);
            StopDriving();
            sleep(200);
            ResetEncoders();
            DriveLeft(550,1000, 600);
            StopDriving();
            sleep(300);
            
        
            hold.setPosition(1);
            StopDriving();
            sleep(100);
            eshab.setPower(0.44);
            sleep(1200);
            halichon.setPower(0);
            eshab.setPower(0);
            sleep(300);
            StopDriving();
            sleep(100);
            ResetEncoders();
            DriveRight(650,1000,700);
            StopDriving();
            sleep(200);
            ResetEncoders();
            DriveForward(1200,1000, 1250);
            StopDriving();
            sleep(300);
             flip.setPosition(-0.4);
            open.setPosition(-0.12);
            StopDriving();
            sleep(1000);
             ResetEncoders();
            TurnLeft(945,1200,1600);
            StopDriving();
            sleep(200);
            ResetEncoders();
            DriveBack(3600,1000,4000);
            StopDriving();
            sleep(300);
            ResetEncoders();
            DriveLeft(1050,1000, 2500);
            StopDriving();
            sleep(300);
            
            flip.setPosition(0.1);
            open.setPosition(0.06);
            upleft.setPower(0.5);
            upright.setPower(0.5);
            sleep(300);
            upleft.setPower(0.05);
            upright.setPower(0.05);
            sleep(200);
            
           
           
          
            ResetEncoders();
            DriveBack(1700,500, 1750);
            StopDriving();
            sleep(1000);
            hold.setPosition(-1);
            sleep(300);
            upleft.setPower(0.4);
            upright.setPower(0.4);
            sleep(500);
            upleft.setPower(0.05);
            upright.setPower(0.05);
            sleep(200);
            StopDriving();
            sleep(100);
           
            DriveForward(300,750,350);
            StopDriving();
            sleep(100);
            ResetEncoders();
            DriveRight(1000,1200, 1100);
            StopDriving();
            sleep(300);
            
            StopDriving();
            sleep(30000);
            
           
        }
        
 public void DriveBack(int target, int speed, long time)
    {
        bleft.setTargetPosition(-target);
            bright.setTargetPosition(-target);
            fleft.setTargetPosition(target);
            fright.setTargetPosition(-target);
            bleft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            bright.setMode(DcMotor.RunMode.RUN_TO_POSITION);
           fleft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            fright.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            bleft.setVelocity(speed);
            bright.setVelocity(speed);
            fleft.setVelocity(speed);
            fright.setVelocity(speed);
            
            
            bleft.setPower(0);
            fright.setPower(0);
            bright.setPower(0);
            fleft.setPower(0);
            telemetry.addData("velocity", bright.getVelocity());
            telemetry.addData("position", bright.getCurrentPosition());
            telemetry.addData("is at target", !bright.isBusy());
            telemetry.update();
            //bright.setDirection(DcMotor.Direction.REVERSE);
            sleep(time);
    }
    public void DriveForward(int target, int speed, long time)
    {
            
        bleft.setTargetPosition(target);
            bright.setTargetPosition(target);
            fleft.setTargetPosition(-target);
            fright.setTargetPosition(target);
            bleft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            bright.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            fleft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            fright.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            bleft.setVelocity(speed);
            bright.setVelocity(speed);
            fleft.setVelocity(speed);
            fright.setVelocity(speed);
            
            
            bleft.setPower(0);
            fright.setPower(0);
            bright.setPower(0);
            fleft.setPower(0);
            telemetry.addData("velocity", bright.getVelocity());
            telemetry.addData("position", bright.getCurrentPosition());
            telemetry.addData("is at target", !bright.isBusy());
            telemetry.update();
            //bright.setDirection(DcMotor.Direction.REVERSE);
            sleep(time);
    }
    public void DriveRight(int target, int speed, long time)
    {
        bleft.setTargetPosition(-target);
            bright.setTargetPosition(target);
            fleft.setTargetPosition(-target);
            fright.setTargetPosition(-target);
            bleft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            bright.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            fleft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            fright.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            bleft.setVelocity(speed);
            bright.setVelocity(speed);
            fleft.setVelocity(speed);
            fright.setVelocity(speed);
            
            bleft.setPower(0);
            fright.setPower(0);
            bright.setPower(0);
            fleft.setPower(0);
            telemetry.addData("velocity", bright.getVelocity());
            telemetry.addData("position", bright.getCurrentPosition());
            telemetry.addData("is at target", !bright.isBusy());
            telemetry.update();
            //bright.setDirection(DcMotor.Direction.REVERSE);
            sleep(time);
        
    }
    public void DriveLeft(int target, int speed, long time)
    {
        bleft.setTargetPosition(target);
            bright.setTargetPosition(-target);
            fleft.setTargetPosition(target);
            fright.setTargetPosition(target);
            bleft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            bright.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            fleft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            fright.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            bleft.setVelocity(speed);
            bright.setVelocity(speed);
            fleft.setVelocity(speed);
            fright.setVelocity(speed);
            
            
            bleft.setPower(0);
            fright.setPower(0);
            bright.setPower(0);
            fleft.setPower(0);
            telemetry.addData("velocity", bright.getVelocity());
            telemetry.addData("position", bright.getCurrentPosition());
            telemetry.addData("is at target", !bright.isBusy());
            telemetry.update();
            //bright.setDirection(DcMotor.Direction.REVERSE);
            sleep(time);
        
    }
    public void TurnRight(int target, int speed, long time)
    {
        bleft.setTargetPosition(target);
            bright.setTargetPosition(-target);
            fleft.setTargetPosition(-target);
            fright.setTargetPosition(-target);
            bleft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            bright.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            fleft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            fright.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            bleft.setVelocity(speed);
            bright.setVelocity(speed);
            fleft.setVelocity(speed);
            fright.setVelocity(speed);
            
            bleft.setPower(0);
            fright.setPower(0);
            bright.setPower(0);
            fleft.setPower(0);
            telemetry.addData("velocity", bright.getVelocity());
            telemetry.addData("position", bright.getCurrentPosition());
            telemetry.addData("is at target", !bright.isBusy());
            telemetry.update();
            //bright.setDirection(DcMotor.Direction.REVERSE);
            sleep(time);
   
    }
    public void TurnLeft(int target, int speed, long time)
    {
         bleft.setTargetPosition(-target);
            bright.setTargetPosition(target);
            fleft.setTargetPosition(target);
            fright.setTargetPosition(target);
            bleft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            bright.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            fleft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            fright.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            bleft.setVelocity(speed);
            bright.setVelocity(speed);
            fleft.setVelocity(speed);
            fright.setVelocity(speed);
            
            bleft.setPower(0);
            fright.setPower(0);
            bright.setPower(0);
            fleft.setPower(0);
            telemetry.addData("velocity", bright.getVelocity());
            telemetry.addData("position", bright.getCurrentPosition());
            telemetry.addData("is at target", !bright.isBusy());
            telemetry.update();
            //bright.setDirection(DcMotor.Direction.REVERSE);
            sleep(time);
            
    }
    public void StopDriving()
    {
        fleft.setPower(0);
        fright.setPower(0);
        bleft.setPower(0);
        bright.setPower(0);
    }
    public void ResetEncoders()
    {
        bleft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bright.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        fleft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        fright.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

}
    
   
    
    
