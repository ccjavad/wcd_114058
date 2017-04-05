package svts;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletBack extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletBack</title>");            
            out.println("</head>");
            out.println("<body>");
            
            out.println("Request-Parameter color = " + request.getParameter("color"));
            
            out.println("<h1>Attribute aus dem Request-Scope</h1>");
            
            Enumeration<String> alleNamen = request.getAttributeNames();
            while(alleNamen.hasMoreElements()) {
                String name = alleNamen.nextElement();
                Object value = request.getAttribute(name);
                
                out.println(name + " = " + value + "<br/>");
            }
            
            out.println("<hr/>");
            // --------------------------------- 
            RequestDispatcher rd = request.getRequestDispatcher("/date");
            rd.include(request, response);
            
            out.println("</body>");
            out.println("</html>");
        }
    }

}
