package gb.web;

import java.io.IOException;
import java.util.Collection;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletAddEntry extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userName = request.getParameter("userName");
        String userText = request.getParameter("userText");
        
        ServletContext context = getServletContext();
        
        //Achtung! Auch die JSP muss den Zugriff auf Application-Scope synchronisieren
        synchronized(context) {
            Collection<Entry> entries = (Collection)context.getAttribute("guestbookEntries");
        
            Entry newEntry = new Entry(userName, userText);
            entries.add(newEntry);
        }
        
        response.sendRedirect("index.jsp");
    }

}
