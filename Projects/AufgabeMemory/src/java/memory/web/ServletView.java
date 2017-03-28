package memory.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import memory.Memory;
import memory.MemoryImage;

public class ServletView extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Memory</title>");            
            out.println("</head>");
            
            out.println("<body>");
            out.println("<h1>Memory</h1>");
            
            out.println(" neues Spiel starten:");
            out.println("<a href=\"newGame?level=EASY\">leicht</a>");
            out.println("<a href=\"newGame?level=NORMAL\">normal</a>");
            out.println("<a href=\"newGame?level=HARD\">schwer</a>");
            out.println("<hr/>");

    //            Memory game = (Memory)request.getAttribute("game");
            
            HttpSession session = request.getSession();
            
            synchronized(session) {
                Memory game = (Memory)session.getAttribute("game");

                if(game!=null) {
                    List<MemoryImage> list = game.getImages();

                    for(int i=0; i<list.size(); i++) {
                        MemoryImage img = list.get(i);

                        if(img.isOpen()) {
                            String name = img.getName();
                            out.println("<img src=\"images/" + name + "\" width=\"50\"/>");

                        } else {
                            out.println("<a href=\"openImage?index=" 
                                    + i + "\"><img src=\"images/cover.png\" width=\"50\"/></a>");
                        }
                    }
                }
            }
            
            out.println("</body>");
            out.println("</html>");
        }
    }

}
