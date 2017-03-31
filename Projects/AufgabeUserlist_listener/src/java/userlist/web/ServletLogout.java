package userlist.web;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import userlist.User;

public class ServletLogout extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
//        User u = null;
        
        // 1. User 'ausloggen'
        HttpSession session = request.getSession(false);
        if(session!=null) {
//            u = (User)session.getAttribute("user");
            session.invalidate();
        }
        
        // 2. User aus der 'globalen' Liste entfernen
//        if(u!=null) {
//            ServletContext app = getServletContext();
//            List<User> listUser = (List)app.getAttribute("listUser");
//            
//            listUser.remove(u);
//        }
        
        // 3. Die View aktivieren
        response.sendRedirect("index.html");
    }

}
