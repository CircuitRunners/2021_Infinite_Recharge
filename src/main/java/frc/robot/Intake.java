package frc.robot;

public class Intake {

    /**
     * Returns the speed to set the bumper to
     * @param RightBumper Whether the Right bumper is on
     * @param LeftBumper Whether the Left bumper is on
     * @return Returns a double in a certain direction depending on the bumper pressed if one is pressed
     */
    private static double getBumper(boolean RightBumper, boolean LeftBumper){

        if(RightBumper){
            return 0.5;
        } else {

        if(LeftBumper){
            return -0.5;
        }

        else {
            return 0.0;
        }

        }
    }


    /**
     * Sets the actual intake motor
     * @param RightBumper variable to pass through to the speed checker
     * @param LeftBumper variable to pass through to the speed checker
     */
    public static void intake(boolean RightBumper, boolean LeftBumper){
        Motors.intakeDrive.set(getBumper(RightBumper, LeftBumper));
    }
}