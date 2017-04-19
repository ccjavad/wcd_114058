package gb.web;

import java.util.LinkedHashSet;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class InitApp implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        
        ServletContext context = sce.getServletContext();
        
        context.setAttribute("guestbookEntries", new LinkedHashSet<>());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }

}
