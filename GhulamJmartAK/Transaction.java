package GhulamJmartAK;


/**
 * Write a description of class Transaction here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Transaction extends Recognizable
{
    public String time;
    public int buyerId;
    public int storeId;
    public Rating rating;
    
    protected Transaction (int id, int buyerId, int storeId) {
        super(id);
        this.buyerId = buyerId;
        this.storeId = storeId;
    }
    
    public enum Rating {
        NONE,
        BAD,
        NEUTRAL,
        GOOD
    }
}
