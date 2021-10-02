package GhulamJmartAK;

import java.util.Date;
import java.util.Calendar;

/**
 * Write a description of class Complaint here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Complaint extends Recognizable implements FileParser
{
    // instance variables - replace the example below with your own
    Calendar cal = Calendar.getInstance();
    Date date;
    public String desc;
    
    public Complaint(int id, String desc) {
        super(id);
        this.desc = desc;
        date = cal.getTime();
    }

    @Override
    public boolean read(String content) {
        return false;
    }
}
