package ds.test;

import ds.JSoupParser;
import ds.Parser;
import ds.Stadt;
import ds.TextIO;
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
        
        htmlText = TextIO.load(file);

        
        Parser parser = new JSoupParser();
//        Parser parser = new RegexParser();
        
        List<Stadt> list = parser.parse(htmlText);
        
        for (Stadt stadt : list) {
            System.out.println(stadt);
        }
        
        System.out.println("--> geparst: " + list.size());
    }
    
}
