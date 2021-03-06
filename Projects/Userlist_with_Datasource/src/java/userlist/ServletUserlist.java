package userlist;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet(name = "ServletGetUserlist", urlPatterns = {"/getUserlist"})
public class ServletUserlist extends HttpServlet {

    @Resource(name = "jdbc/UserDB")
    private DataSource dataSource;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            List<User> userList = DatabaseAccess.selectAll(dataSource);
            
            for (User user : userList) {
                out.println("<li>" + user + "</li>");
            }
            
        } catch(SQLException e) {
            throw new ServletException(e);
        }
    }


}
