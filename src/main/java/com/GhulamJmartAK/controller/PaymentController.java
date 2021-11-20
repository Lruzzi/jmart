package com.GhulamJmartAK.controller;

import com.GhulamJmartAK.ObjectPoolThread;
import com.GhulamJmartAK.Payment;
import com.GhulamJmartAK.dbjson.JsonTable;

public class PaymentController {
    public static final long DELIVERED_LIMIT_MS = 100;
    public static final long ON_DELIVERY_LIMIT_MS = 100;
    public static final long ON_PROGRES_LIMIT_MS = 100;
    public static final long WAITING_CONF_LIMIT_MS = 100;
    public static JsonTable<Payment> paymentTable;
    public static ObjectPoolThread<Payment> poolThread;


    public boolean accept (int id) {
        return true;
    }

    public boolean cancel (int id) {
        return false;
    }



}
