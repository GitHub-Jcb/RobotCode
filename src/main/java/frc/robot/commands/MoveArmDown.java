package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;

public class MoveArmDown extends CommandBase{
   
    private final Arm arm;

    public MoveArmDown(Arm arm) {
        this.arm = arm;
    }

    public void execute(double armSpeed) {
        arm.moveArm(-1 * armSpeed);

    }

    public boolean isFinished() {
        return true;
    }
    


    
}


