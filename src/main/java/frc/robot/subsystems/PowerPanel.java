// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PowerDistribution;
import edu.wpi.first.wpilibj.PowerDistribution.ModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class PowerPanel extends SubsystemBase {
    // Hardware
    PowerDistribution powDist;

    public PowerPanel() {
        powDist = new PowerDistribution(0, ModuleType.kCTRE);
    }

    @Override
    public void periodic() {
    }

    /**
     * Retuns current from a channel on the PDP
     * 
     * @param channel int Channel on the PDP
     * @return double Amount of current running to that channel
     */
    public double getChannelCurrent(int channel) {
        return powDist.getCurrent(channel);
    }

    /**
     * Returns the total number of CAN devices plugged into the PDP
     * 
     * @return int Number of CAN devices plugged in
     */
    public int getTotalCanModules() {
        return powDist.getNumChannels();
    }

    /**
     * Returns all vitals of the power distribution panel
     * 
     * @return double[] Temperature, total current, total energy, total power, and
     *         votage in that order
     */
    public double[] getVitals() {
        double temp = powDist.getTemperature();
        double totalCurrent = powDist.getTotalCurrent();
        double totalEnergy = powDist.getTotalEnergy();
        double totalPower = powDist.getTotalPower();
        double voltage = powDist.getVoltage();

        return new double[] { temp, totalCurrent, totalEnergy, totalPower, voltage };
    }
}
