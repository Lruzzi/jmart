package GhulamJmartAK;

import java.util.regex.*;

/**
 * This is Account Class
 * @ghulamif8
 * @abrahamkristanto
 */

public class Account extends Recognizable implements FileParser
{
    // instance variables - replace the example below with your own
    public static final String REGEX_EMAIL = "^\\w+([.&`~-]?\\w+)*@\\w+([.-]?\\w+)+$";
    public static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d][^-\\s]{8,}$";
    public String name;
    public String email;
    public String password;

    public Account(int id, String name, String email, String password)
    {
        super(id);
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public boolean read(String content) {
        return false;
    }

    public boolean validate() {
        Pattern email_Pattern = Pattern.compile(REGEX_EMAIL);
        Matcher email_Matcher = email_Pattern.matcher(email);
        
        Pattern password_Pattern = Pattern.compile(REGEX_PASSWORD);
        Matcher password_Matcher = password_Pattern.matcher(password);
        
        if(email_Matcher.find() == true && password_Matcher.find() == true) {
            return true;
        }
        else {
            return false;
        }
    }
}
