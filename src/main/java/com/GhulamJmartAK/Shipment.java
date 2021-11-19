package com.GhulamJmartAK;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

/**
 * Write a description of class Shipment here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Shipment
{
    public String address;
    public int shipmentCost;
    public Duration duration;
    public String receipt;


    public static class Duration
    {
        public static SimpleDateFormat ESTIMATION_FORMAT = new SimpleDateFormat("E MMMM dd yyyy");
        public static final Duration INSTANT = new Duration ((byte) (1 << 0));
        public static final Duration SAME_DAY = new Duration ((byte) (1 << 1));
        public static final Duration NEXT_DAY = new Duration ((byte) (1 << 2));
        public static final Duration REGULAR = new Duration ((byte) (1 << 3));
        public static final Duration KARGO = new Duration ((byte) (1 << 4));
        private byte bit;

        public Duration(byte bit)
        {
            this.bit = bit;
        }

        public String getEstimatedArrival(Date reference){
            Calendar temp = Calendar.getInstance();
            if(this.bit == 1<<0|| this.bit == 1<<1){
                return ESTIMATION_FORMAT.format(reference.getTime());
            }else if(this.bit == 1<<2){
                temp.setTime(reference);
                temp.add(Calendar.DATE,1);
                return ESTIMATION_FORMAT.format(temp);
            }else if(this.bit == 1<<3){
                temp.setTime(reference);
                temp.add(Calendar.DATE,2);
                return ESTIMATION_FORMAT.format(temp);
            }else{
                temp.setTime(reference);
                temp.add(Calendar.DATE,5);
                return ESTIMATION_FORMAT.format(temp);
            }
        }
    }

    public class MultiDuration {
        public byte bit;

        public MultiDuration(Duration... args) {
            for(Duration i:args) {
                this.bit = (byte) (bit|i.bit);
            };
        }
        
        public boolean isDuration (Duration reference) {
            if((reference.bit & this.bit) != 0) {
                return true;
            }
            else {
                return false;
            }
        }
    }

    public boolean read(String content) {
        return false;
    }

    public Shipment(String address, int shipmentCost, Duration duration, String receipt) {
        this.address = address;
        this.shipmentCost = shipmentCost;
        this.duration = duration;
        this.receipt = receipt;
    }
}
