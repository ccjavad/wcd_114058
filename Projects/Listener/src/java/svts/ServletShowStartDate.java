/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package svts;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletShowStartDate extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletShowStartDate</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>ServletShowStartDate</h1>");
            ServletContext context = getServletContext();
            Date startDate = (Date)context.getAttribute("app-start-date");
            out.println("Anwendung gestartet: " + startDate);
            out.println("</body>");
            out.println("</html>");
        }
    }
}
