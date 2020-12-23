package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;

public class MoveArmUp extends CommandBase {

    private final Arm arm;

    public MoveArmUp(Arm arm) {
        this.arm = arm;
    }

    public void execute(double armSpeed) {

        arm.moveArm(armSpeed);
    }

   
    public boolean isFinished() {
        return true;
    }



    
}
