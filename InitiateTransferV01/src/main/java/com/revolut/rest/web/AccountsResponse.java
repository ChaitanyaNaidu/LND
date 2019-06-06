package com.revolut.rest.web;

import com.revolut.data.store.*;

import java.util.*;

public class AccountsResponse {
    private List<Account> accounts;

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}
