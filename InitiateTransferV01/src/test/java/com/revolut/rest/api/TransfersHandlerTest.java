package com.revolut.rest.api;

import com.google.gson.*;
import com.revolut.*;
import com.revolut.rest.web.*;
import com.revolut.transfer.*;
import org.junit.*;
import org.junit.runner.*;
import org.powermock.core.classloader.annotations.*;
import org.powermock.modules.junit4.*;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest({TransfersHandler.class})
public class TransfersHandlerTest {

    @Test
    public void initiateTransfer() throws Exception {
        TransfersHandler transfersHandler=new TransfersHandler();
        String jsonRequest="{\n" +
                "\t\"from\": \"020119945\",\n" +
                "\t\"to\":\"020119944\",\n" +
                "\t\"amount\":1000.0,\n" +
                "\t\"payment_reference\": \"investment\",\n" +
                "\t\"purpose_of_transaction\": \"investment\"\n" +
                "}";

        TransfersImpl transfers=mock(TransfersImpl.class);
        whenNew(TransfersImpl.class).withNoArguments().thenReturn(transfers);
        when(transfers.initiateTransfers(any(InitiateTransferRequest.class))).thenReturn(new Integer("1234"));
        String jsonResponse=transfersHandler.initiateTransfer(jsonRequest,"123456");
        assertNotNull(jsonResponse);
        Gson gson=new Gson();
        InitiateTransferResponse initiateTransferResponse=gson.fromJson(jsonResponse,InitiateTransferResponse.class);
        assertEquals("1234",initiateTransferResponse.getId());
    }
    @Test
    public void initiateTransfer_ErrorResponse() throws Exception {
        TransfersHandler transfersHandler=new TransfersHandler();
        String jsonRequest="{\n" +
                "\t\"from\": \"020119950\",\n" +
                "\t\"to\":\"020119944\",\n" +
                "\t\"amount\":1000.0,\n" +
                "\t\"payment_reference\": \"investment\",\n" +
                "\t\"purpose_of_transaction\": \"investment\"\n" +
                "}";

        TransfersImpl transfers=mock(TransfersImpl.class);
        whenNew(TransfersImpl.class).withNoArguments().thenReturn(transfers);
        when(transfers.initiateTransfers(any(InitiateTransferRequest.class))).thenThrow(new TransferException("1001","Account Not exists"));
        String jsonResponse=transfersHandler.initiateTransfer(jsonRequest,"123456");
        assertNotNull(jsonResponse);
        Gson gson=new Gson();
        ErrorResponse errorResponse=gson.fromJson(jsonResponse,ErrorResponse.class);
        assertEquals("1001",errorResponse.getCode());
    }

    @Test
    public void getTransfers() {
    }
}