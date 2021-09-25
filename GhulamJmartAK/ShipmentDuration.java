package GhulamJmartAK;


/**
 * Write a description of class ShipmentDuration here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ShipmentDuration
{
    // instance variables - replace the example below with your own
    public static final ShipmentDuration INSTANT = new ShipmentDuration(1 << 0);
    public static final ShipmentDuration SAME_DAY = new ShipmentDuration(1 << 1);
    public static final ShipmentDuration NEXT_DAY = new ShipmentDuration(1 << 2);
    public static final ShipmentDuration REGULAR = new ShipmentDuration(1 << 3);
    public static final ShipmentDuration KARGO = new ShipmentDuration(1 << 4);
    private int bit;

    public ShipmentDuration(int bit)
    {
        this.bit = bit;
    }
    
    public ShipmentDuration(ShipmentDuration... args) {
        for(ShipmentDuration i:args) {
            this.bit = bit|i.bit;
        };
    }
    
    public boolean isDuration (ShipmentDuration reference) {
        if((reference.bit & this.bit) != 0) {
            return true;
        }
        else {
            return false;
        }
    }

}
