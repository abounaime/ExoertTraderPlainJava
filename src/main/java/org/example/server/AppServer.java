package org.example.server;

import java.util.logging.Logger;

public class AppServer {
    private final static Logger logger = Logger.getLogger(AppServer.class.toString());

    public static void main(String[] args){
        HttpServerInterface server = new AppHttpServer();
        try {
            server.start();
        }
        catch (Exception e){
            logger.severe("Fail to start server: " + e.getMessage());
            e.printStackTrace();
        }
        logger.info("Server Started");
    }
}