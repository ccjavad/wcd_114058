package svts;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletZugang extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //Exam: authenticate liefert false zurück, wen das Authentifizieren nicht
        //      vollständig ist (oder gar nicht)
        if( !request.authenticate(response) ) {
            return;
        }
        
        String target = "/WEB-INF/unknownRole.jsp";
        
        if( request.isUserInRole("regUser") ) {
            target = "/WEB-INF/user.jsp";
        } else if( request.isUserInRole("regAdmin") ) {
            target = "/WEB-INF/admin.jsp";
        }  else if( request.isUserInRole("manager") ) {
            target = "/WEB-INF/manager.jsp";
        }
        
        request.getRequestDispatcher(target).forward(request, response);
    }
}
