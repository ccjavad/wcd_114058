<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <%
            List<String> woche = new ArrayList<>();
            woche.add("mo");
            woche.add("di");
            woche.add("mi");
            
            pageContext.setAttribute("woche", woche);
        %>
        
        <c:forEach items="${woche}" var="wochentag">
            ${wochentag} <br/>
        </c:forEach>
        
    </body>
</html>
