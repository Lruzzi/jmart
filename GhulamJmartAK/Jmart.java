package GhulamJmartAK;


/**
 * Write a description of class Jmart here.
 *
 * @author (Ghulam)
 * @version (a version number or a date)
 */

public class Jmart
{
    public float getDiscountedPrice(float price, float discountPercentage) {
            float newPrice;
            if(discountPercentage > 100.0f) {
                return 0;
            }
            else {
                newPrice = price * (discountPercentage /100 );
                return newPrice;
            }
        }
    
    public static int getPromo() {
            return 0;
        }
        
    public static String getCustomer() {
            return "oop";
        }
        
    public static float getDiscountPercentage(int before, int after) {
        if(before<after) {
                return before;
        }
        else {
                return 0.0f;
        }
    }
    
    
    public static void main (String[] args) {
        
        
        }
        
    
}
