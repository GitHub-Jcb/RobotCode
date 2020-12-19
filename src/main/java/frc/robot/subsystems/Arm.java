package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Arm extends SubsystemBase {
 
    private SpeedController armSc;
    public double armAng;

    public Arm(SpeedController armSc) {

        this.armSc = armSc;
    }

    public void moveArm(double armSpeed) {
        armSc.set(armSpeed);
    }

    public void stopArm() {
        armSc.set(0);
    }

    public void setArmAng(double armAng) {
        this.armAng = armAng;
    }

    public double returnAngle() {
        return armAng;
    }

}


