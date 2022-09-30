// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;


/**
 * This sample program shows how to control a motor using a joystick. In the operator control part
 * of the program, the joystick is read and the value is written to the motor.
 *
 * <p>Joystick analog values range from -1 to 1 and speed controller inputs also range from -1 to 1
 * making it easy to work together.
 */
public class Robot extends TimedRobot {
  private static final int kMotorPort = 25;
  private static final int kJoystickPort = 0;
  
  private TalonSRX m_motor;
  private XboxController m_joystick;

  @Override
  public void robotInit() {
    m_motor = new TalonSRX(kMotorPort);
    m_joystick = new XboxController(kJoystickPort);
  }

  @Override
  public void teleopPeriodic() {
    m_motor.set(ControlMode.PercentOutput, m_joystick.getLeftY());
  }
}
