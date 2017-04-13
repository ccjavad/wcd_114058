<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.TreeMap"%>
<%@page import="java.util.Map"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <%
            Map<Integer, String> map = new TreeMap<>();
            map.put(1, "Mo");
            map.put(2, "Di");
            map.put(3, "Mi");
            pageContext.setAttribute("map", map);
        %>
        
        <c:forEach items="${map}" var="element">
            ${element.key} = ${element.value}<br/>
        </c:forEach>
            
            
        <h3>Alle Request-Parameter ausgeben</h3>
        
        <a href="forEach_mit_Map.jsp?color=red&color=orange&size=big">
            sende zum Testen Request-Parameter</a>
        <br/>
        
        <h4>request.getParameterMap</h4>
        
        request.getParameterMap: <%= request.getParameterMap() %> <br/>
        <%
            pageContext.setAttribute("paramMap", request.getParameterMap());
        %>
        
        <c:forEach items="${paramMap}" var="element">
            <b>${element.key}</b>: 
            <c:forEach items="${element.value}" var="value">
                ${value}, 
            </c:forEach>
            
            <br/>
        </c:forEach>
        

        <h4>\${paramValues}</h4>            
        paramValues: ${paramValues} <br/>
        
        <c:forEach items="${paramValues}" var="element">
            <b>${element.key}</b>: 
            <c:forEach items="${element.value}" var="value">
                ${value}, 
            </c:forEach>
            
            <br/>
        </c:forEach>
        
    </body>
</html>
