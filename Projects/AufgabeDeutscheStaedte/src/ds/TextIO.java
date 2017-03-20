package ds;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;

public class TextIO {
    
    /**
     * Liesst alles aus dem Reader r nd konkateniert zu einem String.
     * Schliesst den Reader r!
     * 
     * @param r Quelle der Daten
     * @return String aus den Daten aus dem Reader r
     * @throws IOException 
     */
    private static String read(Reader r) throws IOException {
        StringBuilder sb = new StringBuilder();
        
        //try with resources:
        try (BufferedReader in = new BufferedReader(r) ) {
        
            String line;
            while( (line=in.readLine()) != null ) {
                sb.append(line).append("\n");
            }
        
        } // es gibt finally mit dem korrekten Aufruf in.close()
        
        return sb.toString();
        
    }

    public static String download(String urlName, String charset) 
            throws MalformedURLException, UnsupportedEncodingException, IOException {
        
        URL url = new URL(urlName);
        
        //TODO: werden die beiden immer geschlossen?
        InputStream is = url.openStream();
        InputStreamReader isr = new InputStreamReader(is, charset);

        return read(isr);
    }

    public static String load(File file, String charset) 
            throws FileNotFoundException, IOException {
        
        InputStream is = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(is, charset);
        
        return read( isr );
    }
    
    public static String loadFromResource(String resourceInClassPath, String charset)
            throws IOException {
        InputStream is = TextIO.class.getResourceAsStream(resourceInClassPath);
        InputStreamReader isr = new InputStreamReader(is, charset);
        
        return read(isr);
    }
    
    public static void save(String text, File file, String charset)
            throws FileNotFoundException, UnsupportedEncodingException {
        
        //try with resources:
        try ( PrintWriter out = new PrintWriter(file, charset) ) {
            out.print(text);
        } //finally mit out.close() unsichtbar hier
        
    }
    
    

}




/*
        Schliessen einer Resource mit Java 6:

        BufferedReader in = null;
        try {
        
            in = new BufferedReader(isr);

            String line;
            while( (line=in.readLine()) != null ) {
                System.out.println(line);
            }
        
        } finally {
            if(in!=null) {
                in.close();
            }
        }

*/

