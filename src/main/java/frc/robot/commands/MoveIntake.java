package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class MoveIntake extends CommandBase
{
    private double speed;

    public MoveIntake(double speed)
    {
        this.speed = speed;
    }   

    @Override
    public void Initialize()
    {
        Robot.m_robotContainer.getIntake().moveIntake(speed);
    }

    @Override
    public void execute()
    {
        Robot.m_robotContainer.getIntake().moveIntake(speed);
    }

    @Override
    public boolean isFinished()
    {
        if(speed > 0) {
            return !Robot.m_robotContainer.getJoystick().getButtonPressed(Constants.INTAKE_IN_BUTTTON);
        
        return !Robot.m_robotContainer.getJoystick().getButtonPressed(Constants.INTAKE_OUT_BUTTTON);
        }
    }

    @Override
    public void end(boolean interrupted)
    {
        Robot.m_robotContainer.getIntake().stopIntake();
    }
}
