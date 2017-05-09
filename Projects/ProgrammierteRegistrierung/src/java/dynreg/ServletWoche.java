package dynreg;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletWoche extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletWoche</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>ServletWoche</h1>");
            
            out.println("hashCode: " + hashCode() + "<br/>");
            out.println("servlet-name: " + getServletName() + "<br/>");
            out.println("request-uri: " + request.getRequestURI() + "<br/>");
            
            
            out.println("</body>");
            out.println("</html>");
        }
    }

}
