// RobotBuilder Version: 4.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

// ROBOTBUILDER TYPE: RobotContainer.

package frc.robot;

import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.ControllerConstants;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot
 * (including subsystems, commands, and button mappings) should be declared
 * here.
 */
public class RobotContainer {
    private static RobotContainer m_robotContainer = new RobotContainer();

    // The robot's subsystems
    public final Winch m_winch = new Winch();
    public final Tilt m_tilt = new Tilt();
    public final BallIntake m_ballIntake = new BallIntake();
    public final BallShooter m_ballShooter = new BallShooter();
    public final BallClock m_ballClock = new BallClock();
    public final Drivetrain m_mechanumDrive = new Drivetrain();
    public final PowerPanel m_power = new PowerPanel();

    SendableChooser<Command> m_chooser = new SendableChooser<>();

    private RobotContainer() {

        m_mechanumDrive.setDefaultCommand(new MechanumDrive(m_mechanumDrive));

        SmartDashboard.putData("Drivetrain", m_mechanumDrive);
        SmartDashboard.putData("Winch", m_winch);
        SmartDashboard.putData("Tilt", m_tilt);
        SmartDashboard.putData("Intake", m_ballIntake);
        SmartDashboard.putData("Clock", m_ballClock);
        SmartDashboard.putData("Shooter", m_ballShooter);
        SmartDashboard.putData("Power Distribution", m_power);
    }

    public static RobotContainer getInstance() {
        return m_robotContainer;
    }

    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */
    public Command getAutonomousCommand() {
        // The selected command will be run in autonomous
        return m_chooser.getSelected();
    }
}
