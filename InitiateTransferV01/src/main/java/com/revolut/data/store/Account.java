package com.revolut.data.store;

import com.google.gson.annotations.*;

public class Account {
    @SerializedName("account_number")
    private String accountNumber;
    @SerializedName("customer_id")
    private String customerId;
    @SerializedName("account_type")
    private String accountType;
    @SerializedName("available_amount")
    private Double availableAmount;
    @SerializedName("currency_code")
    private String currencyCode;

    public Account(String accountNumber, String customerId, String accountType, Double availableAmount,String currencyCode){
        this.accountNumber=accountNumber;
        this.customerId=customerId;
        this.accountType=accountType;
        this.availableAmount=availableAmount;
        this.currencyCode=currencyCode;
    }
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getAccountType() {
        return accountType;
    }

    public Double getAvailableAmount() {
        return availableAmount;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }
    public void credit(double amount){
        this.availableAmount=this.availableAmount+amount;
    }
    public void debit(double amount){
        this.availableAmount=this.availableAmount-amount;
    }
}
