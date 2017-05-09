package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ListenerStats implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("---- Anwendungsstart in die Logdatei schreiben");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("---- Anwendung wird heruntergefaren. Die Zeit in die Logdatei schreiben");
    }

}
