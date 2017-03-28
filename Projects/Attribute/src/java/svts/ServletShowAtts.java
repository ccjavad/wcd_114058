package svts;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ServletShowAtts extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletShowAtts</title>");            
            out.println("</head>");
            out.println("<body>");
            
            out.println("<h1>Attribute aus dem Request-Scope</h1>");
            
            Enumeration<String> alleNamen = request.getAttributeNames();
            while( alleNamen.hasMoreElements() ) {
                String attName = alleNamen.nextElement();
                Object attValue = request.getAttribute(attName);
                
                out.println(attName + " = " + attValue + "<br/>");
            }
            
            
            
            out.println("<h1>Attribute aus dem Session-Scope</h1>");
            
            HttpSession session = request.getSession();
            alleNamen = session.getAttributeNames();
            
            while( alleNamen.hasMoreElements() ) {
                String attName = alleNamen.nextElement();
                Object attValue = session.getAttribute(attName);
                
                out.println(attName + " = " + attValue + "<br/>");
            }
            
            
            
            out.println("<h1>Attribute aus dem Application-Scope (nur Namen)</h1>");
            
            ServletContext servletContext = getServletContext();
            alleNamen = servletContext.getAttributeNames();
            
            while( alleNamen.hasMoreElements() ) {
                String attName = alleNamen.nextElement();
                Object attValue = servletContext.getAttribute(attName);
                
                out.println(attName + "<br/>");
//                out.println(attName + " = " + attValue + "<br/>");
            }
            
            out.println("<h3>Nochmal: att = " + servletContext.getAttribute("att") + "</h3>");
            
            
            
            out.println("</body>");
            out.println("</html>");
        }
    }

}
