import org.mortbay.jetty.Server;
import org.mortbay.jetty.webapp.WebAppContext;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.security.ProtectionDomain;

public class Start {

    private static int DEFAULT_PORT = Integer.getInteger("port", 8080);

    public static void main(String[] args) throws Exception {

        Server server = new Server(Integer.getInteger("port", DEFAULT_PORT));
        WebAppContext appContext = new WebAppContext();
        appContext.setServer(server);
        appContext.setContextPath("/");
        appContext.setExtractWAR(false);
        ProtectionDomain protectionDomain = Start.class.getProtectionDomain();
        URL location = protectionDomain.getCodeSource().getLocation();
        appContext.setWar(location.toExternalForm());
        server.setHandler(appContext);

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
