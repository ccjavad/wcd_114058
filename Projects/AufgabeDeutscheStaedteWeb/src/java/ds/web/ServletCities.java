package ds.web;

import ds.JSoupParser;
import ds.Parser;
import ds.Stadt;
import ds.StadtUtils;
import ds.TextIO;
import ds.db.MysqlStaedteDAO;
import ds.db.StaedteDAO;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Comparator;
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
        
        
        List<Stadt> listStaedte = null;

//      ------------------------
//      Liste direkt aus der Datenbank:        
//      ------------------------
//        StaedteDAO dao = new MysqlStaedteDAO();
//        try {
//            //Treiber selbst laden, die VM von Tomcat tut es nicht:
//            Class.forName("org.gjt.mm.mysql.Driver"); 
//
//            listStaedte = dao.selectAll();
//            
//        } catch(SQLException | ClassNotFoundException e) {
//            throw new ServletException(e);
//        }

        String charset = "UTF-8";
        
//      ---------------------------------
//      html aus dem Netzwerk:
//      ---------------------------------
//        String urlName = "https://de.wikipedia.org/wiki/Liste_der_Gro%C3%9Fst%C3%A4dte_in_Deutschland";
//        String htmlText = TextIO.download(urlName, charset);
        
//      ---------------------------------
//      html aus dem Classpath:
//      ---------------------------------
//        String htmlText = TextIO.loadFromResource("/ds/test/wiki.html", charset);

//      ---------------------------------
//      html von der Festplatte:
//      ---------------------------------
        ServletContext context = getServletContext();
        String fileName = context.getRealPath("/WEB-INF/wiki.html");
        File file = new File(fileName);
        String htmlText = TextIO.load(file, charset);

        
//      ---------------------------------
//      Liste parsen:
//      ---------------------------------
        Parser parser = new JSoupParser();
        listStaedte = parser.parse(htmlText);
                
        
        String sort = request.getParameter("sort");
        
        Comparator<Stadt> cmp = null;
        if(sort!=null) {
            switch(sort) {
                case "name":
                    cmp = StadtUtils.CMP_NACH_NAMEN;
                    break;
                case "land":
                    cmp = StadtUtils.CMP_NACH_LAND;
                    break;
                case "einwohner":
                    cmp = StadtUtils.CMP_NACH_EINWOHNER;
                    break;
                default:
                    //Reaktion bei falschen sort-Werten
            }
        }
        
        if(cmp!=null) {
            Collections.sort(listStaedte, cmp);
        }
        
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
        out.println("<th><a href=\"cities.do?sort=name\">Name</a></th>");
        out.println("<th><a href=\"cities.do?sort=land\">Land</a></th>");
        out.println("<th><a href=\"cities.do?sort=einwohner\">Einwohner</a></th>");
        out.println("</tr>");
        
        for (int i = 0; i < listStaedte.size(); i++) {
            Stadt s = listStaedte.get(i);
            
            out.println("<tr>");
            out.println("<td>" + (i+1) + "</td>");
            out.println("<td>" + s.getName() + "</td>");
            out.println("<td>" + s.getLand()+ "</td>");
            out.println("<td>" + s.getEinwohner()+ "</td>");
            out.println("</tr>");
        }
        
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
    }
    
}
