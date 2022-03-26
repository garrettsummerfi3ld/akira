// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.ControllerConstants;
import frc.robot.subsystems.BallIntake;

public class IntakeBall extends CommandBase {
    // Subsystems
    private final BallIntake m_ballIntake;

    // Controllers
    private final Joystick driverJoystick = new Joystick(ControllerConstants.driverJoystickPort);

    public IntakeBall(BallIntake subsystem) {
        m_ballIntake = subsystem;
        addRequirements(m_ballIntake);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        if (driverJoystick.getRawButton(5)) {
            m_ballIntake.intakeBall();
        } else if (driverJoystick.getRawButton(6)) {
            m_ballIntake.rejectBall();
        }
        else {
            m_ballIntake.stopIntake();
        }
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}
