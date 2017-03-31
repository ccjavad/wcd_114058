package listener;

import java.util.Date;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class HochfahrenRunterfahrenListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Date date = new Date();
        ServletContext context = sce.getServletContext();
        context.setAttribute("app-start-date", date);
        System.out.println("Die Anwendung startet: " + date);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Die Anwendung wird beendet: " + new Date());
    }

}
