<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>set mit var. Einfache neue Attribute erzeugen</h1>
        
        <c:set var="x" value="Java ist toll" />
        <c:set var="x" value="Java ist toll" scope="page"/>
        
        x = ${x} <br/>
        x-Typ: ${x["class"]} <br/>
        
        <c:set var="x" value="${12}" />
        x-Typ: ${x["class"]} <br/>
        
        <c:set var="x" value="${12.55}" />
        x-Typ: ${x["class"]} <br/>
        
        <c:set var="x" value="${3==4}" />
        x-Typ: ${x["class"]} <br/>
        
        <%--
            nicht empfohlen, obwohl es geht:
        
            <c:set var="x" value="<%= new java.util.Date() %>" />
            x-Typ: ${x["class"]} <br/>
        --%>


        <h1>set mit var. Neue (einfache) Namen für vorhandene Elemente erzeugen</h1>
        <% pageContext.setAttribute("com.mycompany.mylib.myatt", 44); %>
        
        att: ${pageScope["com.mycompany.mylib.myatt"]} <br/>
        
        <c:set var="att" value='${pageScope["com.mycompany.mylib.myatt"]}' />
        att: ${att} <br/>
        
        <br/>
        <c:set var="sid" value="${pageContext.session.id}"/>
        sid: ${sid} <br/>
        
        
        
        <h1>set mit target mit Beans</h1>
        <h1>set mit target mit Maps</h1>
        
        
    </body>
</html>
