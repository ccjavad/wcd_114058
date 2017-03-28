package svts;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ServletAddAttsAndRedirect extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("att", new Date());
        
        HttpSession session = request.getSession();
        session.setAttribute("att", "Wert 2 für Session-Scope (erzeugt im ServletAddAttsAndRedirect)");
        
        ServletContext servletContext = getServletContext();
        servletContext.setAttribute("att", 33);
        
        response.sendRedirect("showAtts");
    }    
   
}
