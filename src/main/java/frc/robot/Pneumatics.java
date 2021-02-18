/**
 * Functions to set the intake solenoid open or closed, as well as turn on and off the compressor
 */
package frc.robot;

import frc.robot.Motors;

public class Pneumatics {

    /**
     * Sets the solenoid for the intake pneumatics open and closed
     * @param value whether the intake should be down or not
     * 
     * !!! FIX TO SET ON TOGGLE AND NOT EVERY TICK !!!
     */
	public static void setPneumatics(boolean value) {
        Motors.intakeSolenoid.set(value);
    }
    
    /**
     * Turns the compressor on and off
     * @param on If the compressor should be on or not
     */
    public static void setCompressor(boolean on){
        if(on){
            Motors.compressor.start();
        } else {
            Motors.compressor.stop();
        }
    }
}