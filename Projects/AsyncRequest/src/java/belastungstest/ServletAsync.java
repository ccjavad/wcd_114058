package belastungstest;

import java.io.IOException;
import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
    name = "ServletAsync", 
    urlPatterns = {"/async"},
    asyncSupported = true
)
public class ServletAsync extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Containerspezifisch (nicht in der Prüfung:)
        request.setAttribute("org.apache.catalina.ASYNC_SUPPORTED", true);
        
        //1. Das Request in den Async-Zustand versetzen:
        AsyncContext asyncContext = request.startAsync();
        
        Thread ownThread = new Thread() {
            @Override
            public void run() {
                BigJob.doJob(response, getServletName());
                
                //3. Das Beenden der Request-Bechandlung aus dem eigenen Thread melden
                asyncContext.complete();
            }
        };
        
        //2. Eigenen Thread starten
        ownThread.start();
    }

    

}
