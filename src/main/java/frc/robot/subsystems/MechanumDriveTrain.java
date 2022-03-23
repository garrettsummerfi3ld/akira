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

import frc.robot.Constants.DriveMotorConstants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxRelativeEncoder;

public class MechanumDriveTrain extends SubsystemBase {
    private final CANSparkMax leftFrontSparkMAX;
    private final CANSparkMax rightFrontSparkMAX;
    private final CANSparkMax leftRearSparkMAX;
    private final CANSparkMax rightRearSparkMAX;
    private final MecanumDrive drivetrain;
    private RelativeEncoder leftFrontEncoder;
    private RelativeEncoder rightFrontEncoder;
    private RelativeEncoder leftRearEncoder;
    private RelativeEncoder rightRearEncoder;

    /**
     * The main drivetrain class, this has all the motors and encoders that relate to the drivetrain
     */
    public MechanumDriveTrain() {
        leftFrontSparkMAX = new CANSparkMax(DriveMotorConstants.kLeftFrontMotorCanID, MotorType.kBrushed);
        leftFrontSparkMAX.setInverted(false);
        leftFrontEncoder = leftFrontSparkMAX.getEncoder(SparkMaxRelativeEncoder.Type.kQuadrature, 2048);

        rightFrontSparkMAX = new CANSparkMax(DriveMotorConstants.kRightFrontMotorCanID, MotorType.kBrushed);
        rightFrontSparkMAX.setInverted(false);
        rightFrontEncoder = rightFrontSparkMAX.getEncoder(SparkMaxRelativeEncoder.Type.kQuadrature, 2048);

        leftRearSparkMAX = new CANSparkMax(DriveMotorConstants.kLeftRearMotorCanID, MotorType.kBrushed);
        leftRearSparkMAX.setInverted(false);
        leftRearEncoder = leftRearSparkMAX.getEncoder(SparkMaxRelativeEncoder.Type.kQuadrature, 2048);

        rightRearSparkMAX = new CANSparkMax(DriveMotorConstants.kRightRearMotorCanID, MotorType.kBrushed);
        rightRearSparkMAX.setInverted(false);
        rightRearEncoder = rightRearSparkMAX.getEncoder(SparkMaxRelativeEncoder.Type.kQuadrature, 2048);

        drivetrain = new MecanumDrive(leftFrontSparkMAX, rightFrontSparkMAX, leftRearSparkMAX, rightRearSparkMAX);
        addChild("Drivetrain", drivetrain);
        drivetrain.setSafetyEnabled(true);
        drivetrain.setExpiration(0.1);
    }

    @Override
    public void periodic() {

    }

    @Override
    public void simulationPeriodic() {

    }

    /**
     * Main drivetrain movement, this pipes all the joystick movement to the drivetrain and has it driving
     * in a cartesian plane, with x, y, and z axises
     * 
     * @param xSpeed double Input from the x-axis on the joystick
     * @param ySpeed double Input from the y-axis on the joystick
     * @param zRotate double Input from the rotate on the joystick
     * @param speedSlider double Input from the throttle on the joystick
     */
    public void drivetrain(double xInput, double yInput, double zInput, double speedSlider){
        double xSpeed = xInput * speedSlider;
        double ySpeed = yInput * speedSlider;
        double zRotate = zInput * speedSlider;
        drivetrain.driveCartesian(xSpeed, ySpeed, zRotate);
    }

    /**
     * Gets all the encoder positions from the drivetrain
     * 
     * @return double[] of all encoder values, will be returned in leftFront, rightFront, leftRear, rightRear and in units of revolutions
     */
    public double[] getEncoderPositions() {
        double leftFrontEnc = leftFrontEncoder.getPosition();
        double rightFrontEnc = leftRearEncoder.getPosition();
        double leftRearEnc = rightFrontEncoder.getPosition();
        double rightRearEnc = rightRearEncoder.getPosition();

        double[] encVals = {leftFrontEnc, rightFrontEnc, leftRearEnc, rightRearEnc};

        return encVals;
    }

    /**
     * Gets all encoder velocities from the drivetrain
     * 
     * @return double[] of all encoder values, will be returned in leftFront, rightFront, leftRear, rightRear and in units of RPM
     */
    public double[] getEncoderVeolocity(){
        double leftFrontEnc = leftFrontEncoder.getVelocity();
        double rightFrontEnc = leftRearEncoder.getVelocity();
        double leftRearEnc = rightFrontEncoder.getVelocity();
        double rightRearEnc = rightRearEncoder.getVelocity();

        double[] encVals = {leftFrontEnc, rightFrontEnc, leftRearEnc, rightRearEnc};

        return encVals;
    }
}
