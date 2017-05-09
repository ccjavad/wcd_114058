package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ListenerLogfile implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("-- Logdatei wird geöffnet");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("-- Logdatei wird geschlossen");
    }

}
