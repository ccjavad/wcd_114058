<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <jsp:include page="copyright.jsp"/> <br/>
        <jsp:include page="copyright.jsp"/> <br/>
        
        <jsp:include page="title.html"/> <br/>
        
        <hr/>
        
        <%--
            Copy-Paste aus copyright.jsp hierher:
        
            <%@page import="java.time.LocalDate"%>
            Copyright 
            <% 
               int year = LocalDate.now().getYear();
            %>
            <%= year %>
        --%>
        <%@include file="copyright.jsp" %>
        <%--
        <%@include file="copyright.jsp" %>
        --%>
        
    </body>
</html>
