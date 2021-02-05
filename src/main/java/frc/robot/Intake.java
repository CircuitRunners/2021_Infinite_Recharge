package frc.robot;

public class Intake {

    // Gets the right and left bumper, returns forward on right bumper and backward on left bumper, 0.0 on neither
    public static double getBumper(){

        if(Robot.driver.getRawButton(Logitech.BTN_RIGHT_BUMPER)){
            return 0.5;
        } else {

        if(Robot.driver.getRawButton(Logitech.BTN_LEFT_BUMPER)){
            return -0.5;
        }

        else {
            return 0.0;
        }

        }
    }



    public static void intake(){
        Motors.intakeGroup.set(getBumper());
    }
}