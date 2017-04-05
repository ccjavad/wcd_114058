package svts;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletFront extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        /*
            <url-pattern>/front</url-pattern>
            <url-pattern>/wetter/wind.html</url-pattern>
        */
        
        RequestDispatcher rd;

        // 1.a  RequestDiapatcher aus dem Request.
        //         Pfad: relativ zum aktuellen Request-Pfad
         rd = request.getRequestDispatcher("back?color=orange");
        
        // 1.b ReqzestDispatcher aus dem Request.
        //          Pfad: relativ zum Context-Path
        // rd = request.getRequestDispatcher("/back");
        
        ServletContext context = getServletContext();
        // 2  RequestDispatcher aus dem ServletContext
        //          Pfad: relativ NUR zum Context-Path
        // rd = context.getRequestDispatcher("/back");

        // 2  RequestDispatcher aus dem ServletContext
        //          mit einem Servlet-Namen
        // rd = context.getNamedDispatcher("S-Back");
        
        rd.forward(request, response);
        
    }
}
