package svts;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletForwardToForeignContext extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Test Wetter</title>");
            out.println("</head>");
            out.println("<body>");

            out.println("Windstärke: ");

            ServletContext servletContext = getServletContext();
            
            ServletContext foreignContext = servletContext.getContext("/Wetter");
            
            RequestDispatcher rd = foreignContext.getRequestDispatcher("/wind");
            
            request.setAttribute("suffix", "Stundenkilometer");
            rd.include(request, response);

            out.println("</body>");
            out.println("</html>");
        }
    }

}
