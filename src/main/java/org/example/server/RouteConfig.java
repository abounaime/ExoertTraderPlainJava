package org.example.server;

import com.sun.net.httpserver.HttpServer;
import org.example.auth.handler.UserRegistrationHandler;
import org.example.auth.service.UserRegistrationServiceImp;

public class RouteConfig {

    public static void registerRoutes(HttpServer httpServer){
        httpServer.createContext("/api/auth/register",
                new UserRegistrationHandler(new UserRegistrationServiceImp()));
    }
}
