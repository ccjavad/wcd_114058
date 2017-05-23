package userlist;

import java.io.IOException;
import java.sql.SQLException;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet(urlPatterns = {"/signin"})
public class ServletSignin extends HttpServlet {

    @Resource(name = "jdbc/UserDB")
    private DataSource dataSource;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String userName = request.getParameter("userName");
        String userPassword = request.getParameter("userPassword");
        
        try {
            DatabaseAccess.insertUser(dataSource, userName, userPassword, "kunde");
        } catch (SQLException e) {
            throw new ServletException(e);
        }
        
        response.sendRedirect("login");
    }

}
