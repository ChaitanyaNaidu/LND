package com.revolut.rest.server;

import com.revolut.rest.api.*;
import com.sun.net.httpserver.*;
import org.glassfish.jersey.jdkhttp.*;
import org.glassfish.jersey.server.*;

import javax.ws.rs.core.*;
import java.net.*;

public class TransferHandlerRestStartup {

    private final static int port = 9998;
    private final static String host = "http://localhost/";

    public static void main(String[] args) {
        URI baseUri = UriBuilder.fromUri(host).port(port).build();
        ResourceConfig config = new ResourceConfig(TransfersHandler.class);
        HttpServer server = JdkHttpServerFactory.createHttpServer(baseUri, config);
    }
}
