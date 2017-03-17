package svts;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletRandomNumber extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
//        String url = req.getRequestURI();
        
        String type = req.getParameter("type");
        
        type = type == null ? "int" : type;
        
        Random random = new Random();
        
        Number value = null;
        
        switch(type) {
            case "int":
                value = random.nextInt();
                break;
            case "double":
                value = random.nextDouble();
                break;
        }
        
        PrintWriter out = resp.getWriter();
        
        if(value==null) {
            out.print("Falscher Wert für den Request-Parameter 'type': " + type);
        } else {
            out.print(value);
        }
    }
    
    
}
