package mycore;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ForHandler extends SimpleTagSupport {
    
    private int begin, end, step=1;

    private String var;
    
    public void setBegin(int begin) {
        this.begin = begin;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public void setVar(String var) {
        this.var = var;
    }

    public void setStep(int step) {
        this.step = step;
    }
    
    @Override
    public void doTag() throws JspException, IOException {
        
        JspFragment body = getJspBody();
        if(body!=null) {
            for (int i = begin; i <= end; i += step) {
                
                if(var!=null) {
                    getJspContext().setAttribute(var, i);
                }
                
                body.invoke(null);
            }
            
            if(var!=null) {
                getJspContext().removeAttribute(var, PageContext.PAGE_SCOPE);
            }
        }
        
    }
    
}
