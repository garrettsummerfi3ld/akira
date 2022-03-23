// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.MechanumDriveTrain;

public class MechanumDrive extends CommandBase {
    private final MechanumDriveTrain m_mechDriveTrain;

    private final Joystick driveJoystick = RobotContainer.getDriverJoystick();

    public MechanumDrive(MechanumDriveTrain subsystem) {
        m_mechDriveTrain = subsystem;
        addRequirements(m_mechDriveTrain);
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        m_mechDriveTrain.drivetrain(driveJoystick.getX(), driveJoystick.getY(), driveJoystick.getTwist(), driveJoystick.getThrottle());
    }

    @Override
    public void end(boolean interrupted) {
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
