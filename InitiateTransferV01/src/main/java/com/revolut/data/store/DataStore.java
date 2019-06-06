package com.revolut.data.store;

import java.util.*;

public class DataStore {

    private static final DataStore dataStore=new DataStore();
    private Map<String,Account> accounts=new HashMap<String, Account>(5);
    public static DataStore getInstance(){
        return dataStore;
    }
    private DataStore(){
        setupAccounts();
    }
    private void setupAccounts(){
        Account savingsAccountOne=new Account("020119944", "2233441", "Savings", new Double("100000.00"),"GBP");
        Account currentAccountOne=new Account("020119945", "2233441", "Current", new Double("200000.00"),"GBP");
        Account savingsAccountTwo=new Account("020119946", "2233442", "Savings", new Double("120000.00"),"GBP");
        Account currentAccountTwo=new Account("020119947", "2233442", "Current", new Double("240000.00"),"GBP");
        accounts.put(savingsAccountOne.getAccountNumber(),savingsAccountOne);
        accounts.put(currentAccountOne.getAccountNumber(),currentAccountOne);
        accounts.put(savingsAccountTwo.getAccountNumber(),savingsAccountTwo);
        accounts.put(currentAccountTwo.getAccountNumber(),currentAccountTwo);
    }
    public Map<String,Account> getAccounts(){
        return accounts;
    }
}
