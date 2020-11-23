public class SteelTalonsController extends PWMVictorSPX{
    

    private boolean reverse;
    private double bias; 

    public SteelTalonsController(int channel, boolean reverse, double bias){
        super(channel);
        this.reverse = reverse;
        this.bias = bias;
        setInverted(reverse);
    }

    public void set( double speed, boolean reverse) {

        if(reverse)
            setInverted(!this.reverse);
        else
            setInverted(this.reverse);
        super.set(speed * bias);
    }
}
