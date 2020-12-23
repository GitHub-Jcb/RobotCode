package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.SpeedController;

public class Wrist extends SubsystemBase {
    
    private final SpeedController WristSc;
    public double wristAngle;
    public double topLimit;
    public double bottomLimit;
    public double currentArmH;
    
    

    public Wrist(SpeedController W, double wristAngle, double top, double bottom, double height) {
        this.WristSc = W;
        this.wristAngle = wristAngle;
        this.topLimit = top;
        this.bottomLimit = bottom;
        this.currentArmH = height;
    }

    public void moveWristUp(double wristSpeed) {
        if(currentArmH < topLimit) {
            WristSc.set(wristSpeed);
        }
    }

    public void moveWristDown(double wristSpeed) {
        if(currentArmH > bottomLimit) {
            WristSc.set(-1 * wristSpeed);
        }
    }

    public void stopWrist() {
        WristSc.set(0);
    }

    public double returnWristAngle() {
        return this.wristAngle;
    }
    


}
