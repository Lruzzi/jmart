package GhulamJmartAK;

import java.util.regex.*;/**
 * Write a description of class Store here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Store extends Recognizable implements FileParser
{
    public static final String REGEX_PHONE = "^(\\d{9,12]}$";
    public static final String REGEX_NAME = "^[A-Z].[a-z](?!.(\\s)\1).{4,20}$";
    public String name;
    public String address;
    public String phoneNumber;


    public Store(int accountId,String name, String address, String phoneNumber)
    {
        // initialise instance variables
        super(accountId);
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
    
    public Store(Account account, String name,String address,String phoneNumber) {
        super(account.id);
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
    
    public boolean read (String content) {
        return false;
    }

    public String toString(){
        return "name" + this.name + this.address + this.phoneNumber;
    }

    public boolean validate() {
        if(String.valueOf(REGEX_NAME).length() >= 9 && String.valueOf(REGEX_NAME).length() <=12 && String.valueOf(REGEX_PHONE).length() >= 4 && String.valueOf(REGEX_PHONE).length() <=20) {
            return true;
        }

        else {
            return false;
        }
    }
}
