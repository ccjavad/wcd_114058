package gb.web;

import java.util.Date;
import java.util.Objects;

public class Entry {

    private final String userName, userText;
    
    private final Date date;

    public Entry(String userName, String userText) {
        this.userName = userName;
        this.userText = userText;
        
        this.date = new Date();
    }

    public Date getDate() {
        return date;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserText() {
        return userText;
    }

    @Override
    public boolean equals(Object obj) {
        if(! (obj instanceof Entry) ) {
            return false;
        }
        
        Entry e2 = (Entry)obj;
        
        return Objects.equals(userName, e2.userName) 
                && Objects.equals(userText, e2.userText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, userText);
    }
    
}
