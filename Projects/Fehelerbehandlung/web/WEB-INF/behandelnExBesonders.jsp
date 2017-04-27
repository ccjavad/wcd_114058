<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%-- mit isErrorPage wird nur das implizite Objekt 
'exception' für Scriptlets aktiviert --%>
<%@page isErrorPage="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Sonderbehandlung für NumberFormatException</h1>
        
        exception: <%= exception %> <br/>
        
        exception findet man auch ohne scriptlets: ${pageContext.exception} <br/>
        
    </body>
</html>
