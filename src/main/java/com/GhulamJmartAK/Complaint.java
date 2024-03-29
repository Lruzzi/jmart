package com.GhulamJmartAK;

import com.GhulamJmartAK.dbjson.Serializable;

import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Class yang berguna untuk data complaint
 *
 * @author Ghulam Izzul Fuad
 */
public class Complaint extends Serializable
{
    public Date date;
    public String desc;

    public Complaint(String desc){
        this.desc = desc;
        this.date = new Date();
    }

    public boolean validate(){
        return false;
    }

    public String toString(){
        SimpleDateFormat SDformat = new SimpleDateFormat("dd/MM/yyyy");
        String formatDate = SDformat.format(this.date);
        return "{date = " + formatDate + "desc = '" + this.desc + "'}";
    }
}
