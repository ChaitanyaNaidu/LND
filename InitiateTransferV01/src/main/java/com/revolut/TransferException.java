package com.revolut;

public class TransferException extends Exception {
    private String code;
    private String description;

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public TransferException(String code, String description){
        this.code=code;
        this.description=description;
    }
}
