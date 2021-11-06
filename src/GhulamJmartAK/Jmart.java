package GhulamJmartAK;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
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
        List<Product> tempHasil = new ArrayList<Product>();

        for(Product temp : list){
            if(temp.category == category){
                tempHasil.add(temp);
            }
        }
        return tempHasil;
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

        String filepath = "D:/Praktikum OOP/jmart/src/GhulamJmartAK/randomProductList.json";
        try {
            List<Product> list = read(filepath);
            List<Product> filtered = filterByPrice(list, 13000.0, 15000.0);
            filtered.forEach(product -> System.out.println(product.price));
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    public static List<Product> read(String filepath) throws FileNotFoundException {
        Gson gson = new Gson();
        Type userListType = new TypeToken<ArrayList<Product>>() {
        }.getType();
        BufferedReader br = new BufferedReader(new FileReader(filepath));
        List<Product> returnList = gson.fromJson(br, userListType);
        return returnList;
    }


}
