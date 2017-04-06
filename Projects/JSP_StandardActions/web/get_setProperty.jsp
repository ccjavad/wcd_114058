<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            pageContext.setAttribute("d1", new Date());
        %>
        d1.time = ${d1.time} <br/>
        
        
        <jsp:useBean id="d1" type="java.util.Date"/>
        getProperty: <jsp:getProperty name="d1" property="time"/> <br/>
        
        <jsp:setProperty name="d1" property="time" value="0"/>
        getProperty: <jsp:getProperty name="d1" property="time"/> <br/>
        
        
    </body>
</html>
