<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% //pageContext.setAttribute("d1", new Date()); %>
        
        <jsp:useBean id="d1" class="java.util.Date">
            <jsp:setProperty name="d1" property="time" value="0"/>
        </jsp:useBean>
        
        d1 = ${d1} <br/>
        
        
        <jsp:useBean id="d2">
            <jsp:attribute name="class">java.util.Date</jsp:attribute>
            <jsp:body>
                <jsp:setProperty name="d2" property="time" value="0"/>
            </jsp:body>
        </jsp:useBean>
        
        d2 = ${d2}
            
    </body>
</html>
