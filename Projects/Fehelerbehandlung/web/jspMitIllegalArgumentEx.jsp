<%-- 
    Document   : jspMitIllegalArgumentEx
    Created on : 27.04.2017, 08:17:58
    Author     : apatrin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <%
            if(true) {
                throw new IllegalArgumentException("test IAE") {};
            }
        %>
        
    </body>
</html>
