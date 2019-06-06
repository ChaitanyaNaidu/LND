package com.revolut.transfer;

import com.revolut.*;
import com.revolut.data.store.*;
import com.revolut.rest.web.*;

import java.util.*;

public class TransfersImpl implements Transfers{

    public Integer initiateTransfers(InitiateTransferRequest initiateTransferRequest)throws TransferException {
        Map<String,Account> accounts=DataStore.getInstance().getAccounts();
        System.out.println("#######");
        if(accounts.containsKey(initiateTransferRequest.getFromAccountNumber()) && accounts.containsKey(initiateTransferRequest.getToAccountNumber())){
            Account sourceAccount=accounts.get(initiateTransferRequest.getFromAccountNumber());
            synchronized (sourceAccount) {
                if (sourceAccount.getAvailableAmount().doubleValue() >= initiateTransferRequest.getAmount().doubleValue()) {
                    Account targetAccount = accounts.get(initiateTransferRequest.getToAccountNumber());
                    sourceAccount.debit(initiateTransferRequest.getAmount());
                    targetAccount.credit(initiateTransferRequest.getAmount());
                    Random random=new Random();
                    return random.nextInt(Integer.MAX_VALUE);
                } else {
                    throw new TransferException("1002", "Insufficient funds on source sourceAccount");
                }
            }
        }else {
            throw new TransferException("1001","Account Not exists");
        }
    }
}
