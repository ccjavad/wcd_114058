package memory.web;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class TagHandlerSync extends SimpleTagSupport {
    
    private Object monitor;

    public void setMonitor(Object monitor) {
        this.monitor = monitor;
    }
    
    @Override
    public void doTag() throws JspException, IOException {
        
        JspFragment body = getJspBody();
        if(body!=null) {
            synchronized(monitor) {
                body.invoke(null);
            }
        }
    }
    
}
