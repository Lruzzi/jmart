package GhulamJmartAK;


/**
 * Write a description of class Jmart here.
 *
 * @author (Ghulam)
 * @version (9/11/2021)
 */

public class Jmart
{
    public static void main (String[] args) {

    }
    
    public static Product createProduct() {
        return new Product("Keyboard gaming",250,false,new PriceTag(450000.0),ProductCategory.GAMING);
    }
    
    public static Coupon createCoupon(){
        return null;
    }
    
    public static ShipmentDuration createShipmentDuration() {
        return null;
    }
}
