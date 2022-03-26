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
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
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

    // The robot controllers
    private final static Joystick driverJoystick = new Joystick(ControllerConstants.driverJoystickPort);
    private final static XboxController auxController = new XboxController(ControllerConstants.auxXboxController);

    SendableChooser<Command> m_chooser = new SendableChooser<>();

    private RobotContainer() {

        configureButtonBindings();

        m_mechanumDrive.setDefaultCommand(new MechanumDrive(m_mechanumDrive));

        SmartDashboard.putData("Auto Mode", m_chooser);
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
     * Use this method to define your button->command mappings. Buttons can be
     * created by
     * instantiating a {@link GenericHID} or one of its subclasses ({@link
     * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing
     * it to a
     * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
     */
    private void configureButtonBindings() {
        // Buttons to be bound to actions
        JoystickButton driverTrigger = new JoystickButton(driverJoystick, Joystick.ButtonType.kTrigger.value);
        JoystickButton driverTopButton = new JoystickButton(driverJoystick, Joystick.ButtonType.kTop.value);

        // Shoots ball with trigger
        driverTrigger.whenPressed(
                () -> {
                    m_ballClock.releaseBall();
                });

        // Revs up ball shooter to shoot at full speed
        driverTopButton.whenPressed(
                () -> {
                    m_ballShooter.shootBall();
                });
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

    /**
     * Returns the driver joystick
     * 
     * @return Joystick the main driver joystick
     */
    public static Joystick getDriverJoystick() {
        return driverJoystick;
    }

    /**
     * Returns the auxiliary Xbox Controller
     * 
     * @return XboxController secondary Xbox controller
     */
    public static XboxController getAuxController() {
        return auxController;
    }
}
