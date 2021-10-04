package GhulamJmartAK;


import java.util.ArrayList;
import java.util.Date;
/**
 * Write a description of class Invoice here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Invoice extends Recognizable implements FileParser
{
    public enum Status{
        WAITING_CONFIRMATION,
        CANCELLED,
        ON_PROGRES,
        ON_DELIVERY,
        COMPLAYINT,
        FINISHED,
        FAILED
    }

    public enum Rating{
        NONE,
        BAD,
        NEUTRAL,
        GOOD
    }

    public class Record
    {
        public Status status;
        public Date date;
        public String message; 
    }

    public Date date;
    public int buyreId, productId, complaintId;
    public Rating rating;
    public Status status;
    public ArrayList<Record> history = new ArrayList<Record>();;

    protected Invoice(int id, int buyerId, int productId) {
        super(id);
        this.buyreId = buyerId;
        this.productId = productId;
        date = new Date();
        rating = Rating.NONE;
        status = Status.WAITING_CONFIRMATION;
    }

    public boolean read(String content) {
        return false;
    }

    public abstract double getTotalPay();
}
