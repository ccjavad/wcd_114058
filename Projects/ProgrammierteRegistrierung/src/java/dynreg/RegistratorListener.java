package dynreg;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebListener;

@WebListener
public class RegistratorListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        
        ServletContext context = sce.getServletContext();
        
        ServletRegistration.Dynamic reg;
        
        // Methode 1.
        reg = context.addServlet("WocheKlein", "dynreg.ServletWoche");
        
        reg.addMapping("/mo");
        reg.addMapping("/di", "/mi");
        
        // Methode 2.
        reg = context.addServlet("WocheGross", ServletWoche.class);
        
        reg.addMapping("/MO", "/DI");
        
        
        // Methode 3.
//        Servlet servlet = new ServletWoche();

        Servlet servlet;
        try {
            servlet = context.createServlet(ServletWoche.class);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
        
        reg = context.addServlet("WocheLang", servlet);
        
        reg.addMapping("/montag", "/dienstag");
        
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }

}
