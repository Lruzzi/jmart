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
    private int idCounter;
    public int id;
    public String name;
    public int weight;
    public boolean conditionUsed;
    PriceTag pricetag;
    public ProductCategory category;
    public ProductRating rating;

    public Product(String name, int weight, boolean conditionUsed, PriceTag pricetag,ProductCategory category) {
        this.name = name;
        this.weight = weight;
        this.conditionUsed = conditionUsed;
        this.pricetag = pricetag;
    }
}
