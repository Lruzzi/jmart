package GhulamJmartAK;


/**
 * Write a description of class Product here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Product
{
    // instance variables - replace the example below with your own
    private static int idCounter = 0;
    public int id;
    public String name;
    public int weight;
    public boolean conditionUsed;
    public PriceTag priceTag;
    public ProductCategory category;
    public ProductRating rating;

    public Product(String name, int weight, boolean conditionUsed, PriceTag pricetag,ProductCategory category) {
        this.id = idCounter++;
        this.name = name;
        this.weight = weight;
        this.conditionUsed = conditionUsed;
        this.priceTag = pricetag;
        this.category = category;
        this.rating = new ProductRating();
    }
}
