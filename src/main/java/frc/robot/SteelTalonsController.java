package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class SteelTalonsController extends WPI_VictorSPX 
{
    

    private boolean reverse;
    private double bias; 

    public SteelTalonsController(int deviseNumber, boolean reverse, double bias)
    {
        super(deviseNumber);
        this.reverse = reverse;
        this.bias = bias;
        setInverted(reverse);
    }


    @Override
    public void set( double speed) 
    {
        super.set(speed * bias);
       
    }
}
