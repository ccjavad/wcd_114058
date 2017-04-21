<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="mc" uri="/WEB-INF/mycore" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <c:forEach begin="1" end="${1+2}">
            1. c:forEach
        </c:forEach>
        <br/>
        
        <mc:for begin="1" end="${1+2}">
            1. mc:for 
        </mc:for>
        <br/>
        
        <h3>2.</h3>
        <c:forEach begin="1" end="3" var="i">
            c:forEach i=${i} 
        </c:forEach>
        <br/>
        c:forEach. Nach dem Body ist i weg: ${i} <br/>
        
        <br/>
        
        <mc:for begin="1" end="3" var="i">
            mc:for i=${i} 
        </mc:for>
        <br/>
        mc:for. Nach dem Body ist i weg: ${i} <br/>
        
        
        
        <h3>3.</h3>
        <c:forEach begin="1" end="9" step="2" var="i">
            ${i} 
        </c:forEach>
        <br/>
        
        <mc:for begin="1" end="9" step="2" var="i">
            ${i} 
        </mc:for>


        
    </body>
</html>
