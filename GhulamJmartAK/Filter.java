package GhulamJmartAK;

import java.util.ArrayList;

public class Filter {
    public static ArrayList<PriceTag> filterPriceTag(PriceTag[] list, double value, boolean less) {
        ArrayList<PriceTag> priceTags = new ArrayList<>();
        for (PriceTag e : list) {
            if (less && e.getAdjustedPrice() < value) {
                priceTags.add(e);
            }
        }
        return priceTags;
    }
}
