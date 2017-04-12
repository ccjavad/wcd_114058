package utils;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;

public class DateUtils {

    public static Date create() {
        return new Date();
    }
    
    public static void create(String attName, String scopeName, 
            PageContext pageContext) {
        
        int scope;
        
        switch(scopeName) {
            case "page":
                scope = PageContext.PAGE_SCOPE;
                break;
            case "request":
                scope = PageContext.REQUEST_SCOPE;
                break;
            case "session":
                scope = PageContext.SESSION_SCOPE;
                break;
            case "application":
                scope = PageContext.APPLICATION_SCOPE;
                break;
            default: 
                throw new IllegalArgumentException("Scope not supported: " + scopeName);
        }
        
        pageContext.setAttribute(attName, new Date(), scope);
    }
    
    public static void addDays(Date d, int days) {
        long time = d.getTime();
        time += 24L * 60 * 60 * 1000 * days;
        d.setTime(time);
    }
    
    public static void print(Date d, JspWriter out) throws IOException {
        out.print(d);
    }
    
    public static String format(Date d, String lang) {
        Locale locale = new Locale(lang);
        DateFormat df = DateFormat.getDateTimeInstance(DateFormat.FULL,
                DateFormat.FULL,locale);
        return df.format(d);
    }
    
    
}
