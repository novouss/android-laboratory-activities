package com.example.firstapplication.lib;

import java.util.HashMap;

public class Database {

    private final HashMap<String, Account> database = new HashMap<>();

    public Database() {
        Account acc = new Account();
        acc.setUsername("admin");
        acc.setPassword("admin");
        acc.setFirstname("Raymond");
        acc.setLastname("Gorospe");

        database.put(acc.getUsername(), acc);
    }

    public void addAccount(Account acc) {
        database.put(acc.getUsername(), acc);
    }

    public boolean checkAccount(String username, String password) {
        Account account = getAccount(username);
        return account != null && account.getPassword().equals(password);
    }

    public Account getAccount(String username) {
        return (Account) database.get(username);
    }
}
