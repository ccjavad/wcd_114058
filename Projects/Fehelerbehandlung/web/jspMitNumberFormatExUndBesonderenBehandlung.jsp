<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="WEB-INF/behandelnExBesonders.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        exception-test:
        
        <% 
            Integer.parseInt("NumberFormatException, die aber besonders behandelt wird");
        %>
        
    </body>
</html>
