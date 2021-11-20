package com.GhulamJmartAK;

import com.GhulamJmartAK.dbjson.JsonTable;
import com.google.gson.Gson;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * Write a description of class Jmart here.
 *
 * @author (Ghulam)
 * @version (9/11/2021)
 */
@SpringBootApplication
public class Jmart
{
    public static long DELIVERED_LIMIT_MS = 100;
    public static long ON_DELIVERY_LIMIT_MS = 100;
    public static long ON_PROGRESS_LIMIT_MS = 100;
    public static long WAITING_CONF_LIMIT_MS = 100;


    public static void main (String[] args)
    {
        SpringApplication.run(Jmart.class,args);
        try {
            JsonTable<Payment> table = new JsonTable<>(Payment.class,"C:/Users/Raihan Wijaya/Documents/Kuliah Universitas Indonesia/Tugas Kuliah/Semester 3/Praktikum OOP/Tugas/Case Study/jmart/randomPaymentList.json");
            ObjectPoolThread<Payment> paymentPool = new ObjectPoolThread<Payment>("Thread-PP", Jmart::paymentTimekeeper);

            paymentPool.start();
            table.forEach(payment -> paymentPool.add((Payment) payment));
            while (paymentPool.size() != 0);
            paymentPool.exit();
            while (paymentPool.isAlive());

            System.out.println("Thread exit successfully");
            Gson gson = new Gson();
            table.forEach(payment -> {
                String history = gson.toJson(payment);
                System.out.println(history);
            });
        }
        catch (Throwable t) {
            t.printStackTrace();
        }
    }

    public static boolean paymentTimekeeper(Payment payment) {
        long startTime = System.currentTimeMillis();
        if(payment.history.equals(Invoice.Status.WAITING_CONFIRMATION) && System.currentTimeMillis() - startTime > WAITING_CONF_LIMIT_MS) {
            payment.history.add(new Payment.Record(Invoice.Status.FAILED, "FAILED"));
        }
        else if(payment.history.equals(Invoice.Status.ON_PROGRESS) && System.currentTimeMillis() - startTime > ON_PROGRESS_LIMIT_MS) {
            payment.history.add(new Payment.Record(Invoice.Status.FAILED, "FAILED"));
        }
        else if(payment.history.equals(Invoice.Status.ON_DELIVERY) && System.currentTimeMillis() - startTime > ON_DELIVERY_LIMIT_MS) {
            payment.history.add(new Payment.Record(Invoice.Status.ON_DELIVERY, "ON_DELIVERY"));
            return true;
        }
        else if(payment.history.equals(Invoice.Status.FINISHED) && System.currentTimeMillis() - startTime > DELIVERED_LIMIT_MS) {
            payment.history.add(new Payment.Record(Invoice.Status.FINISHED, "DELIVERED"));
            return true;
        }
        return false;
    }
}