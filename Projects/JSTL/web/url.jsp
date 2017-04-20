<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="<c:url value="url.jsp"/>">aktualisieren</a>
        
        <h1>url führt das Url-Rewriting durch</h1>
        <h2>interne Ressourcen</h2>
        
        <c:url value="interneUrl.html"/> <br/>

        
        <h3>mit var und scope</h3>
        
        <c:url value="interneUrl.html" var="target" scope="page"/>
        <a href="${target}">zur ${target}</a>

        

        <h2>externe Ressourcen</h2>
        <c:url value="http://fremddomain/externeUrl.html"/> <br/>
        
        
    </body>
</html>
