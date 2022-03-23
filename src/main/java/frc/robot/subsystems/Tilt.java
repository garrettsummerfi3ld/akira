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

import frc.robot.Constants.ElevatorMotorConstants;
import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

public class Tilt extends SubsystemBase {
    private VictorSPX liftVictor;
    private BuiltInAccelerometer accel;

    public Tilt() {
        liftVictor = new VictorSPX(ElevatorMotorConstants.kWinchMotorCanID);
        liftVictor.setInverted(false);

        accel = new BuiltInAccelerometer();
    }

    @Override
    public void periodic() {
    }

    @Override
    public void simulationPeriodic() {
    }

    /**
     * Method to tilt the robot up
     * 
     * This will be used in conjunction with the winch subsystem (Otis)
     */
    public void tiltUp() {
        liftVictor.set(ControlMode.PercentOutput, 0.5);
    }

    /**
     * Method to tilt the robot down
     * 
     * This will be used in conjucntion with the winch subsystem (Otis)
     */
    public void tiltDown() {
        liftVictor.set(ControlMode.PercentOutput, -0.5);
    }

    /**
     * Method to return the acceleration in the X axis
     * 
     * @return deouble Value in the X axis of acceleration
     */
    public double getAccelX() {
        return accel.getX();
    }

    /**
     * Method to return the acceleration in the Y axis
     * 
     * @return double Value in the Y axis of acceleration
     */
    public double getAccelY() {
        return accel.getY();
    }

    /**
     * Method to rerturn the acceleration in the Z axis
     * 
     * @return double Value in the Z axis of acceleration
     */
    public double getAccelZ() {
        return accel.getZ();
    }
}
