package myactions;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class InnerHandler extends SimpleTagSupport {

    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        out.print("InnerHandler. <br/>");
        
        JspTag parent = getParent();
        if(parent instanceof OuterHandler) {
            OuterHandler outer = (OuterHandler)parent;
            outer.setMessage("Hallo aus dem InnerHandler");
        }
        
    }
    
}
