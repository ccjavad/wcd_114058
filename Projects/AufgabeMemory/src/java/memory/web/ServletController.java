package memory.web;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Modell initialisieren/anpassen
        
        // View aktivieren        
        
        RequestDispatcher rd = request.getRequestDispatcher("/view");
        rd.forward(request, response);
        
    }

}
