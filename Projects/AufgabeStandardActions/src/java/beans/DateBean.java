package beans;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

//TODO: Synchronizieren oder zu DateTimeFormatter wechseln
public class DateBean {

    private static final DateFormat FMT_SIMPLE = new SimpleDateFormat("dd.MM.yyyy");
        
    private Date date = new Date();
    private int dateStyle = DateFormat.MEDIUM;
    private int timeStyle = DateFormat.MEDIUM;
    private Locale locale = Locale.GERMANY;
    
    public void setDate(String date) {
        try {
            this.date = FMT_SIMPLE.parse(date);
        } catch(ParseException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void setLanguage(String lang) {
        locale = new Locale(lang);
    }

    public void setDateStyle(String dateStyle) {
        this.dateStyle = parseStyle(dateStyle);
    }

    public void setTimeStyle(String timeStyle) {
        this.timeStyle = parseStyle(timeStyle);
    }
    
    private int parseStyle(String style) {
        switch(style) {
            case "SHORT":
                return DateFormat.SHORT;
            case "MEDIUM":
                return DateFormat.MEDIUM;
            case "LONG":
                return DateFormat.LONG;
            case "FULL":
                return DateFormat.FULL;
        }
        
        throw new IllegalArgumentException("Style not supported: " + style);
    }
    
    public String getDateFormatted() {
        DateFormat df = DateFormat.getDateTimeInstance(dateStyle, timeStyle, locale);
        return df.format(date);
    }
    
    public String getDateFormattedSimple() {
        return FMT_SIMPLE.format(date);
    }
    
}
