package GhulamJmartAK;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * Write a description of class Jmart here.
 *
 * @author (Ghulam)
 * @version (9/11/2021)
 */

public class Jmart
{
    class Country {
        public String name;
        public int population;
        public List<String> listOfStates;
    }

    public static void main (String[] args)
    {
        String filepath = "D:/Praktikum OOP/jmart/src/GhulamJmartAK/city.json";
        Gson gson = new Gson();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filepath));
            Country input = gson.fromJson(br, Country.class);
            System.out.println("name " + input.name);
            System.out.println("population: " + input.population);
            System.out.println("states:");
            input.listOfStates.forEach(state -> System.out.println(state));
        }

        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static Product createProduct()
    {
        return null;
    }

    public static Shipment createShipmentDuration(){
        return null;
    }

    public static Coupon createCoupun()
    {
        return null;
    }
}
