<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% //response.setContentType("text/html;charset=UTF-8"); %>

<%--
<%@page errorPage="fehlerbehandlungsjsp.jsp" %>
<%@page isErrorPage="false" %>
--%>

<%@page import="java.util.Date" %>

<%@page isELIgnored="false" %>

<%-- 
    mit isThreadSafe=false implementiert die JSP-Klasse javax.servlet.SingleThreadModel

    Bitte nie auf false setzen!!!
--%>
<%@page isThreadSafe="true" %>


<%--
    mit session=false wird kein implizites Objekt 'session' angelegt
--%>
<%@page session="false" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
