package mycore;

import java.io.IOException;
import java.util.Collection;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ForEachHandler extends SimpleTagSupport{
    
    public static class Counter {
        private int count = 1;
        
        public int getCount() {
            return count;
        }
        
        public void increment() {
            count++;
        }
    }
    
    //-----------------------------------------------
    private Collection<?> items;
    private String var;
    private String varStatus;

    public void setItems(Collection<?> items) {
        this.items = items;
    }

    public void setVar(String var) {
        this.var = var;
    }

    public void setVarStatus(String varStatus) {
        this.varStatus = varStatus;
    }
    
    @Override
    public void doTag() throws JspException, IOException {
        
        if(items==null) {
            return;
        }
        
        Counter counter = new Counter();
        
        for (Object item : items) {
            if(var!=null) {
                getJspContext().setAttribute(var, item);
            }
            if(varStatus!=null) {
                getJspContext().setAttribute(varStatus, counter);
            }
            
            JspFragment body = getJspBody();
            if(body!=null) {
                body.invoke(null);
            }
            
            counter.increment();
        }
        
        if(var!=null) {
            getJspContext().removeAttribute(var, PageContext.PAGE_SCOPE);
        }
        if(varStatus!=null) {
            getJspContext().removeAttribute(varStatus, PageContext.PAGE_SCOPE);
        }
        
    }

}
