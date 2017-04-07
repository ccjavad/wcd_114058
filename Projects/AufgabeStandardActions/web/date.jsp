<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <jsp:useBean id="datum" class="beans.DateBean"/>
        <%--
        <jsp:setProperty name="datum" property="date" param="date"/>
        <jsp:setProperty name="datum" property="language" param="lang"/>
        <jsp:setProperty name="datum" property="dateStyle" param="dateStyle"/>
        <jsp:setProperty name="datum" property="timeStyle" param="timeStyle"/>
        --%>
        
        <jsp:setProperty name="datum" property="*"/>
        <jsp:setProperty name="datum" property="language" param="lang"/>
        
        
        <jsp:getProperty name="datum" property="dateFormatted"/>
        
    </body>
</html>
