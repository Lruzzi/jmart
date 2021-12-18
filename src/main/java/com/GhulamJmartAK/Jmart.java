package com.GhulamJmartAK;

import com.GhulamJmartAK.dbjson.JsonDBEngine;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * Class Utama yang berisi semua class yang akan dijalankan
 *
 * @author (Ghulam Izzul Fuad)
 *
 */
@SpringBootApplication
public class Jmart
{


    public static void main (String[] args)
    {
        SpringApplication.run(Jmart.class,args);
        JsonDBEngine.Run(Jmart.class);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> JsonDBEngine.join()));

    }

}