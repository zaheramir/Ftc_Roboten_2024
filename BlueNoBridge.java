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
public class BlueNoBridge extends LinearOpMode {
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

        // loop and read the RGB and distance data.
        // Note we use opModeIsActive() as our loop condition because it is an interruptible method.
      
     // DriveForward(0.35);
       //sleep(1100);
       //StopDriving();
       //sleep(300);
      // TurnRight(0.4);
      // sleep(10);
      // StopDriving();
      // sleep(300);
       
        bleft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            bright.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            fleft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            fright.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            
            
       DriveForward(1285,750, 2000);
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
           // sleep(10000); 
        //    StopDriving();
          //  sleep(30000);
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
        public void LeftAutonomous()
        {
            ResetEncoders();
            DriveLeft(570,700,800);
            StopDriving();
            sleep(200);
            ResetEncoders();
            DriveBack(420,700,600);
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
            DriveLeft(1200,2000, 1300);
            StopDriving();
            sleep(200);
            ResetEncoders();
            TurnRight(930,700, 1500);
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
           
            flip.setPosition(0.1);
            open.setPosition(0.06);
            StopDriving();
            sleep(300); 
            ResetEncoders();
            DriveBack(750,500, 850);
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
            DriveRight(800,1200, 1000);
            StopDriving();
            sleep(300);
            
            StopDriving();
            sleep(30000);
            /*
            hold.setPosition(1);
            DriveRight(0.5);
            sleep(550);
            StopDriving();
            sleep(300);
            DriveBack(0.5);
            sleep(180);
            StopDriving();
            sleep(500);
            
            eshab.setPower(0.44);
            sleep(1200);
            halichon.setPower(0);
            eshab.setPower(0);
            sleep(300);
            StopDriving();
            sleep(500);
            
            DriveRight(0.7);
            sleep(710);
            StopDriving();
            sleep(650);
            TurnLeft(0.6);
            sleep(570);
            StopDriving();
            sleep(150);
            DriveRight(0.4);
            sleep(115);
            StopDriving();
            sleep(500);
          
            upleft.setPower(0.5);
            upright.setPower(0.5);
            sleep(900);
            upleft.setPower(0.05);
            upright.setPower(0.05);
            sleep(200);
            flip.setPosition(0.5);
            StopDriving();
            sleep(100);
            DriveBack(0.3);
            sleep(1300);
            StopDriving();
            sleep(1000);
          
            
        
            hold.setPosition(-1);
            sleep(100);
            StopDriving();
            sleep(1200);
             upleft.setPower(0.4);
            upright.setPower(0.4);
            sleep(700);
            upleft.setPower(0.05);
            upright.setPower(0.05);
            sleep(200);
            StopDriving();
            sleep(100);
            DriveForward(0.3);
            sleep(350);
            StopDriving();
            sleep(300);
            DriveLeft(0.6);
            sleep(700);
            StopDriving();
            sleep(300);
            DriveBack(0.4);
            sleep(100);
            StopDriving();
            sleep(30000);*/
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
            DriveLeft(1400,2000, 1650);
            StopDriving();
            sleep(200);
            ResetEncoders();
            TurnRight(900,700, 1500);
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
           
            flip.setPosition(0.1);
            open.setPosition(0.06);
          
            ResetEncoders();
            DriveBack(1650,500, 1700);
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
            
           /*
            DriveRight(0.5);
            sleep(230);
            StopDriving();
            sleep(300);
            DriveBack(0.3);
            sleep(130);
            StopDriving();
            sleep(100);
            eshab.setPower(0.44);
            sleep(1200);
            halichon.setPower(0);
            eshab.setPower(0);
            sleep(300);
            StopDriving();
            sleep(100);
           
            DriveRight(0.7);
            sleep(750);
            TurnLeft(0.6);
            sleep(550);
            StopDriving();
            sleep(150);
            DriveLeft(0.4);
            sleep(100);
            StopDriving();
            sleep(300);
    
          
            upleft.setPower(0.5);
            upright.setPower(0.5);
            sleep(850);
            flip.setPosition(0.4);
            upleft.setPower(0.05);
            upright.setPower(0.05);
            sleep(200);
            StopDriving();
            sleep(100);
            DriveBack(0.3);
            sleep(1500);
            StopDriving();
            sleep(1000);
        
            hold.setPosition(-1);
            sleep(100);
            StopDriving();
            sleep(1200);
             upleft.setPower(0.3);
            upright.setPower(0.3);
            sleep(850);
            flip.setPosition(0.4);
            upleft.setPower(0.05);
            upright.setPower(0.05);
            sleep(200);
            StopDriving();
            sleep(100);
            DriveForward(0.3);
            sleep(350);
            StopDriving();
            sleep(300);
            DriveLeft(0.7);
            sleep(800);
            DriveBack(0.4);
            sleep(300);
        
            StopDriving();
            sleep(30000);*/
        }
        public void RightAutonomous()
        {
           
            ResetEncoders();
            DriveBack(100,700,300);
            StopDriving();
            sleep(200);
            ResetEncoders();
            TurnRight(930,700, 1500);
            StopDriving();
            sleep(300);
            ResetEncoders();
            DriveBack(70,700,200);
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
            DriveBack(1400,1000,1500);
            StopDriving();
            sleep(200);
           
            ResetEncoders();
            DriveLeft(350,700, 800);
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
            DriveBack(850,500,1000);
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
            DriveRight(1500,1200, 1600);
            StopDriving();
            sleep(300);
            
            StopDriving();
            sleep(30000);
            /*
            DriveBack(0.4);
            sleep(50);
            StopDriving();
            sleep(300);
            hold.setPosition(1);
            TurnLeft(0.5);
            sleep(640);
            StopDriving();
            sleep(300);
            DriveForward(0.2);
            sleep(100);
            StopDriving();
            sleep(300);
             DriveBack(0.3);
            sleep(70);
            StopDriving();
            sleep(300);
            eshab.setPower(0.44);
            sleep(1200);
            halichon.setPower(0);
            eshab.setPower(0);
            sleep(300);
            StopDriving();
            sleep(500);
          
            flip.setPosition(0.4);
            DriveBack(0.4);
            sleep(1600);
            StopDriving();
            sleep(300);
            DriveRight(0.4);
            sleep(85);
            StopDriving();
            sleep(300);
            upleft.setPower(0.5);
            upright.setPower(0.5);
            sleep(850);
            upleft.setPower(0.05);
            upright.setPower(0.05);
            sleep(200);
            StopDriving();
            sleep(100);
            DriveBack(0.3);
            sleep(1400);
            StopDriving();
            sleep(1200);
        
            hold.setPosition(-1);
            sleep(100);
            StopDriving();
            sleep(1200);
             upleft.setPower(0.3);
            upright.setPower(0.3);
            sleep(800);
            upleft.setPower(0.05);
            upright.setPower(0.05);
            sleep(200);
            StopDriving();
            sleep(100);
            DriveForward(0.3);
            sleep(350);
            StopDriving();
            sleep(300);
            DriveLeft(0.6);
            sleep(1200);
            StopDriving();
            sleep(300);
            DriveBack(0.4);
            sleep(30);
            StopDriving();
            sleep(30000);
            */
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
            bright.setVelocity(speed-1);
            fleft.setVelocity(speed);
            fright.setVelocity(speed-1);
            
            
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
            bright.setVelocity(speed-1);
            fleft.setVelocity(speed);
            fright.setVelocity(speed-1);
            
            
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
            bright.setVelocity(speed-1);
            fleft.setVelocity(speed);
            fright.setVelocity(speed-1);
            
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
            bright.setVelocity(speed-1);
            fleft.setVelocity(speed);
            fright.setVelocity(speed-1);
            
            
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
            bright.setVelocity(speed-1);
            fleft.setVelocity(speed);
            fright.setVelocity(speed-1);
            
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
    
   
    
    
