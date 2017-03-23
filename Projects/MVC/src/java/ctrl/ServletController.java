package ctrl;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.MyDate;

public class ServletController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // 1. User-Wunsch erkennen.
        //      hier immer: Der User will immer das Server-Datum sehen
        
        // 2. Modell initialisieren/anpassen
        MyDate date = new MyDate();
        
        // 3. View aktivieren 
        
        //(davor das/die Webanwendungsattribute setzen):
        request.setAttribute("datum", date);
        
        //Umpleiten:
        //response.sendRedirect("view");
        //response.sendRedirect(getServletContext().getContextPath() + "/view");
        
        //oder Weiterleiten mit dem RequestDispatcher:
        RequestDispatcher rd = request.getRequestDispatcher("/view");
        rd.forward(request, response);

    }
}
