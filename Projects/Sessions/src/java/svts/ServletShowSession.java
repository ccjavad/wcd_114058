/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package svts;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author apatrin
 */
public class ServletShowSession extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // getSession:
        
        // 1. Client identifizieren: Dafür (z.B.) nach dem Cookie JSESSIONID suchen.
        //
        // 1.a  JSESSIONID nicht gefunden (Client kann nicht identifiziert werden)
        //      - JSESSIONID generieren
        //      - Ein neues HttpSession-Objekt erzeugen
        //      - Im Container die neue JSESSIONID dem neuen HttpSession-Objekt zuordnen
        //      - JSESSIONID als Cookie setzen
        //          Header 'Set-Cookie: JSESSIONID=7379CF0DA70056350F650B5F47554894; Path=/Sessions/; HttpOnly'
        // 1.b  JSESSIONID gefunden (z.B. als 'Cookie: JSESSIONID=7379CF0DA70056350F650B5F47554894')
        //      - Nach dem JSESSIONID das alte HttpSession-Objekt finden
        //
        // 2. Das HttpSession-Objekt wird geliefert
        
//        HttpSession session = request.getSession();
        HttpSession session = request.getSession(true); //dasselbe wie in der Zeile davor
//        HttpSession session = request.getSession(false); //keine neue Session erzeugen, nur suchen:
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletShowSession</title>");            
            out.println("</head>");
            out.println("<body>");

            out.println("session-id: " + session.getId() + "</br>");
            out.println("isNew(): " + session.isNew() + "</br>");
            
            // Attributen-Methoden
            
            long creationTime = session.getCreationTime();
            out.println("getCreationTime(): " + creationTime + " ms.</br>");
            
            long lastAccessedTime = session.getLastAccessedTime();
            out.println("getLastAccessedTime(): " + lastAccessedTime + " ms.</br>");
            
            int maxInactiveInterval = session.getMaxInactiveInterval(); //sekunden
            out.println("getMaxInactiveInterval(): " + maxInactiveInterval + " s.</br>");
            out.println("getMaxInactiveInterval(): " + maxInactiveInterval / 60 + " min.</br>");
            
            /* Im DD in Minuten:
                <session-config>
                    <session-timeout>
                        30
                    </session-timeout>
                </session-config>
            */
            
            session.setMaxInactiveInterval(500); //sekunden
            
            //ServletContext context = session.getServletContext();

            session.invalidate(); //danach bitte keine Attribute lesen/setzen
            
            
            out.println("<hr/>");
            out.println("<a href=\"showSession\">aktualisieren</a>");
            
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
