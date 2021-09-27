package GhulamJmartAK;


/**
 * Write a description of class Shipment here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Shipment implements FileParser
{
    public String address;
    public int shipmentCost;
    public Duration duration;
    public String receipt;


    public static class Duration
    {
        // instance variables - replace the example below with your own
        public static final Duration INSTANT = new Duration ((byte) (1 << 0));
        public static final Duration SAME_DAY = new Duration ((byte) (1 << 1));
        public static final Duration NEXT_DAY = new Duration ((byte) (1 << 2));
        public static final Duration REGULAR = new Duration ((byte) (1 << 3));
        public static final Duration KARGO = new Duration ((byte) (1 << 4));
        private byte bit;

        public Duration(byte bit)
        {
            this.bit = bit;
        }
    }

    public class MultiDuration {
        public byte bit;

        public MultiDuration(Duration... args) {
            for(Duration i:args) {
                this.bit = (byte) (bit|i.bit);
            };
        }
        
        public boolean isDuration (Duration reference) {
            if((reference.bit & this.bit) != 0) {
                return true;
            }
            else {
                return false;
            }
        }
    }

    public boolean read(String content) {
        return false;
    }

    public Shipment(String address, int shipmentCost, Duration duration, String receipt) {
        this.address = address;
        this.shipmentCost = shipmentCost;
        this.duration = duration;
        this.receipt = receipt;
    }
}
