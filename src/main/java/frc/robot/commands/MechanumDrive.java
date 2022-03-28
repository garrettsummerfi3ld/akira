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
        double[] inputs = procInputs(driveJoystick.getX(), driveJoystick.getY(), driveJoystick.getZ(),
                driveJoystick.getRawAxis(3));
        m_mechDriveTrain.drive(inputs[0], inputs[1], inputs[2], inputs[3]);
    }

    @Override
    public void end(boolean interrupted) {
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    /**
     * Processes inputs from the controller to be used on the drivetrain
     * @param xInput double X-axis input on the controller
     * @param yInput double Y-axis input on the controller
     * @param zRotate double Z-axis input on the controller
     * @param speedSlide double throttle input on the controller
     * @return double[] all values in xInput, yInput, zRotate, and speedSlide
     */
    private double[] procInputs(double xInput, double yInput, double zRotate, double speedSlide) {
        ;
        if (xInput < 0.3 && xInput > -0.3)
            xInput = 0;

        if (yInput < 0.3 && yInput > -0.3)
            yInput = 0;

        xInput *= -1;
        zRotate *= 0.2;
        speedSlide = ((speedSlide * -1) + 1) / 2;
        return new double[] { xInput, yInput, zRotate, speedSlide };
    }
}
