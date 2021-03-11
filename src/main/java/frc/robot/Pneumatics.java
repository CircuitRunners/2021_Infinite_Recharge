/**
 * Functions to set the intake solenoid open or closed, as well as turn on and off the compressor
 */
package frc.robot;

import frc.robot.Motors;

public class Pneumatics {

    Boolean compressorOn;
    Boolean intakeOn;

    public Pneumatics() {
        compressorOn = false;
        intakeOn = false;
    }

    /**
     * Sets the solenoid for the intake pneumatics open and closed
     * @param toggle whether to toggle the intake pneumatics open / closed
     */
	public void setPneumatics(boolean toggle) {
        if(toggle){
            if(!intakeOn){

                Motors.intakeSolenoid.set(true);
            } else {

                Motors.intakeSolenoid.set(false);
            }
        }
    }
    
    /**
     * Turns the compressor on and off
     * @param toggle Whether or not to toggle the compressor on / off
     */
    public void setCompressor(boolean toggle) {
        if(toggle){
            if(!compressorOn){
                Motors.compressor.start();
            } else {
                Motors.compressor.stop();
            }
        }
    }
}