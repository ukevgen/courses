package com.courses.spalah;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 * @author Ievgen Tararaka
 */
public class Starter {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);

        WebAppContext webapp = new WebAppContext();
        webapp.setContextPath("/");
        webapp.setWar("/topic25-1.0-SNAPSHOT.war");

        server.setHandler(webapp);

        server.start();
        server.join();
    }
}
