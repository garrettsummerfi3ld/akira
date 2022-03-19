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

import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.AnalogInput;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

public class BallClock extends SubsystemBase {

    private AnalogInput bottomSensor;
    private AnalogInput topSensor;
    private VictorSPX clockVictor;

    public BallClock() {
        clockVictor = new VictorSPX(Constants.ShooterMotorConstants.kClockMotorCanID);

        bottomSensor = new AnalogInput(Constants.ShooterSensorConstants.kSensorBottom);
        addChild("BottomSensor", bottomSensor);

        topSensor = new AnalogInput(Constants.ShooterSensorConstants.kSensorTop);
        addChild("TopSensor", topSensor);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run when in simulation
    }

    /**
     * Accepts a ball into the clocking mechanism.
     */
    public void acceptBall() {
        clockVictor.set(ControlMode.PercentOutput, 0.5);
    }

    /**
     * Sets a ball into the clocking mechanism and preps it for shooting
     */
    public void setBall() {
        if (bottomSensor.getValue() >= Constants.ShooterSensorConstants.kSensorLowerThreshold || topSensor.getValue() <= Constants.ShooterSensorConstants.kSensorUpperThreshold) {
            clockVictor.set(ControlMode.PercentOutput, 0.2);
        }
        else if (bottomSensor.getValue() <= Constants.ShooterSensorConstants.kSensorUpperThreshold || topSensor.getValue() >= Constants.ShooterSensorConstants.kSensorLowerThreshold) {
            clockVictor.set(ControlMode.PercentOutput, -0.2);
        }
        else {
            clockVictor.set(ControlMode.PercentOutput, 0);
        }
    }

    /**
     * Rejects a from the clocking mechanism
     */
    public void rejectBall() {
        clockVictor.set(ControlMode.PercentOutput, -0.5);
    }

}
