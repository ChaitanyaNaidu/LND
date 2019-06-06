package com.revolut.rest.web;

import com.google.gson.annotations.*;

public class InitiateTransferRequest {

    @SerializedName("from")
    private String fromAccountNumber;
    @SerializedName("to")
    private String toAccountNumber;
    @SerializedName("amount")
    private Double amount;
    @SerializedName("client_reference_id")
    private String clientReferenceId;
    @SerializedName("payment_reference")
    private String paymentReference;
    @SerializedName("purpose_of_transaction")
    private String purposeOfTransaction;

    public String getPaymentReference() {
        return paymentReference;
    }

    public void setPaymentReference(String paymentReference) {
        this.paymentReference = paymentReference;
    }

    public String getPurposeOfTransaction() {
        return purposeOfTransaction;
    }

    public void setPurposeOfTransaction(String purposeOfTransaction) {
        this.purposeOfTransaction = purposeOfTransaction;
    }

    public String getFromAccountNumber() {
        return fromAccountNumber;
    }

    public void setFromAccountNumber(String fromAccountNumber) {
        this.fromAccountNumber = fromAccountNumber;
    }

    public String getToAccountNumber() {
        return toAccountNumber;
    }

    public void setToAccountNumber(String toAccountNumber) {
        this.toAccountNumber = toAccountNumber;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getClientReferenceId() {
        return clientReferenceId;
    }

    public void setClientReferenceId(String clientReferenceId) {
        this.clientReferenceId = clientReferenceId;
    }
}
