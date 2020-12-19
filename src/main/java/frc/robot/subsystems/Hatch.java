package frc.robot.subsystems;

import edu.wpi.first.hal.sim.mockdata.PCMDataJNI;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Hatch extends SubsystemBase 
{
    private final Solenoid solenoid = new Solenoid(Constants.HATCH_PCM);
    private final boolean hatchDirection;
    public Hatch(Solenoid s, boolean hatchDirection)
    {
        this.solenoid = s;
        this.hatchDirection = hatchDirection;
    }

    public void HatchMove() {

        solenoid.set(hatchDirection);
    }

    
    
}
