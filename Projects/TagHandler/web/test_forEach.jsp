<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="mc" uri="/WEB-INF/mycore" %>
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
            List<String> list = new ArrayList<>();
            list.add("mo");
            list.add("di");
            list.add("mi");
             
            pageContext.setAttribute("list", list);
        %>
        
        <c:forEach items="${list}" var="element" varStatus="status">
            ${status.count}. ${element} <br/>
        </c:forEach>
        <br/>
        Nach der c:forEach: ${element}
            
        <hr/>
        
        <mc:forEach items="${list}" var="element" varStatus="status">
            ${status.count}. ${element} <br/>
        </mc:forEach>
        <br/>
        Nach der c:forEach: ${element}
            
            
    </body>
</html>
