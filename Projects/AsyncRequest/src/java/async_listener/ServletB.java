/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package async_listener;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletB", 
        urlPatterns = {"/servletB"},
        asyncSupported = true)
public class ServletB extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
                //Containerspezifisch (nicht in der Prüfung:)
        request.setAttribute("org.apache.catalina.ASYNC_SUPPORTED", true);
        
        AsyncContext asyncContext = request.startAsync();
        asyncContext.addListener(new MyAsyncListener());

        Runnable asyncTask = new Runnable() {
            @Override
            public void run() {
                processRequest(request, response);
                asyncContext.complete();
            }
        };
        
        asyncContext.start(asyncTask);
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletB</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletB at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

}
