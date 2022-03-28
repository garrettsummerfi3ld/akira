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
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;

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
    private final Winch m_winch = new Winch();
    private final Tilt m_tilt = new Tilt();
    private final BallIntake m_ballIntake = new BallIntake();
    private final BallShooter m_ballShooter = new BallShooter();
    private final BallClock m_ballClock = new BallClock();
    private final Drivetrain m_mechanumDrive = new Drivetrain();
    private final PowerPanel m_power = new PowerPanel();

    SendableChooser<Command> m_chooser = new SendableChooser<>();

    private RobotContainer() {

        m_mechanumDrive.setDefaultCommand(new MechanumDrive(m_mechanumDrive));
        m_ballShooter.setDefaultCommand(new BallShoot(m_ballShooter, m_ballClock));
        m_ballClock.setDefaultCommand(new BallShoot(m_ballShooter, m_ballClock));
        m_ballIntake.setDefaultCommand(new IntakeBall(m_ballIntake));
        m_winch.setDefaultCommand(new LiftRobot(m_winch));
        m_tilt.setDefaultCommand(new TiltRobot(m_tilt));

        // Basic SmartDashboard
        SmartDashboard.putBoolean("Clock Set", m_ballClock.getClockSet());
        SmartDashboard.putBoolean("Shooter", m_ballShooter.getShooterRunningMaxSpeed());
        SmartDashboard.putNumberArray("Power Distribution", m_power.getVitals());
        SmartDashboard.putData(m_mechanumDrive);
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
