package memory.web;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import memory.Memory;

public class ServletController extends HttpServlet {

    private List<String> listImageNames;
    private Memory game;

    @Override
    public void init() throws ServletException {
        
        ServletContext context = getServletContext();
        String imagesDirName = context.getRealPath("/images");
        File imagesDir = new File(imagesDirName);
        
        String[] imageFileNames = imagesDir.list();
        
        listImageNames = Arrays.asList(imageFileNames);
        listImageNames = new ArrayList<>(listImageNames);
        listImageNames.remove("cover.png");
        listImageNames = Collections.unmodifiableList(listImageNames);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // User-Wunsch erkennen und entsprechend das Modell initialisieren/anpassen
        
        String requestUri = request.getRequestURI();
        
        if(requestUri.contains("/newGame")) {
            String paramLevel = request.getParameter("level");
            Memory.Level level = Memory.Level.valueOf(paramLevel);
            
            game = new Memory(level, listImageNames);
            request.setAttribute("game", game);
            
        } else if(requestUri.contains("/openImage")) {
            
            String paramImageIndex = request.getParameter("index");
            int imageIndex = Integer.parseInt(paramImageIndex);

            game.openImage(imageIndex);
            request.setAttribute("game", game);
        }
        
        // View aktivieren        
        
        RequestDispatcher rd = request.getRequestDispatcher("/view");
        rd.forward(request, response);
    }

}
