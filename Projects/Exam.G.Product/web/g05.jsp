
<%
    //Das Servlet macht es:
    session.setAttribute("product", new beans.Product("Milch", 20));
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <%--
            A: 
            <%= product.getName() %>
        --%>
        
        <%--
            B: suche im PAGE_SCOPE
        
            <jsp:useBean id="product" class="beans.Product"/>
            <%= product.getName() %>
        
        --%>
        
        <%--
            D:
        --%>
        
        <jsp:useBean id="product" type="beans.Product" scope="session"/>
        <%= product.getName() %>
        
    </body>
</html>
