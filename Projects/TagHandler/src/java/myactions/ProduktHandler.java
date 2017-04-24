package myactions;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.DynamicAttributes;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ProduktHandler extends SimpleTagSupport implements DynamicAttributes {
    
    private String name;
    private Map<String, Object> dynAtts = new TreeMap<>();

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setDynamicAttribute(String uri, String localName, Object value) throws JspException {
        dynAtts.put(localName, value);
    }
    
    @Override
    public void doTag() throws JspException, IOException {
        
        JspWriter out = getJspContext().getOut();
        out.println(name + ": " + dynAtts + "<br/>");
    }
    
}
