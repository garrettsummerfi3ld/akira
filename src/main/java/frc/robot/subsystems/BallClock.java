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

import frc.robot.Constants.ShooterSensorConstants;
import frc.robot.Constants.ShooterMotorConstants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.AnalogInput;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

public class BallClock extends SubsystemBase {
    private AnalogInput bottomSensor;
    private AnalogInput topSensor;
    private VictorSPX clockVictor;

    public BallClock() {
        clockVictor = new VictorSPX(ShooterMotorConstants.kClockMotorCanID);

        bottomSensor = new AnalogInput(ShooterSensorConstants.kSensorBottom);
        addChild("BottomSensor", bottomSensor);

        topSensor = new AnalogInput(ShooterSensorConstants.kSensorTop);
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
     * Accepts a ball into the clocking mechanism
     * 
     * This will be used in conjunction with the intake mechanism
     */
    public void acceptBall() {
        clockVictor.set(ControlMode.PercentOutput, 0.5);
    }

    /**
     * Sets a ball into the clocking mechanism and preps it for shooting
     * 
     * Once the ball is centered exactly then the shooter motor has to be
     * running at the correct speed to launch the ball
     */
    public void setBall() {
        if (checkBottomSensor() && !checkTopSensor()) {
            clockVictor.set(ControlMode.PercentOutput, 0.2);
        } else if (!checkBottomSensor() && checkTopSensor()) {
            clockVictor.set(ControlMode.PercentOutput, -0.2);
        } else {
            clockVictor.set(ControlMode.PercentOutput, 0);
        }
    }

    /**
     * Checks bottom sensor if the ball loaded is lined up properly
     * 
     * @return boolean status if ball is lined up properly
     */
    public Boolean checkBottomSensor() {
        if (bottomSensor.getValue() >= ShooterSensorConstants.kSensorBottomLowerThreshold
                || bottomSensor.getValue() <= ShooterSensorConstants.kSensorBottomUpperThreshold) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks top sensor if the ball loaded is lined up properly
     * 
     * @return boolean status if ball is lined up properly
     */
    public Boolean checkTopSensor() {
        if (topSensor.getValue() >= ShooterSensorConstants.kSensorTopLowerThreshold
                || topSensor.getValue() <= ShooterSensorConstants.kSensorTopUpperThreshold) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Rejects a from the clocking mechanism
     * 
     * This will be used in conjunction with the intake mechanism
     */
    public void rejectBall() {
        clockVictor.set(ControlMode.PercentOutput, -0.5);
    }

}
