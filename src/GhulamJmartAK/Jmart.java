package GhulamJmartAK;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a description of class Jmart here.
 *
 * @author (Ghulam)
 * @version (9/11/2021)
 */

public class Jmart
{
    public static List<Product> filterByCategory (List<Product>list, ProductCategory category){
        return null;
    }

    public static List<Product> filterByPrice (List<Product>list, double minPrice, double maxPrice) {
        List<Product> temp = new ArrayList<Product>();
        for (Product product : list) {
            if (minPrice != 0.0 && product.price < minPrice) {
                continue;
            }
            if (maxPrice != 0.0 && product.price > maxPrice){
                continue;
            }
            temp.add(product);
        }
        return temp;
    }

    public static void main (String[] args)
    {
        System.out.println("account id" + new Account(null, null, null, -1).id);
        System.out.println("account id" + new Account(null, null, null, -1).id);
        System.out.println("account id" + new Account(null, null, null, -1).id);

        System.out.println("payment id" + new Payment(-1, -1, -1, null).id);
        System.out.println("payment id" + new Payment(-1, -1, -1, null).id);
        System.out.println("payment id" + new Payment(-1, -1, -1, null).id);
    }


}
