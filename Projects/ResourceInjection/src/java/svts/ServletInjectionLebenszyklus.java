package svts;

import java.io.IOException;
import java.io.PrintWriter;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/injectionLebenszyklus")
public class ServletInjectionLebenszyklus extends HttpServlet {

    @Resource(name = "jdbc/TestDB")
    private DataSource ds1;

    
    @Override
    public void init() throws ServletException {
        System.out.println("-- ServletInjectionLebenszyklus / init()");
        System.out.println("---- ds1: " + ds1);
    }

    @Override
    public void destroy() {
        System.out.println("-- ServletInjectionLebenszyklus / destroy()");
        System.out.println("---- ds1: " + ds1);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletInjectionLebenszyklus</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>ServletInjectionLebenszyklus</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

}
