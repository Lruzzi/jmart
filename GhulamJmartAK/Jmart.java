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
    
    public static Product create() {
        return new Product("Keyboard gaming",250,false,new PriceTag(450000.0),ProductCategory.GAMING);
    }
}
