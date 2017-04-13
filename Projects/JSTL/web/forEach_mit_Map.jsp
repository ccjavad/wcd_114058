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
        
    </body>
</html>
