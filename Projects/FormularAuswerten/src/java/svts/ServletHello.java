package svts;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletHello extends HttpServlet {

    private void printForm(HttpServletResponse response, String userName, String errMsg) throws IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletHello</title>");            
            out.println("</head>");
            out.println("<body>");
            
            out.println("<form action=\"hello\" method=\"post\">");
            
            userName = userName == null ? "" : userName;
            
            out.println("Name: <input name=\"userName\" value=\"" + userName +"\"/>");
            out.println("<input type=\"submit\"/>");
            out.println("</form>");
            
            if(errMsg!=null) {
                out.println("<br/><b>" + errMsg + "<b/>");
            }
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        printForm(response, null, null);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String userName = request.getParameter("userName");
        
        String errorMsg = null;
        
        if(userName==null) {
            errorMsg = "Der Name fehlt komplett!";
        } else if( userName.length() < 3 ) {
            errorMsg = "Der Name ist zu kurz. Muss mindestens 3 Zeichen haben";
        } else if( userName.length() > 10 ) {
            errorMsg = "Der Name ist zu lang. Maximal 10 Zeichen erlaubt";
        }
        
        if(errorMsg!=null) {
            printForm(response, userName, errorMsg);
            return;
        }
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletHello</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Hallo " + userName + "!</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

}
