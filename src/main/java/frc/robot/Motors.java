/**
 * Creates all the motor controllers for the drivebase, intake, indexer, and also solenoids for the intake pneumatics
 * left is the left group of Falcon 500's
 * right is the right group of Falcon 500's
 */
package frc.robot;


import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.*;

public class Motors{


public static WPI_TalonFX left1,left2,right1,right2;
    public static SpeedControllerGroup left,right,intakeGroup;
    public static Solenoid intakeSolenoid;
    public static VictorSP intakeDrive;
    public static VictorSP indexerDrive;
    public static Compressor compressor;
    public static void init(){


        left1 = new WPI_TalonFX(0);
        left2 = new WPI_TalonFX(1);
        right1 = new WPI_TalonFX(2);
        right2 = new WPI_TalonFX(3);
        intakeDrive = new VictorSP(4);
        indexerDrive = new VictorSP(5);
        intakeSolenoid = new Solenoid(5);
        compressor = new Compressor(0);
        
        left = new SpeedControllerGroup(left1, left2);
        right = new SpeedControllerGroup(right1, right2);
        left.setInverted(true);
    }
}