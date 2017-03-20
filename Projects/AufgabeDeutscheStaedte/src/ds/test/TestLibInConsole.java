package ds.test;

import ds.JSoupParser;
import ds.Parser;
import ds.Stadt;
import ds.TextIO;
import ds.db.MysqlStaedteDAO;
import ds.db.StaedteDAO;
import java.io.File;
import java.util.List;

public class TestLibInConsole {

    private static final String URL_NAME = "https://de.wikipedia.org/wiki/Liste_der_Gro%C3%9Fst%C3%A4dte_in_Deutschland";
    private static final String CHARSET = "UTF-8";
    
    public static void main(String[] args) throws Exception {
     
        String htmlText;

        File file = new File("wiki.html");
        
//        htmlText = TextIO.download(URL_NAME, CHARSET);

//        TextIO.save(htmlText, file, CHARSET);
        
        htmlText = TextIO.load(file, CHARSET);

//        htmlText = TextIO.loadFromResource( "/ds/test/wiki.html", CHARSET );
        
        Parser parser = new JSoupParser();
//        Parser parser = new RegexParser();
        
        List<Stadt> list = parser.parse(htmlText);
        
        System.out.println("--> geparst: " + list.size());
        
        
        for (Stadt stadt : list) {
            System.out.println(stadt);
        }
        
        
//        StaedteDAO dao = new MysqlStaedteDAO();
//        
//        dao.insert(list);
//        System.out.println("--> Städte in die Datenbank übertragen");
//        
//        list = dao.selectAll();
//        System.out.println("--> aus der Datenbank geladen: " + list.size());
        
    }
    
}
