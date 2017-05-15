package api;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
    urlPatterns = {"/api"},
    asyncSupported = true
)
public class ServletAsyncAPI extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        AsyncContext asyncContext = request.startAsync(); //Exam!
//        AsyncContext asyncContext = request.startAsync(requestWrapper, responseWrapper); //Exam?

        Runnable asyncTask = new Runnable() {
            @Override
            public void run() {
                //hier asynchron die Antwort definieren
                
                //Async. Behandlung beenden
                asyncContext.complete(); //Exam!
            }
        };
        asyncContext.start(asyncTask); //Exam?
    
        
    }

/*
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletAsyncAPI</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletAsyncAPI at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    
    */    
    
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
