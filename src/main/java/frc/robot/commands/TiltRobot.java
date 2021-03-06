// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.ControllerConstants;
import frc.robot.subsystems.Tilt;

public class TiltRobot extends CommandBase {
    // Subsystems
    private final Tilt m_tilt;

    // Controllers
    private final XboxController auxController = new XboxController(ControllerConstants.auxXboxController);

    public TiltRobot(Tilt subsystem) {
        m_tilt = subsystem;
        addRequirements(m_tilt);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        if (auxController.getLeftY() >= 0.25) {
            m_tilt.tiltUp();
        } else if (auxController.getLeftY() <= -0.25) {
            m_tilt.tiltDown();
        } else {
            m_tilt.tiltStop();
        }
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        m_tilt.tiltStop();
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}
