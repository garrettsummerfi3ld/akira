// RobotBuilder Version: 4.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package frc.robot.subsystems;

import frc.robot.Constants.ShooterMotorConstants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

public class BallIntake extends SubsystemBase {
    private VictorSPX IntakeVictor;

    public BallIntake() {
        IntakeVictor = new VictorSPX(ShooterMotorConstants.kIntakeMotorCanID);
        IntakeVictor.setInverted(false);
    }

    @Override
    public void periodic() {

    }

    @Override
    public void simulationPeriodic() {
    }
}
