package belastungstest;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;

public class BigJob {

    public static void doJob(HttpServletResponse response, String servletName) {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>" + servletName + "</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>" + servletName + "</h1>");
            out.println("</body>");
            out.println("</html>");
            
            Thread.sleep(2000);
        } catch (InterruptedException | IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    
}
