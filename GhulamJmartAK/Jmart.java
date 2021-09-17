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
    
    public static int getPromo() {
        return 0;
    }
        
    public static String getCustomer() {
        return "oop";
    }
        
    public static float getDiscountPercentage(int before, int after) {
        if(before<after) {
            return 0;
        }
        else {
                return (((float)(before)-(float)(after))/(float)(before))*100;
        }
    }
    
    public static int getDiscountedPrice(int price, float discountPercentage) {
        int newPrice;
        if(discountPercentage >= 100.0f) {
            return 0;
        }
        else {
            newPrice = price - (int)((float)price * (discountPercentage /100 ));
            return newPrice;
        }
    }

    public static int getOriginalPrice(int discountedPrice, float discountPercentage){
        if(discountPercentage >= 100.0f) {
            return 0;
        }
        else {
            return (int)((float)discountedPrice * (100/(100-discountPercentage)));
        }
    }

    public static float getCommissionMultiplier() {
        return 0.05f;
    }

    public static int getAdjustedPrice(int price) {
        return price + (int)(price * getCommissionMultiplier());
    }

    public static int getAdminFee(int price) {
        return (int)(price * getCommissionMultiplier());
    }
}
