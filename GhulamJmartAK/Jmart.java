package GhulamJmartAK;


/**
 * Write a description of class Jmart here.
 *
 * @author (Ghulam)
 * @version (a version number or a date)
 */

public class Jmart
{
    public static void main (String[] args) {
        System.out.println(getDiscountPercentage(1000, 900));
        System.out.println(getDiscountedPrice(90000, getDiscountPercentage(1000, 900)));
        
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
                return (before-after)/10;
            }
        }
    
    public static int getDiscountedPrice(int price, float discountPercentage) {
            int newPrice;
            if(discountPercentage > 100.0f) {
                return 0;
            }
            else {
                newPrice = (int)((float)price * (discountPercentage /100 ));
                return newPrice;
            }
        }
}
