package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;

public class MoveArm extends CommandBase {

    private final Arm arm;

    public MoveArm(Arm arm) {
        this.arm = arm;
    }

    public void execute(double armSpeed) {

        arm.moveArm(armSpeed);
    }

    public void stopArm() {
        
        arm.stopArm();
    }

    public boolean isFinished() {
        return true;
    }



    
}
