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
        <c:if test="true">
            1. c:if. body<br/>
        </c:if>
        
        <mc:if test="true">
            1. mc:if. body<br/>
        </mc:if>
            
            
        <c:if test="false">
            2. c:if. body<br/>
        </c:if>
        
        <mc:if test="false">
            2. mc:if. body<br/>
        </mc:if>
    </body>
</html>
