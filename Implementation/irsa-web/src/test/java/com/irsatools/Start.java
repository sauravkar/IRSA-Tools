/**
 *  File: Dictionary
 *  Author: Nikolay Semenov <ns.semenov@gmail.com>
 *  Date: 30.04.12
 */
package com.irsatools;

import org.apache.log4j.xml.DOMConfigurator;
import org.apache.wicket.util.time.Duration;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.bio.SocketConnector;
import org.eclipse.jetty.webapp.WebAppContext;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Launcher class to start embedded jetty server from IDE
 * Used for DEVELOPMENT purpose
 */
public class Start {

    private static final int DEFAULT_PORT = 8081;

    public static void main(String[] args) throws Exception {
        int timeout = (int) Duration.ONE_HOUR.getMilliseconds();

        Server server = new Server();
        SocketConnector connector = new SocketConnector();

        // Set some timeout options to make debugging easier.
        connector.setMaxIdleTime(timeout);
        connector.setSoLingerTime(-1);
        connector.setPort(DEFAULT_PORT);
        server.addConnector(connector);

        WebAppContext bb = new WebAppContext();
        bb.setServer(server);
        bb.setContextPath("/");
        bb.setWar("src/main/webapp");
        // Setup development environment
        bb.setDescriptor("src/test/resources/dev-web.xml");
        DOMConfigurator.configure("src/test/resources/dev-log4j.xml");

        // START JMX SERVER
        // MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        // MBeanContainer mBeanContainer = new MBeanContainer(mBeanServer);
        // server.getContainer().addEventListener(mBeanContainer);
        // mBeanContainer.start();

        server.setHandler(bb);

        try {
            System.out.println(">>> STARTING EMBEDDED JETTY SERVER, PRESS ANY KEY TO STOP");
            server.start();
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            in.readLine();
            // *************************************
            if (!java.awt.Desktop.isDesktopSupported()) {

                System.err.println("Desktop is not supported (fatal)");
                System.exit(1);
            }
            java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
            try {
                System.out.println(">>> OPENING URL: http://localhost:" + DEFAULT_PORT);
                java.net.URI uri = new java.net.URI("http://localhost:" + DEFAULT_PORT);
                desktop.browse(uri);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
            // *************************************
            in.readLine();
            System.out.println(">>> STOPPING EMBEDDED JETTY SERVER");
            server.stop();
            server.join();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
