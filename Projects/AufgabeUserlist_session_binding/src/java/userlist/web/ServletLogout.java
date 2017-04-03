package userlist.web;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ServletLogout extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // 1. User 'ausloggen'
        HttpSession session = request.getSession(false);
        if(session!=null) {
            //Usecase 'Eingeloggt Navigieren' vorbei
            //Der Usecase-Manager u (User) wird automatisch aus dem 
            //Session-Scope entfernt und dadurch aktiviert
            session.invalidate();
        }
        
        // 3. Die View aktivieren
        response.sendRedirect("index.html");
    }

}
