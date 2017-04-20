package mycore;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class IfHandler extends SimpleTagSupport {
    
    private boolean test;
    
    public void setTest(boolean test) {
        this.test = test;
    }
    
    @Override
    public void doTag() throws JspException, IOException {
        
        if(test) {
            //body auswerten
            JspFragment body = getJspBody();
            body.invoke(null);
        }
        
    }
}
