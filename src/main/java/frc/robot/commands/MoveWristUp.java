package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Wrist;

public class MoveWristUp extends CommandBase {

    private final Wrist wrist;

    public MoveWristUp(Wrist wrist) {
        this.wrist = wrist;
    }

    public void execute(double wristSpeed) {
        wrist.moveWristUp(wristSpeed);
    }

    public boolean isFinished() {
        return true;
    }
    
}
