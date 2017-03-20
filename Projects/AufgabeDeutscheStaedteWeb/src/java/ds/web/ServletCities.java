package ds.web;

import ds.JSoupParser;
import ds.Parser;
import ds.Stadt;
import ds.TextIO;
import ds.db.MysqlStaedteDAO;
import ds.db.StaedteDAO;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletCities extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        
        StaedteDAO dao = new MysqlStaedteDAO();
        
        List<Stadt> listStaedte = null;

//      ------------------------
//      Direkt aus der Datenbank:        
//      ------------------------
//        try {
//            Class.forName("org.gjt.mm.mysql.Driver");
//            listStaedte = dao.selectAll();
//            
//        } catch(SQLException | ClassNotFoundException e) {
//            throw new ServletException(e);
//        }

        String charset = "UTF-8";
        
//      ---------------------------------
//      Parsen der html aus dem Netzwerk:
//      ---------------------------------
//        String urlName = "https://de.wikipedia.org/wiki/Liste_der_Gro%C3%9Fst%C3%A4dte_in_Deutschland";
//        String htmlText = TextIO.download(urlName, charset);
        

//      ---------------------------------
//      Parsen der html aus dem Classpath:
//      ---------------------------------
//        String htmlText = TextIO.loadFromResource("/ds/test/wiki.html", charset);


//      ---------------------------------
//      Parsen der html von der Festplatte:
//      ---------------------------------
        ServletContext context = getServletContext();
        String fileName = context.getRealPath("/WEB-INF/wiki.html");
        File file = new File(fileName);
        String htmlText = TextIO.load(file, charset);

        Parser parser = new JSoupParser();
        listStaedte = parser.parse(htmlText);
                
        
        
//      ------------------------
//      Ausgeben:
//      ------------------------
        
        response.setContentType("text/html;charset=UTF-8");
        
        PrintWriter out = response.getWriter();
        
        out.println("<html>");
        out.println("<head>\n" +
"        <title>Deutsche Städte</title>\n" +
"        <meta charset=\"UTF-8\">\n" +
"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"    </head>");
        out.println("<body>");
        out.println("<h1>Deutsche Städte</h1>");
        out.println("<table>");
        
        out.println("<tr>");
        out.println("<th>Nr.</th>");
        out.println("<th>Name</th>");
        out.println("<th>Land</th>");
        out.println("<th>Einwohner</th>");
        out.println("</tr>");
        
        for (int i = 0; i < listStaedte.size(); i++) {
            
            Stadt s = listStaedte.get(i);
            System.out.println(s);
            out.println(s + "<br/>");
            
        }
        
        out.println("");
        out.println("");
        out.println("");
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
        
        
    }
    
}
