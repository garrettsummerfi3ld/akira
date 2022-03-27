// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.UsbCamera;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.CameraConstants;

public class CameraViews extends SubsystemBase {
    private UsbCamera mainCamera;
    private UsbCamera elevatorCamera;

    NetworkTableEntry cameraSel;

    /** Creates a new CameraViews. */
    public CameraViews() {
        mainCamera = CameraServer.startAutomaticCapture(CameraConstants.driverCamera);
        elevatorCamera = CameraServer.startAutomaticCapture(CameraConstants.elevatorCamera);

        cameraSel = NetworkTableInstance.getDefault().getTable("").getEntry("Camera Selection");
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

    /**
     * Sets camera view in dashboards
     * 
     * @param port int Sets camera view on dashboard
     */
    public void setCameraView(int port) {
        if (port == 0) {
            cameraSel.setString(mainCamera.getName());
        } else if (port == 1) {
            cameraSel.setString(elevatorCamera.getName());
        }
    }
}
