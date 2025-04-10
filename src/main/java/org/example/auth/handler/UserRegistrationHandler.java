package org.example.auth.handler;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.example.auth.service.UserRegistrationService;

import java.io.IOException;

public class UserRegistrationHandler implements HttpHandler {

    private final UserRegistrationService userRegistrationService;

    public UserRegistrationHandler(UserRegistrationService userRegistrationService) {
        this.userRegistrationService = userRegistrationService;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {

    }
}

