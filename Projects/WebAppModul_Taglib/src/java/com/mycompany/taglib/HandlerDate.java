package com.mycompany.taglib;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class HandlerDate extends SimpleTagSupport {

    @Override
    public void doTag() throws JspException, IOException {
        String result = DateFormat.getDateInstance().format(new Date());
        getJspContext().getOut().print(result);
    }
    
}
