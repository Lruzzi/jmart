package com.GhulamJmartAK;
import java.util.ArrayList;
import java.util.Date;
/**
 * Class untuk data pembayaran
 *
 * @author Ghulam Izzul FUad
 */
public class Payment extends Invoice
{
    public Shipment shipment;
    public int productCount;
    public ArrayList<Record> history = new ArrayList<Record>();

    public Payment(int buyerId, int productId, int productCount, Shipment shipment){
        super(buyerId, productId);
        this.shipment = shipment;
        this.productCount = productCount;
    }

    @Override
    public double getTotalPay(Product product) {
        return (product.price*this.productCount)*(1 - product.discount/100);
    }

    public  static class Record {
        public final Date date;
        public String massage;
        public Status status;


        public Record( Status status, String massage) {
            this.date = java.util.Calendar.getInstance().getTime();
            this.status = status;
            this.massage = massage;
        }

    }
}
