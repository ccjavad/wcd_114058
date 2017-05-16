package dispatch;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
    urlPatterns = {"/controller"},
    asyncSupported = true
)
public class ServletController extends HttpServlet {

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //Containerspezifisch (nicht in der Prüfung:)
        request.setAttribute("org.apache.catalina.ASYNC_SUPPORTED", true);
        
        AsyncContext asyncContext = request.startAsync();
        
        // 1. dispatch startet die Resource /view asynchron
        // 2. Im Thread, in dem die Resource /view 'ausgeführt' wird,
        //    wird nach getaner Arbeit asyncContext.complete() aufgerufen
        asyncContext.dispatch("/view");
        
        //asyncContext.dispatch(foreignContext, path); //Asynchron die Ressource aus einer anderen Webanwendung aufrufen
        
        //asyncContext.dispatch(); //aktiviert die aktuelle Ressource wieder
    }

}
