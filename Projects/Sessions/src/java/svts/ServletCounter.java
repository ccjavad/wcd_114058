package svts;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ServletCounter extends HttpServlet {

    private int countGesamt = 0;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletCounter</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>ServletCounter</h1>");
            
            synchronized(this) {
                out.println("Gesamtanzahl aller Anfragen aller Clinets: " + 
                   ++countGesamt + "<br/>");
            }
            
            HttpSession session = request.getSession();
            
            Integer countUser;
            
            synchronized(session) {
                countUser = (Integer)session.getAttribute("countUser");
                if(countUser==null) {
                    countUser = 1;
                } else {
                    countUser++;
                }
                session.setAttribute("countUser", countUser);
            }
            
            out.println("Anzahl Ihrer Anfragen: " + countUser);
            
            out.println("<hr/>");
            out.println("<a href=\"count\">aktualisieren</a>");
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
