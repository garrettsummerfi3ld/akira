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
import frc.robot.commands.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Encoder.IndexingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class MechanumDriveTrain extends SubsystemBase {

    private final CANSparkMaxSendable leftFrontSparkMAX;
    private final CANSparkMaxSendable rightFrontSparkMAX;
    private final CANSparkMaxSendable leftRearSparkMAX;
    private final CANSparkMaxSendable rightRearSparkMAX;
    private final MecanumDrive drivetrain;
    private Encoder leftFrontEncoder;
    private Encoder rightFrontEncoder;
    private Encoder leftRearEncoder;
    private Encoder rightRearEncoder;


    public MechanumDriveTrain() {
        leftFrontSparkMAX = new CANSparkMaxSendable(0, MotorType.kBrushed);
        addChild("LeftFrontSparkMAX", leftFrontSparkMAX);
        leftFrontSparkMAX.setInverted(false);

        rightFrontSparkMAX = new CANSparkMaxSendable(3, MotorType.kBrushed);
        addChild("RightFrontSparkMAX", rightFrontSparkMAX);
        rightFrontSparkMAX.setInverted(false);

        leftRearSparkMAX = new CANSparkMaxSendable(4, MotorType.kBrushed);
        addChild("LeftRearSparkMAX", leftRearSparkMAX);
        leftRearSparkMAX.setInverted(false);

        rightRearSparkMAX = new CANSparkMaxSendable(5, MotorType.kBrushed);
        addChild("RightRearSparkMAX", rightRearSparkMAX);
        rightRearSparkMAX.setInverted(false);

        drivetrain = new MecanumDrive(leftFrontSparkMAX, rightFrontSparkMAX, leftRearSparkMAX, rightRearSparkMAX);
        addChild("Drivetrain", drivetrain);
        drivetrain.setSafetyEnabled(true);
        drivetrain.setExpiration(0.1);
        drivetrain.setMaxOutput(Constants.PowerConstants.drivePowerLimit);

        leftFrontEncoder = new Encoder(2, 3, false);
        addChild("LeftFrontEncoder", leftFrontEncoder);
        leftFrontEncoder.setDistancePerPulse(1.0);
        leftFrontEncoder.setIndexSource(4, IndexingType.kResetOnRisingEdge);

        rightFrontEncoder = new Encoder(5, 6, false);
        addChild("RightFrontEncoder", rightFrontEncoder);
        rightFrontEncoder.setDistancePerPulse(1.0);
        rightFrontEncoder.setIndexSource(7, IndexingType.kResetOnRisingEdge);

        leftRearEncoder = new Encoder(8, 9, false);
        addChild("LeftRearEncoder", leftRearEncoder);
        leftRearEncoder.setDistancePerPulse(1.0);
        leftRearEncoder.setIndexSource(10, IndexingType.kResetOnRisingEdge);

        rightRearEncoder = new Encoder(11, 12, false);
        addChild("RightRearEncoder", rightRearEncoder);
        rightRearEncoder.setDistancePerPulse(1.0);
        rightRearEncoder.setIndexSource(13, IndexingType.kResetOnRisingEdge);
    }

    @Override
    public void periodic() {

    }

    @Override
    public void simulationPeriodic() {

    }

    public void drivetrain(double x, double y, double z){
        drivetrain.driveCartesian(x, y, z);
    }

    public double[] getEncoderValues() {
        double leftFrontEnc = leftFrontEncoder.getRate();
        double rightFrontEnc = leftRearEncoder.getRate();
        double leftRearEnc = rightFrontEncoder.getRate();
        double rightRearEnc = rightRearEncoder.getRate();

        double[] encVals = {leftFrontEnc, rightFrontEnc, leftRearEnc, rightRearEnc};

        return encVals;
    }
}
