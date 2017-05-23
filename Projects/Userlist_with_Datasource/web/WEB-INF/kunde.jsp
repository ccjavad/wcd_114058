<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <script>
        </script>
    </head>
    <body>
        <c:set var="userName" value="${pageContext.request.userPrincipal.name}"/>
        Hallo Kunde ${userName} (<a href="logout">logout</a>)
        
    </body>
</html>
