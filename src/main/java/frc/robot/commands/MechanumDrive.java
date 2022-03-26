// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.ControllerConstants;
import frc.robot.subsystems.Drivetrain;

public class MechanumDrive extends CommandBase {
    // Subsystems
    private final Drivetrain m_mechDriveTrain;

    // Controllers
    private final Joystick driveJoystick = new Joystick(ControllerConstants.driverJoystickPort);

    public MechanumDrive(Drivetrain subsystem) {
        m_mechDriveTrain = subsystem;
        addRequirements(m_mechDriveTrain);
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        m_mechDriveTrain.drive(driveJoystick.getX(), driveJoystick.getY(), driveJoystick.getZ());
    }

    @Override
    public void end(boolean interrupted) {
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
