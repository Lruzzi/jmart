package GhulamJmartAK;

import java.util.regex.*;/**
 * Write a description of class Store here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Store
{

    public String name, address, phoneNumber;
    public  static final String REGEX_NAME = "^(\\d{9,12})$";
    public  static final String REGEX_PHONE = "^[A-Z](?!(?:.*[ ]){2}).{3,19}$";

    public Store(int accountId, String name, String address, String phoneNumber){

        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Store(Account account, String name, String address, String phoneNumber){

        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String toString() {
        return "name :" + this.name + "\naddress :" + this.address +  "\nphone number :" + this.phoneNumber;
    }

    public boolean validate() {
        Pattern patternPhone = Pattern.compile(REGEX_PHONE);
        Matcher matcherPhone = patternPhone.matcher(phoneNumber);
        boolean matchPhone = matcherPhone.find();
        boolean hasilPhone = matchPhone ? true : false;

        Pattern patternName = Pattern.compile(REGEX_NAME);
        Matcher matcherName = patternName.matcher(name);
        boolean matchName = matcherName.find();
        boolean hasilName = matchName ? true : false;

        if (hasilPhone == true && hasilName == true){
            return true;
        }
        else
            return false;
    }
}