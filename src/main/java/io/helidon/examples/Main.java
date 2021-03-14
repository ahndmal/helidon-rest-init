package io.helidon.examples;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.LogManager;

import io.helidon.microprofile.server.Server;

public final class Main {

   Main() {}

    public static void main(final String[] args) throws IOException {
        // load logging configuration
        setupLogging();

        // start the server
        Server server = startServer();

        System.out.println("http://localhost:" + server.port() + "/greet");
    }

     static Server startServer() {
        // Server will automatically pick up configuration from
        // microprofile-config.properties
        // and Application classes annotated as @ApplicationScoped
        return Server.create().start();
    }

    /**
     * Configure logging from logging.properties file.
     */
    private static void setupLogging() throws IOException {
        try (InputStream is = Main.class.getResourceAsStream("/logging.properties")) {
            LogManager.getLogManager().readConfiguration(is);
        }
    }
}
