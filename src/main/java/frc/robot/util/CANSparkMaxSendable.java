// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.util;

import com.revrobotics.CANSparkMax;
import edu.wpi.first.util.sendable.Sendable;
import edu.wpi.first.util.sendable.SendableBuilder;
import edu.wpi.first.util.sendable.SendableRegistry;

public class CANSparkMaxSendable extends CANSparkMax implements Sendable  {
    /**
     * Creates a sendable object from a CANSparkMAX, this is useful for 
     * telemetry and SmartDashboard/Shuffleboard
     * 
     * @param deviceId int CAN ID for the motor
     * @param motorType MotorType type of motor used
     */
    public CANSparkMaxSendable(int deviceId, MotorType motorType) {
        super(deviceId, motorType);
        SendableRegistry.addLW(this, "SparkMax", deviceId);
    }

    @Override
    public void initSendable(SendableBuilder builder) {
        builder.setSmartDashboardType("Motor Controller");
        builder.setActuator(true);
        builder.setSafeState(this::stopMotor);
        builder.addDoubleProperty("Value", this::get, this::set);
    }
}