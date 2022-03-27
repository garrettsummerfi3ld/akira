// RobotBuilder Version: 4.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean
 * constants. This class should not be used for any other purpose. All constants
 * should be
 * declared globally (i.e. public static). Do not put anything functional in
 * this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the
 * constants are needed, to reduce verbosity.
 */
public class Constants {

    // ==== DRIVETRAIN MOTOR CONTROLLERS ====
    // This is where you should put your motor controllers and have them associated
    // with the correct CAN ID on the bus for the DRIVETRAIN system
    public static final class DriveMotorConstants {
        public static final int kLeftFrontMotorCanID = 10;
        public static final int kRightFrontMotorCanID = 1;
        public static final int kLeftRearMotorCanID = 2;
        public static final int kRightRearMotorCanID = 3;
    }

    // ==== SHOOTER MOTOR CONTROLLERS ====
    // This is where you should put your motor controllers and have them associated
    // with the correct CAN ID on the bus for the SHOOTER, CLOCKING, and INTAKE
    // systems.
    public static final class ShooterMotorConstants {
        public static final int kShooterMotorCanID = 4;
        public static final int kIntakeMotorCanID = 7;
        public static final int kClockMotorCanID = 8;
    }

    // ==== ELEVATOR MOTOR CONTROLLERS ====
    // This is where you should put your motor controllers and have them associated
    // with the correct CAN ID on the bus for the ELEVATOR systems
    public static final class ElevatorMotorConstants {
        public static final int kWinchMotorCanID = 5;
        public static final int kTiltMotorCanID = 6;
    }

    // ==== POWER LIMITS ====
    // This is where you should put power limits for each subsystem that has power.
    // Be careful with power limits, this can cause bad things to happen if you give
    // the subsystem more than enough power. These will all have a range of -1.0 to
    // 1.0
    public static final class PowerConstants {
        public static final int kPowerDistribCanID = 11;
        public static final double drivePowerLimit = 1.0;
        public static final double shooterPowerLimit = 1.0;
        public static final double winchPowerLimit = 0.75;
        public static final double tiltPowerLimit = 0.3;
        public static final double clockingPowerLimit = ;
        public static final double intakePowerLimit = 1;
    }

    // ==== SENSOR ANALOG PORTS ====
    // This is where you should put your sensor inputs that are used to align the
    // ball inside the clocking systems
    public static final class ShooterSensorConstants {
        public static final int kSensorTop = 1;
        public static final int kSensorBottom = 0;
        public static final int kSensorTopLowerThreshold = 3500;
        public static final int kSensorTopUpperThreshold = 200;
        public static final int kSensorBottomLowerThreshold = 3500;
        public static final int kSensorBottomUpperThreshold = 200;
    }

    // ==== CONTROLLER PORTS ====
    // This is where you should put your controller ports for the robot. This is
    // vital as the ports have to be in this order for things to work properly
    public static final class ControllerConstants {
        public static final int driverJoystickPort = 0;
        public static final int auxXboxController = 1;
    }
}
