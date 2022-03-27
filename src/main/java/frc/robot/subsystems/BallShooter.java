// RobotBuilder Version: 4.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

// ROBOTBUILDER TYPE: Subsystem.

package frc.robot.subsystems;

import frc.robot.Constants.ShooterMotorConstants;
import frc.robot.util.BallVelocity;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.SparkMaxRelativeEncoder;

public class BallShooter extends SubsystemBase {
    // Hardware
    private CANSparkMax shooterSparkMAX;
    private RelativeEncoder shooterEncoder;

    public BallShooter() {
        shooterSparkMAX = new CANSparkMax(ShooterMotorConstants.kShooterMotorCanID, MotorType.kBrushed);
        shooterSparkMAX.setInverted(false);
        shooterEncoder = shooterSparkMAX.getEncoder(SparkMaxRelativeEncoder.Type.kQuadrature, 2048);
    }

    @Override
    public void periodic() {

    }

    @Override
    public void simulationPeriodic() {

    }

    /**
     * Gets encoder position from the shooter motor
     * 
     * @return double[] of the encoder in units of revolutions
     */
    public double getEncoderPosition() {
        return shooterEncoder.getPosition();
    }

    /**
     * Gets encoder velocity from the shooter motor
     * 
     * @return double of the encoder in units of RPM
     */
    public double getEncoderVeolocity() {
        return shooterEncoder.getVelocity();
    }

    /**
     * Shoots ball at full speed
     */
    public void shootBall() {
        shooterSparkMAX.set(1);
    }

    /**
     * Stops shooting motor
     */
    public void stopShooter(){
        shooterSparkMAX.stopMotor();
    }
}
