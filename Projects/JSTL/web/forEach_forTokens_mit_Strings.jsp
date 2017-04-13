<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <c:forEach items="mo,di,mi" var="token">
            ${token} <br/>
        </c:forEach>
            
        <hr/>
            
        <c:forTokens items="mo,di,mi" var="token" delims=",">
            ${token} <br/>
        </c:forTokens>  
        
        <hr/>
            
        <c:forTokens items="mo di mi" var="token" delims=" ">
            ${token} <br/>
        </c:forTokens>  
        
            
        <hr/>
        <% 
            pageContext.setAttribute("str", "Mo,Di,Mi");
        %>
        <c:forTokens items="${str}" var="token" delims=",">
            ${token} <br/>
        </c:forTokens>  
        
    </body>
</html>
