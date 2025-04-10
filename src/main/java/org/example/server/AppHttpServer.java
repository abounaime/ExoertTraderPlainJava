package org.example.server;

import com.sun.net.httpserver.HttpServer;
import org.example.config.AppConfig;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class AppHttpServer implements HttpServerInterface {
    @Override
    public void start() throws IOException {
        var httpServer = HttpServer.create(new InetSocketAddress(AppConfig.PORT), AppConfig.BACKLOG);
        RouteConfig.registerRoutes(httpServer);
        httpServer.setExecutor(Executors.newFixedThreadPool(AppConfig.THREAD_POOL_SIZE));
        httpServer.start();
    }
}
