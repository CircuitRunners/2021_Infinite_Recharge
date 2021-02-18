/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import frc.robot.Pneumatics;
import frc.robot.Motors;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj.Joystick;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private Command m_autonomousCommand;

  public static Joystick driver = new Joystick(0);
  public static Joystick copilot = new Joystick(1);

  private RobotContainer m_robotContainer;

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    Motors.init();
    
    
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {

  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
  }

  /**
   * This autonomous runs the autonomous command selected by your {@link RobotContainer} class.
   */
  @Override
  public void autonomousInit() {

  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
  }

  /**
   * This function is called periodically during operator control.
   */

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
    
          Motors.left.set(l* 0.6);                  // multiplies left and right speed by number inbetween 0 and 1, speed modifiers can be implemented here later
          Motors.right.set(r* 0.6);
    
          prev_left = l;
          prev_right = r;
    
      }
  
  /**
   * Runs every clock cycle in teleop.
   * Drives the robot
   * Runs the intake
   * Runs the indexer
   * Sets pneumatics
   */
  @Override
  public void teleopPeriodic() {
    drive(driver.getRawAxis(Logitech.AXIS_LEFTY), driver.getRawAxis(Logitech.AXIS_RIGHTY));
    
    Intake.intake(Robot.driver.getRawButton(Logitech.BTN_RIGHT_BUMPER), Robot.driver.getRawButton(Logitech.BTN_LEFT_BUMPER));

    Indexer.setIndexer(Robot.driver.getRawButtonPressed(Logitech.BTN_Y));

    Pneumatics.setPneumatics(driver.getRawButtonPressed(Logitech.BTN_X));
    Pneumatics.setCompressor(driver.getRawButtonPressed(Logitech.BTN_START));
  }

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}

/**
 * Buttons Used:
 * X = turn on intake
 * Left Stick Y Axis = Left motors
 * Right Stick Y Axis = Right motors
 * Start = Compressor
 * Y = indexer
 */