package com.GhulamJmartAK;

import com.GhulamJmartAK.dbjson.JsonDBEngine;
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


    public static void main (String[] args)
    {
        SpringApplication.run(Jmart.class,args);
        JsonDBEngine.Run(Jmart.class);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> JsonDBEngine.join()));

    }

}