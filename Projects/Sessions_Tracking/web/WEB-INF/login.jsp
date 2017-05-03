<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:url var="target" value="j_security_check"/>
        <form action="${target}" method="post">
            Name: <input name="j_username"/>
            Passwort: <input type="password" name="j_password"/>
            <input type="submit" value="login"/>
        </form>
    </body>
</html>
