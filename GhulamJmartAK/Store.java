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
    public static final String REGEX_NAME = "^[A-Z](?!(?:.*[ ]){2})(?!.(\s)\1).{3,19}$";
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
        Pattern phoneNumber_Pattern = Pattern.compile(REGEX_PHONE);
        Matcher phoneNumber_Matcher = phoneNumber_Pattern.matcher(phoneNumber);
        
        Pattern name_Pattern = Pattern.compile(REGEX_NAME);
        Matcher name_Matcher = name_Pattern.matcher(name);
        
        if(phoneNumber_Matcher.find() == true && name_Matcher.find() == true) {
            return true;
        }
        else {
            return false;
        }
    }
}
