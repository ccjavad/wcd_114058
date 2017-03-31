package userlist.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import userlist.User;

public class ServletMain extends HttpServlet {

//    @Override
//    public void init() throws ServletException {
//        //Die Daten für die ganze Anwendung vorbereiten
//        getServletContext().setAttribute("listUser", new ArrayList<>());
//    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletMain</title>");            
            out.println("</head>");
            out.println("<body>");
            
            HttpSession session = request.getSession(false);
            
            if(session==null) {
                out.println("Sie sind nicht eingeloggt");
                out.println("(<a href=\"loginform.html\">einloggen</a>)");
                
            } else {
                User u = (User)session.getAttribute("user");
                out.println("Hallo " + u.getName());
                out.println("(<a href=\"logout\">ausloggen</a>)");
                
            }
            
            out.println("<hr/>");
            
            out.println("Gerade eingeloggt: <br/>");
            
            ServletContext app = getServletContext();
            List<User> listUser = (List)app.getAttribute("listUser");
            
            for (int i=0; i<listUser.size(); i++) {
                User u = listUser.get(i);
                out.println( i+1 + ". " + u.getName() + "<br/>");
            }
            
            out.println("</body>");
            out.println("</html>");
        }
    }

}
