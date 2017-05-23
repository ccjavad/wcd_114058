<%-- 
    Document   : signin
    Created on : 22.05.2017, 16:06:48
    Author     : apatrin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Account erstellen:</h1>
        
        <form action="signin" method="post">
            Namen wählen: <input name="userName"/>
            Passwort wählen: <input name="userPassword" type="password"/>
            <input type="submit" value="Account erstellen"/>
        </form>
        
        <c:if test="${not empty pageContext.exception}">
            <hr/>
            <b>Fehler! ${pageContext.exception.message}</b>
        </c:if>
        
    </body>
</html>
