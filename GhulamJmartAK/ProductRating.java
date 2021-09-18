package GhulamJmartAK;


/**
 * Write a description of class ProductRating here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ProductRating
{
    public long total;
    public long count;
    


    /**
     * Constructor for objects of class ProductRating
     */
    public ProductRating()
    {
        this.total = 0;
        this.count = 0;
    }


    public void insert (int rating) {
        this.total = rating;
        count++;
    }
    
    public double getAverage() {
        if (count == 0) {
            return 0;
        }
        else {
            return total/count;
        }
    }
    
    public long getCount() {
        return count;
    }
    
    public long getTotal() {
        return total;
    }

}
