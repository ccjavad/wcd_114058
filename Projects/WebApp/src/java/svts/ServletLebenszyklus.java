package svts;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletLebenszyklus extends HttpServlet {

    static {
        System.out.println("-- ServletLebenszyklus / die Klasse wird geladen");
    }

    // Konstruktor definieren NICHT empfohlen!
    public ServletLebenszyklus() {
        System.out.println("-- ServletLebenszyklus / das Java-Objekt wurde angelegt und wird initialisiert");
        //System.out.println("ServletContext: " + getServletContext());
    }

    // Überschreiben NICHT empfohlen!
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("-- ServletLebenszyklus / init(ServletConfig)");
        super.init(config); //ruft die init() auf
    }
    
    // *** Fürs Überschreiben vorgesehen
    @Override
    public void init() throws ServletException {
        System.out.println("-- ServletLebenszyklus / init()");
        System.out.println("---- ServletContext: " + getServletContext());
        ServletConfig config = getServletConfig();
        System.out.println("---- ServletContext: " + config.getServletContext());
    }

    // Überschreiben NICHT empfohlen!
    @Override
    public void service(ServletRequest request, ServletResponse response)
            throws ServletException, IOException {
        
        System.out.println("-- ServletLebenszyklus / service(ServletRequest, ServletResponse)");
        super.service(request, response); //ruft die service(HttpServletRequest, HttpServletResponse) auf
    }

    // Überschreiben NICHT empfohlen!
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("-- ServletLebenszyklus / service(HttpServletRequest, HttpServletResponse)");
        super.service(req, resp);
    }
    
    // *** Fürs Überschreiben vorgesehen
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        System.out.println("-- ServletLebenszyklus / doGet(HttpServletRequest, HttpServletResponse)");

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletLebenszyklus</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletLebenszyklus at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // *** Fürs Überschreiben vorgesehen
    @Override
    public void destroy() {
        System.out.println("-- ServletLebenszyklus / destroy()");
    }
}
