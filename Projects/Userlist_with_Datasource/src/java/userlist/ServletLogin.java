package userlist;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/login"})
public class ServletLogin extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        if(! request.authenticate(response) ) {
            return;
        }

        String target;
        if(request.isUserInRole("administrator")) {
            target = "/WEB-INF/admin.jsp";
        } else {
            target = "/WEB-INF/kunde.jsp";
        }
        
        request.getRequestDispatcher(target).forward(request, response);
    }
}
