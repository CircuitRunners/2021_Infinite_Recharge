package frc.robot;


import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.*;

public class Motors{


public static WPI_TalonFX left1,left2,right1,right2;
    public static SpeedControllerGroup left,right,intakeGroup;
    public static void init(){

        left1 = new WPI_TalonFX(0);
        left2 = new WPI_TalonFX(1);
        right1 = new WPI_TalonFX(2);
        right2 = new WPI_TalonFX(3);
        VictorSP intakeDrive = new VictorSP(4);
        
        intakeGroup = new SpeedControllerGroup(intakeDrive);
        left = new SpeedControllerGroup(left1, left2);
        right = new SpeedControllerGroup(right1, right2);
        left.setInverted(true);
    }
}