
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
            
            
        <%--
            <c:if></c:if>
            <mc:if/>
        --%>
        
        
        <c:if test="${1+1 == 2}">
            3. c:if. body<br/>
        </c:if>
        
        <mc:if test="${1+1 == 2}">
            3. mc:if. body<br/>
        </mc:if>
            
            
        <hr/>
            
        <c:if test="${1+1==2}" var="erg">
            4. c:if. body. erg = ${erg} <br/>
        </c:if>
        4. c:if. Nach dem body. erg = ${erg} <br/>
        
        <mc:if test="${1+1==2}" var="erg2">
            4. mc:if. body. erg2 = ${erg2} <br/>
        </mc:if>
        4. mc:if. Nach dem body. erg2 = ${erg2} <br/>
        
        
        <hr/>
        <c:if test="false" var="erg" scope="session"></c:if>
        5. c:if. sessionScope.erg = ${sessionScope.erg} <br/>
            
        <mc:if test="false" var="erg2" scope="session"></mc:if>
        5. mc:if. sessionScope.erg2 = ${sessionScope.erg2} <br/>
            
    </body>
</html>
