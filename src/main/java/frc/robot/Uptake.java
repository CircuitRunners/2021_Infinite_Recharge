package frc.robot;

import frc.robot.Motors;

public class Uptake {

    /**
     * Sets the uptake to either send balls up, down, and stops when no input is recieved.
     * @param forward Whether the A button is pressed, signaling to start the uptake forwards
     * @param backward Whether the B button is pressed, signaling to start the uptake backwards
     */
    public static void driveUptake(boolean forward, boolean backward){
        if(forward){

            Motors.uptakeDrive.set(0.4);

        } else if(backward) {

            Motors.uptakeDrive.set(-0.4);

        } else {

            Motors.uptakeDrive.set(0.0);

        }
        
    }
}