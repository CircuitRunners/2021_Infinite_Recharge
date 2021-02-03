package frc.robot;


import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.*;

public class Drivebase{


private static WPI_TalonFX left1,left2,right1,right2;
     private static SpeedControllerGroup left,right;
    public static void init(){

        left1 = new WPI_TalonFX(0);
        left2 = new WPI_TalonFX(2);
        right1 = new WPI_TalonFX(3);
        right2 = new WPI_TalonFX(4);
        
        left = new SpeedControllerGroup(left1, left2);
        right = new SpeedControllerGroup(right1, right2);
        left.setInverted(true);
    }
    
    //Brownout prevention, limits how quickly the motors can change speed and/or direction. COURTESY NATHAN THANKS BUDDY
    private static double safety(double cmdVal, double prevVal, double maxChange) {

		double diff = cmdVal - prevVal;
		if (Math.abs(diff) < maxChange) {
			return cmdVal;
		} else {
			if (diff > 0) {
				return prevVal + maxChange;
			} else {
				return prevVal - maxChange;
			}
		
        }
    }
    //drive smoothing, allows for better driving

    private static double smooth(double value, double deadBand, double max) {

		double aValue = Math.abs(value);
		if (aValue > max)
			return (value / aValue);
		else if (aValue < deadBand)
			return 0;
		else
			return aValue * aValue * (value / aValue);
    }

    private static double prev_left = 0;
    private static double prev_right = 0;
    public static void drive(double l, double r){

        //write/copy in drive code smoothing and safety methods

        l = smooth(l, 0.02,0.9);
        r = smooth(r,0.02,0.9);

        l = safety(l, prev_left, 0.3);
        r = safety(r, prev_right, 0.3);

        left.set(l* 0.6);                  // multiplies left and right speed by number inbetween 0 and 1, speed modifiers can be implemented here later
        right.set(r* 0.6);

        prev_left = l;
        prev_right = r;

    }
}