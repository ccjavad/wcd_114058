package mycore;

import java.io.IOException;
import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class IfHandler extends SimpleTagSupport {
    
    private boolean test;
    private String var;
    private int scope = PageContext.PAGE_SCOPE;
    
    public void setTest(boolean test) {
        this.test = test;
    }
    
    public void setVar(String var) {
        this.var = var;
    }
    
    public void setScope(String scope) {
        switch(scope) {
            case "page":
                this.scope = PageContext.PAGE_SCOPE;
                break;
            case "request":
                this.scope = PageContext.REQUEST_SCOPE;
                break;
            case "session":
                this.scope = PageContext.SESSION_SCOPE;
                break;
            case "application":
                this.scope = PageContext.APPLICATION_SCOPE;
                break;
            default:
                throw new IllegalArgumentException("Scope not supported: " + scope);
        }
    }
    
    /*
        <mc:if test="${1+1==2}" var="erg2">
            4. mc:if. body. erg2 = ${erg2} <br/>
        </mc:if>
        4. mc:if. Nach dem body. erg2 = ${erg2} <br/>
    
    Transliert:
    
            
        SimpleTagSupport a = new IfHandler();
        a.setJspContext(pageContext);
        a.setTest( auswerten("${1+1==2}") );
        a.setVar("erg2");
    
        JspFragment body = new JspFragment() {
            public void invoke(Writer w) {
                out.write("4. mc:if. body. erg2 = ");
                out.print( auswerten("${erg2}") );
                out.write("<br/>");
            }
        };
    
        a.setJspBody(body);
        a.doTag();
    */
    
    @Override
    public void doTag() throws JspException, IOException {
        if(var != null) {
            JspContext jspContext = getJspContext();
            //jspContext.setAttribute(var, test);
            jspContext.setAttribute(var, test, scope);
        }
        
        if(test) {
            //body auswerten
            JspFragment body = getJspBody();
            if(body!=null) {
                body.invoke(null);
            }
        }
    }
}
