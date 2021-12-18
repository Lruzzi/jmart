package com.GhulamJmartAK;


/**
 * Class untuk mengatur rating product
 *
 * @author Ghulam Izzul Fuad
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
        if (this.count == 0) {
            return 0.0;
        }
        else {
            return (double)(total/count);
        }
    }
    
    public long getCount() {
        return count;
    }
    
    public long getTotal() {
        return total;
    }

}
