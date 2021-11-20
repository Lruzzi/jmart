package com.GhulamJmartAK.controller;
import com.GhulamJmartAK.Account;
import com.GhulamJmartAK.Store;
import com.GhulamJmartAK.dbjson.JsonAutowired;
import com.GhulamJmartAK.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.regex.Pattern;

import static org.apache.logging.log4j.util.Strings.isBlank;

import java.util.regex.Pattern;

@RestController
@RequestMapping("/account")
public class AccountController implements BasicGetController<Account> {
    public static final String REGEX_EMAIL = "^\\w+([.&`~-]?\\w+)*@\\w+([.-]?\\w+)+$";
    public static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d][^-\\s]{8,}$";
    public static final Pattern REGEX_PATTERN_EMAIL = Pattern.compile(REGEX_EMAIL);
    public static final Pattern REGEX_PATTERN_PASSWORD = Pattern.compile(REGEX_PASSWORD);
    @JsonAutowired(filepath = "/json/something", value = Account.class)
    public static JsonTable<Account> accountTable;

    public JsonTable<Account> getJsonTable() {
        return accountTable;
    }

    @PostMapping("/login")
    Account login(String email, String password) {
        for (Account account : getJsonTable()) {
            if (account.email == email && account.password == password) {
                return account;
            }
        }
        return null;
    }

    @PostMapping("/register")
    Account register(String name, String email, String password) {
        if (name.isBlank()) {
            return null;
        } else if (REGEX_PATTERN_EMAIL.matcher(email).matches()) {
            return null;
        } else if (REGEX_PATTERN_PASSWORD.matcher(password).matches()) {
            return null;
        }
        for (Account account : accountTable) {
            if (account.email == email) {
                return null;
            }
        }
        Account account = new Account(name, email, password, 0.0);
        accountTable.add(account);
        return account;
    }

    @PostMapping("/(id)/registerStore")
    Store registerStore(int id, String name, String address, String phoneNumber){
        for (Account account : accountTable){
            if(account.id == id && account.store == null){
                Store store = new Store(0,name, address, phoneNumber);
                account.store = store;
                return store;
            }
        }
        return null;
    }

    @PostMapping("/(id)/topUp")
    boolean topUp(int id, double balance) {
        for (Account account : accountTable) {
            if (account.id == id) {
                account.balance += balance;
                return true;
            }
        }
        return false;
    }
}