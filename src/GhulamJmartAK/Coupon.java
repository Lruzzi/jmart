package GhulamJmartAK;


/**
 * Write a description of class Coupon here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Coupon extends Recognizable implements FileParser
{
    // instance variables - replace the example below with your own
    public final String name;
    public final int code;
    public final double cut;
    public final Type type;
    public final double minimum;
    private boolean used;
    
    public static enum Type{
        DISCOUNT, REBATE
    }

    public Coupon(int id, String name, int code, Type type, double cut, double minimum)
    {
        super(id);
        this.name = name;
        this.code = code;
        this.cut = cut;
        this.type = type;
        this.minimum = minimum;
        used = false;
    }
    
    public boolean isUsed(){
        return used;
    }
    
    public boolean canApply(PriceTag priceTag) {
        if(priceTag.getAdjustedPrice() >= minimum && this.used == false){
            return true;
        }
        else{
            return false;
        }
    }
    
    public double apply(PriceTag priceTag) {
        used = true;
        switch(type)
        {
            case DISCOUNT :
                return (priceTag.getAdjustedPrice() * ((100-cut) / 100));
            default :
                return (priceTag.getAdjustedPrice() - cut);
        }
    }
    
    public boolean read(String content) {
        return false;
    }
}
