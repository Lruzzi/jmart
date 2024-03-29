package com.GhulamJmartAK;
import com.GhulamJmartAK.dbjson.Serializable;

import java.util.Date;

/**
 * Class untuk data Invoice pembelian product
 *
 * @author Ghulam Izzul Fuad
 */
public abstract class Invoice extends Serializable
{
    public int buyerId;
    public int productId;
    public int complaintId;
    public Rating rating;
    public final Date date;

    protected Invoice(int buyerId, int productId) {
        this.buyerId = buyerId;
        this.productId = productId;
        date = java.util.Calendar.getInstance().getTime();
        this.complaintId = -1;
        this.rating = Rating.NONE;
    }

    public enum Status {
        WAITING_CONFIRMATION,
        CANCELLED,
        ON_PROGRESS,
        ON_DELIVERY,
        COMPLAINT,
        FINISHED,
        FAILED
    }

    public enum Rating {
        NONE,
        BAD,
        NEUTRAL,
        GOOD
    }

    public abstract double getTotalPay(Product product);
}
