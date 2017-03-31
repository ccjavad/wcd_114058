package userlist.web;

import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class InitApp implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        context.setAttribute("listUser", new ArrayList<>());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }

}
