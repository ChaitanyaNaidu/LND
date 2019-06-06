package com.revolut.transfer;

import com.revolut.*;
import com.revolut.data.store.*;
import com.revolut.rest.web.*;
import org.junit.*;
import org.junit.runner.*;
import org.powermock.api.mockito.*;
import org.powermock.core.classloader.annotations.*;
import org.powermock.modules.junit4.*;

import java.util.*;

import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.when;
import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest({TransfersImpl.class, DataStore.class})
public class TransfersImplTest {

    @Test
    public void initiateTransfers() throws TransferException {
        InitiateTransferRequest initiateTransferRequest=new InitiateTransferRequest();
        initiateTransferRequest.setAmount(1000.0);
        initiateTransferRequest.setFromAccountNumber("020119944");
        initiateTransferRequest.setToAccountNumber("020119945");
        initiateTransferRequest.setPaymentReference("investment");
        initiateTransferRequest.setPurposeOfTransaction("investment");
        Map<String,Account> accounts=DataStore.getInstance().getAccounts();

        PowerMockito.mockStatic(DataStore.class);
        DataStore dataStoreMock=mock(DataStore.class);
        when(DataStore.getInstance()).thenReturn(dataStoreMock);

        when(dataStoreMock.getAccounts()).thenReturn(accounts);
        TransfersImpl transfers=new TransfersImpl();
        Integer id=transfers.initiateTransfers(initiateTransferRequest);
        assertNotNull(id);
    }
    @Test(expected = TransferException.class)
    public void initiateTransfers_accountNotExists() throws TransferException {
        InitiateTransferRequest initiateTransferRequest=new InitiateTransferRequest();
        initiateTransferRequest.setAmount(1000.0);
        initiateTransferRequest.setFromAccountNumber("020119950");
        initiateTransferRequest.setToAccountNumber("020119945");
        initiateTransferRequest.setPaymentReference("investment");
        initiateTransferRequest.setPurposeOfTransaction("investment");
        Map<String,Account> accounts=DataStore.getInstance().getAccounts();

        PowerMockito.mockStatic(DataStore.class);
        DataStore dataStoreMock=mock(DataStore.class);
        when(DataStore.getInstance()).thenReturn(dataStoreMock);

        when(dataStoreMock.getAccounts()).thenReturn(accounts);
        TransfersImpl transfers=new TransfersImpl();
        Integer id=transfers.initiateTransfers(initiateTransferRequest);
    }
    @Test(expected = TransferException.class)
    public void initiateTransfers_insufficientBalance() throws TransferException {
        InitiateTransferRequest initiateTransferRequest=new InitiateTransferRequest();
        initiateTransferRequest.setAmount(100000000.0);
        initiateTransferRequest.setFromAccountNumber("020119944");
        initiateTransferRequest.setToAccountNumber("020119945");
        initiateTransferRequest.setPaymentReference("investment");
        initiateTransferRequest.setPurposeOfTransaction("investment");
        Map<String,Account> accounts=DataStore.getInstance().getAccounts();

        PowerMockito.mockStatic(DataStore.class);
        DataStore dataStoreMock=mock(DataStore.class);
        when(DataStore.getInstance()).thenReturn(dataStoreMock);

        when(dataStoreMock.getAccounts()).thenReturn(accounts);
        TransfersImpl transfers=new TransfersImpl();
        Integer id=transfers.initiateTransfers(initiateTransferRequest);
    }

}