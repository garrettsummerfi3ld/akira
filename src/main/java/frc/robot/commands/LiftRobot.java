// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.ControllerConstants;
import frc.robot.subsystems.Winch;

public class LiftRobot extends CommandBase {
    // Subsystems
    private final Winch m_winch;

    // Controllers
    private final XboxController auxController = new XboxController(ControllerConstants.auxXboxController);

    public LiftRobot(Winch subsystem) {
        m_winch = subsystem;
        addRequirements(m_winch);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        if (auxController.getLeftY() >= 0.25) {
            m_winch.winchUp();
        } else if (auxController.getLeftY() <= -0.25) {
            m_winch.winchDown();
        }
        else{
            m_winch.winchStop();
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
