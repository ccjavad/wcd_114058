package dynreg;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebListener;

/*
    ServletRegistration.Dynamic
        public void setLoadOnStartup(int loadOnStartup);

        public void setMultipartConfig(MultipartConfigElement multipartConfig);
        public void setRunAsRole(String roleName); 

        public Set<String> setServletSecurity(ServletSecurityElement constraint);

    ServletRegistration (Basistyp von ServletRegistration.Dynamic)
        public Set<String> addMapping(String... urlPatterns);
        ...

    Registration (Basistyp von ServletRegistration)
        public boolean setInitParameter(String name, String value);
        ...

    Registration.Dynamic (Basistyp von ServletRegistration.Dynamic)
        public void setAsyncSupported(boolean isAsyncSupported);

*/

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
            //die 'createServlet' führt Resource Injections durch (wenn es sein muss) 
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
