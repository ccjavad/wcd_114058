package myactions;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class DateHandler extends SimpleTagSupport {

    @Override
    public void doTag() throws JspException, IOException {
        String dateAlsText = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, Locale.GERMANY).format(new Date());

        JspContext jspContext = getJspContext();
        PageContext pageContext = (PageContext)jspContext;
        
        JspWriter out = jspContext.getOut();
        out.print(dateAlsText);
    }
    
}
