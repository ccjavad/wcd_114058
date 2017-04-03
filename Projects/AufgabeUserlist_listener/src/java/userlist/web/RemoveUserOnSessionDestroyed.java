package userlist.web;

import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import userlist.User;

public class RemoveUserOnSessionDestroyed implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {

        HttpSession session = se.getSession();
        User u = (User)session.getAttribute("user");
        
        if(u!=null) {
            ServletContext context = session.getServletContext();
            List<User> listUser = (List)context.getAttribute("listUser");

            listUser.remove(u);
        }
    }

}
