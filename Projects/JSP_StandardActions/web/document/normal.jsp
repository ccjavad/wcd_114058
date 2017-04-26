<%-- 
    Scripting-Kommentar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <%@include file="toInclude.html" %>
        
        <jsp:include page="toInclude.html" />
        
        <% int x = 3; %>
        
        <%= x %>
        
        <%! int y = 5; %>
        
    </body>
</html>
