package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Wrist;

public class MoveWristDown {
    private final Wrist wrist;

    public MoveWristDown(Wrist wrist) {
        this.wrist = wrist;
    }

    public void execute(double wristSpeed) {
        wrist.moveWristDown(wristSpeed);
    }

    public boolean isFinished() {
        return true;
    }
}
