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

public class ServletLogin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //1. den User 'einloggen'
        String userName = request.getParameter("userName");
        User u = new User(userName);
        HttpSession session = request.getSession();
//        session.setMaxInactiveInterval(5);
        
        session.setAttribute("user", u);
        
        //2. Den User zu der 'globalen' Liste aller eingloggten User hinzufügen
        ServletContext app = getServletContext();
        List<User> listUser = (List)app.getAttribute("listUser");
        listUser.add(u);
        
        //3. View aktivieren
        response.sendRedirect("index.html");
    }

}
