package config_dyn;

import java.util.EnumSet;
import javax.servlet.HttpConstraintElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRegistration;
import javax.servlet.ServletSecurityElement;
import javax.servlet.SessionTrackingMode;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebListener;

@WebListener
public class ConfigAppListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        
        ServletContext context = sce.getServletContext();
        
        /*
        <security-role>
            <role-name>regUser</role-name>
            <role-name>regAdmin</role-name>
        </security-role>
        
        oder
        
        @DeclareRoles("regManager", "nochEineRolle")
        */
        context.declareRoles("regManager", "nochEineRolle");

        /*
            Session Tracking
        
            context.setSessionTrackingModes( EnumSet.of(SessionTrackingMode.SSL));
        */
        
        /*
            Context-Parameter
        
            context.setInitParameter("contexParamName1", "value1");
        */
        
        
        /*
            *****************************
            Exam: 
            *****************************
            // setServletSecurity:
            // http://docs.oracle.com/javaee/6/api/javax/servlet/ServletRegistration.Dynamic.html#setServletSecurity(javax.servlet.ServletSecurityElement)
        */
        
        ServletRegistration.Dynamic reg 
                = context.addServlet("Exam-Servlet", ServletExam.class);
        
        reg.addMapping("/januar");
        
        /*
            Welche URL wird von der Security-Constraint betroffen?
        
            Antwort: 
                    die url '/januar' betroffen
                    die Auswirkung auf '/februar' nicht spezifiziert
        */
        HttpConstraintElement httpCE = new HttpConstraintElement(ServletSecurity.EmptyRoleSemantic.DENY);
        ServletSecurityElement sse = new ServletSecurityElement(httpCE);

        reg.setServletSecurity(sse); //man muss in der Prüfung nicht wissen, wie sse erzeugt wird
        
        reg.addMapping("/februar");
        
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }

}
