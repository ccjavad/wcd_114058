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
//            if(true) {
//                
//            }
        %>
        
        <c:choose>
            <c:when test="${true}">
                1. when (läuft) <br/>
            </c:when>
        </c:choose>
                

        <%
            if(1+1==3) {
                //...
            } else if(2*2==4) {
                //...
            }
        %>
        <c:choose>
            <c:when test="${1+1==3}">
                2.1 when <br/>
            </c:when>
            <c:when test="${2*2==4}">
                2.2 when (läuft)<br/>
            </c:when>
        </c:choose>

                
                
        <%
            int x = 2;

            if(x==1) {
                
            } else if(x==2) {
                //läuft
            } else if(x*2==4) {
                //läuft nicht
            }
        %>
        
        <% pageContext.setAttribute("x", 2); %>
        <c:choose>
            <c:when test="${x==1}">
                3.1 when <br/>
            </c:when>
            <c:when test="${x==2}">
                3.2 when (läuft)<br/>
            </c:when>
            <c:when test="${x*2==4}">
                3.3 when <br/>
            </c:when>
        </c:choose>
        
                
                
        <%
            x = 3;
            if(x < 0) {
                
            } else {
                //läuft
            }
        %>
        
        <c:choose>
            <c:when test="${x < 0}">
                4.1 when <br/>
            </c:when>
            <c:otherwise>
                4. otherwise (läuft)<br/>
            </c:otherwise>
        </c:choose>
    </body>
</html>
