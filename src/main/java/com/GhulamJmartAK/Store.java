package com.GhulamJmartAK;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class untuk data toko setiap akun
 *
 * @author Ghulam Izzul Fuad
 */
public class Store
{
    public static final String REGEX_PHONE = "^(\\d{9,12})$";
    public static final String REGEX_NAME = "^(?=^[A-Z])(?![A-Z a-z]{20,})((?=[A-Z a-z]{4,}).)((?!\\s{2}).)*$";
    public String name;
    public String address;
    public String phoneNumber;
    public double balance;

    public Store(String name, String address, String phoneNumber, double balance) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
    }

    public String toString(){
        return "name: " + (String)this.name + "\n" + "address: " + (String)this.address + "\n" + "Phone Number" + (String)this.phoneNumber;
    }

    public boolean validate(){
        Pattern formatNum = Pattern.compile(REGEX_PHONE);
        Matcher cekPhone = formatNum.matcher(phoneNumber);
        boolean matchPhone = cekPhone.find();

        Pattern formatName = Pattern.compile(REGEX_NAME);
        Matcher cekName = formatName.matcher(name);
        boolean matchName = cekName.find();

        if(matchName == true && matchPhone == true) {
            return true;
        }
        else {
            return false;
        }
    }
}