package config;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet( 
    name = "My Servlet Name",
    urlPatterns = "/servletMitAnn",
    asyncSupported = false,
    loadOnStartup = 121314,
    
    initParams = {
        @WebInitParam(name = "n1", value = "v1"),
        @WebInitParam(name = "n2", value = "v2")
    }
)
public class ServletMitAnn extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletMitAnn</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletMitAnn at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
