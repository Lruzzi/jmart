package GhulamJmartAK;


/**
 * Write a description of class Complaint here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Complaint extends Recognizable implements FileParser
{
    // instance variables - replace the example below with your own
    public String date;
    public String desc;
    
    public Complaint(int id, String desc) {
        super(id);
        this.desc = desc;
        date = "27 September 2021";
    }

    @Override
    public boolean read(String content) {
        return false;
    }
}
