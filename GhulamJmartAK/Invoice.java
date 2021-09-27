package GhulamJmartAK;


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

    public String date;
    public int buyreId, productId, complaintId;
    public Rating rating;
    public Status status;

    protected Invoice(int id, int buyerId, int productId) {
        super(id);
        this.buyreId = buyerId;
        this.productId = productId;
        date = "27 September 2021";
        rating = Rating.NONE;
        status = Status.WAITING_CONFIRMATION;
    }

    public boolean read(String content) {
        return false;
    }

    public abstract double getTotalPay();
}
