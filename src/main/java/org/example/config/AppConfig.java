package org.example.config;

public class AppConfig {
    public static final int PORT = Integer.parseInt(System.getenv()
            .getOrDefault("EXPERT_TRADER_JAVA_PORT", "8080"));
    public static final int BACKLOG = Integer.parseInt(System.getenv()
            .getOrDefault("BACKLOG", "50"));
    public static final int THREAD_POOL_SIZE = Integer.parseInt(System.getenv()
            .getOrDefault("THREAD_POOL_SIZE", "10"));

}
