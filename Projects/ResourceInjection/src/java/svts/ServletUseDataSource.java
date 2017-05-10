package svts;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import javax.annotation.Resource;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.UnavailableException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/useDataSource")
public class ServletUseDataSource extends HttpServlet {
    
    @Resource(name = "jdbc/TestDB")
    private DataSource dataSource;

//    @Override
//    public void init() throws ServletException {
//        try {
//            InitialContext ctx = new InitialContext();
//            dataSource = (DataSource)ctx.lookup("java:comp/env/jdbc/TestDB");
//        } catch(NamingException e) {
//            throw new UnavailableException("DataSource-Objekt bei JNDI nicht gefunden");
//        }
//    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletUseDataSource</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>ServletUseDataSource</h1>");
            if( dataSource!=null ) {
                try( Connection connection = dataSource.getConnection() ) {
                    out.println("Connection steht: " + connection + "<br/>");

                } catch( SQLException e ) {
                    out.println("Fehler in getConnection: " + e.getMessage() + "<br/>");
                }
            } else {
                out.println("Fehler! DataSource nicht gesetzt<br/>");
            }
            
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
