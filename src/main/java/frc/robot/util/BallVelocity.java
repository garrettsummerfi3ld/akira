// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.util;

public class BallVelocity {
    /**
     * Checks if ball will actually land target from distance
     * 
     * @param dist double Distance to target
     * @param vr   double Velocity
     * @return double Margin of error
     */
    public static double deviance(double dist, double vr) {
        double angleInRadians = 1.22173;
        double hoopHeight = 2.4384;
        double step = 5e-4;
        double massOfProjectile = .4;
        double dragCoefficient = 0.47;
        double airDensity = 1.04;
        double area = Math.PI * (Math.pow(0.3, 2));
        double dragForce = (dragCoefficient * airDensity * area) / (2 * massOfProjectile);
        double gravity = 9.807;

        double x = -dist;
        double y = 0;
        double velocityX = Math.cos(angleInRadians) * vr;
        double velocityY = Math.sin(angleInRadians) * vr;
        double toggle = 0;
        double error = -1;

        while (y >= 0) {
            x = x + step * velocityX;
            y = y + step * velocityY;
            velocityX = velocityX
                    + step * (-dragForce * velocityX * Math.sqrt((Math.pow(velocityX, 2)) + (Math.pow(velocityY, 2))));
            velocityY = velocityY + step
                    * ((-gravity)
                            - dragForce * velocityY * Math.sqrt((Math.pow(velocityX, 2)) + (Math.pow(velocityY, 2))));

            if (y <= hoopHeight && toggle == 1) {
                toggle = toggle + 1;
                error = x;
            }
            if (y >= hoopHeight && toggle == 0) {
                toggle = toggle + 1;
            }
        }

        return error;
    }

    /**
     * Gets final RPM of shooting the ball from current distance
     * 
     * @param dist        Distance to target
     * @param accuracy    Accuracy
     * @param left_bound  Amount of error to go left
     * @param right_bound Amount of error to go right
     * @return Power to shoot ball from current distance
     */
    public static double final_vr(double dist, double accuracy, double left_bound, double right_bound) {
        // Initial guess of velocity
        double test_vr = (right_bound + left_bound) / 2;
        // Checks accuracy
        for (int i = 0; i < accuracy; ++i) {
            // Too large of a velocity
            if (deviance(dist, test_vr) > 0) {
                right_bound = (right_bound + left_bound) / 2;
                // Too small of a velocity
            } else {
                left_bound = (right_bound + left_bound) / 2;
            }
            test_vr = (right_bound + left_bound) / 2;
        }
        return test_vr;
    }
}
