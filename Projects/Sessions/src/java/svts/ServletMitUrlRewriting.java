package svts;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ServletMitUrlRewriting extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
//        String location = "http://www.google.de";
//        location = response.encodeRedirectURL(location);
//        response.sendRedirect(location);
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletMitUrlRewriting</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>ServletMitUrlRewriting</h1>");
            
            HttpSession session = request.getSession();
            
            out.println("Session-ID: " + session.getId() + "<br/>");
            out.println("new: " + session.isNew() + "<br/>");
            out.println("JSESSIONID-Cookie: " + getJSessionIdCookie(request) + "<br/>");
            
            out.println("<hr/>");
            
            String url = "testUrlRewriting";
            url = response.encodeURL(url);
            
            out.println("<a href=\"" + url + "\">aktualisieren (url mit Url-Rewriting)</a><br/>");
            out.println("<a href=\"testUrlRewriting\">aktualisieren (url OHNE Url-Rewriting)</a>");

            out.println("<hr/>");

            out.println("So sieht eine externe Url aus, die mit sendRedirect benutzt werden könnte: ");
            String location = "http://www.google.de";
            location = response.encodeRedirectURL(location);
            out.println(location + "<br/>");
            
            out.println("So sieht eine interne Url aus, die mit sendRedirect benutzt werden könnte: ");
            location = "index.html";
            location = response.encodeRedirectURL(location);
            out.println(location + "<br/>");
            
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    private String getJSessionIdCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if(cookies==null) {
            return "Keine Cookies gefunden";
        }
        
        for (Cookie c : cookies) {
            if( "JSESSIONID".equals( c.getName() ) ) {
                return c.getValue();
            }
        }
        
        return "JSESSIONID unter den Cookies nicht gefunden";
    }
}
