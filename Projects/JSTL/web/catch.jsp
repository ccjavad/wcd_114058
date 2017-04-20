<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <c:catch var="fehler">
            ${5%0}
        </c:catch>
        
        <c:if test="${not empty fehler}">
            Fehler! Versuchen Sie es später...
        </c:if>
            
        <hr/>
            
        Attribut fehler ist da: ${fehler}
        
    </body>
</html>
