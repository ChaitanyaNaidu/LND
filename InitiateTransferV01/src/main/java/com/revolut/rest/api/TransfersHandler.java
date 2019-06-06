package com.revolut.rest.api;

import com.google.gson.*;
import com.revolut.*;
import com.revolut.data.store.*;
import com.revolut.rest.web.*;
import com.revolut.transfer.*;

import javax.ws.rs.*;

@Path(Constants.CUSTOMERS)
public class TransfersHandler {

    private Gson gson=new Gson();

    @POST
    @Path(Constants.TRANSFERS)
    @Consumes(Constants.APPLICATION_JSON)
    @Produces(Constants.APPLICATION_JSON)
    public String initiateTransfer(/*@Context Request request,*/ String json, @PathParam("id") String customerId){
        InitiateTransferRequest initiateTransferRequest=gson.fromJson(json, InitiateTransferRequest.class);
        System.out.println("[Request="+json+"]");
        Transfers transfers=new TransfersImpl();
        try{
            Integer id=transfers.initiateTransfers(initiateTransferRequest);
            InitiateTransferResponse initiateTransferResponse=gson.fromJson(json, InitiateTransferResponse.class);
            initiateTransferResponse.setId(id.toString());
            TransactionLog.geInstance().log(initiateTransferResponse);
            return gson.toJson(initiateTransferResponse);
        }catch (TransferException exception) {
            return gson.toJson(new ErrorResponse(exception.getCode(),exception.getDescription()));
        }
    }
    @GET
    @Path(Constants.TRANSFERS)
    @Produces(Constants.APPLICATION_JSON)
    public String getTransfers(@PathParam("id") String customerId){
        return gson.toJson(TransactionLog.geInstance().getTransfers());
    }
}
