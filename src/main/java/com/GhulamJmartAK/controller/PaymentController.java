package com.GhulamJmartAK.controller;

import com.GhulamJmartAK.Account;
import com.GhulamJmartAK.ObjectPoolThread;
import com.GhulamJmartAK.Payment;
import com.GhulamJmartAK.dbjson.JsonAutowired;
import com.GhulamJmartAK.dbjson.JsonTable;
import org.springframework.web.bind.annotation.PostMapping;

public class PaymentController implements BasicGetController<Payment>
{
    public static final long DELIVERED_LIMIT_MS = 1;
    public static final long ON_DELIVERY_LIMIT_MS = 1;
    public static final long ON_PROGRESS_LIMIT_MS = 1;
    public static final long WAITING_CONF_LIMIT_MS = 1;

    @JsonAutowired(filepath = "/json/payment.json", value = Payment.class)
    public static JsonTable<Payment> paymentTable;
    //public static ObjectPoolThread<Payment> poolThread = new ObjectPoolThread<Payment>("Thread-PP", PaymentController::timekeeper);

    @PostMapping("/{id}/accept")
    boolean accept(int id){
        return false;
    }
    @PostMapping("/{id}/cancel")
    boolean cancel(int id){
        return false;
    }
    @PostMapping("/create")
    Payment create(int buyerId, int productId, int productCount, String shipmentAddress){
        return null;
    }

    //public JsonTable<Account>

    boolean submit(int id, String receipt){
        return false;
    }


    @Override
    public JsonTable<Payment> getJsonTable() {
        return null;
    }
}
