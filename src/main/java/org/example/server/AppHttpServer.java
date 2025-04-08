package org.example.server;

import com.sun.net.httpserver.HttpServer;
import org.example.config.AppConfig;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class AppHttpServer {
    private HttpServer server;

    public void start() throws IOException {
        server = HttpServer.create(new InetSocketAddress(AppConfig.PORT), AppConfig.BACKLOG);
        RouteConfig.registerRoutes(server);
        server.setExecutor(Executors.newFixedThreadPool(AppConfig.THREAD_POOL_SIZE));
        server.start();
    }
}
