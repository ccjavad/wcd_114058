<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <%
            //            0    1   2   3   4   5   6   7   8
            int[] arr = { 33, 44, 55, -1, -2, -3, -4, -5, -6 };
            pageContext.setAttribute("arr", arr);
        %>
        
        <c:forEach items="${arr}">
            wdh 
        </c:forEach>
        <br/>
        
        <c:forEach items="${arr}" var="x">
            ${x} 
        </c:forEach>
        <hr/>
        
        <c:forEach items="${arr}" var="x" begin="1" end="7" step="2" varStatus="status">
            <b>${status.count}.</b>
            ${x} <br/>
        </c:forEach>
        
    </body>
</html>
