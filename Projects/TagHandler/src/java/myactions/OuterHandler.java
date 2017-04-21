package myactions;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class OuterHandler extends SimpleTagSupport {

    private String message;

    public void setMessage(String message) {
        this.message = message;
    }
    
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        out.print("OuterHandler. <br/>");
        
        JspFragment body = getJspBody();
        if(body!=null) {
            body.invoke(null);
        }
        
        if(message!=null) {
            out.print("OuterHandler hat folgende Nachricht erhalten: " + message + "<br/>");
        }
    }
    
}
