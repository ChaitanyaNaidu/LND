package com.revolut.data.store;

import com.revolut.rest.web.*;

import java.util.*;

public class TransactionLog {
    private static final TransactionLog transactionLog=new TransactionLog();
    private List<InitiateTransferResponse> tranfers=new ArrayList();
    public static TransactionLog geInstance(){
        return transactionLog;
    }

    public void log(InitiateTransferResponse initiateTransferResponse){
        tranfers.add(initiateTransferResponse);
    }
    public List<InitiateTransferResponse> getTransfers(){
        return tranfers;
    }
}
