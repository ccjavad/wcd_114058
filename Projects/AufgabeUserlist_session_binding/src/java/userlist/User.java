package userlist;

import java.util.List;
import java.util.Objects;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class User implements HttpSessionBindingListener {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        
        HttpSession session = event.getSession();
        
        ServletContext app = session.getServletContext();
        List<User> listUser = (List)app.getAttribute("listUser");
        listUser.add(this);
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        
        HttpSession session = event.getSession();
       
        ServletContext context = session.getServletContext();
        List<User> listUser = (List)context.getAttribute("listUser");

        listUser.remove(this);
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }
 
    
}
