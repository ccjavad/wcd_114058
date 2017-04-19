package gb.web;

import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedHashSet;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class PersistenceListener implements ServletContextListener {

    private DatabaseAccess dbAccess = new DatabaseAccess();
        
    @Override
    public void contextInitialized(ServletContextEvent sce) {

        try {
            Collection<Entry> entries = dbAccess.selectAll();

            ServletContext context = sce.getServletContext();
            context.setAttribute("guestbookEntries", entries);
            
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        
        try {
            ServletContext context = sce.getServletContext();
            Collection<Entry> entries = (Collection)context.getAttribute("guestbookEntries");

            dbAccess.update(entries);
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
