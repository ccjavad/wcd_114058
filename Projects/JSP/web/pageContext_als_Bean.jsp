<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        
        pageContext: <%= pageContext %> <br/>

        <h3>request</h3>
        <%= pageContext.getRequest() %> <br/>
        
        <h3>response</h3>
        <%= pageContext.getResponse() %> <br/>
        
        <h3>out</h3>
        <%= pageContext.getOut() %>
        
        <h3>application</h3>
        <%= pageContext.getServletContext() %>
        
        <h3>config</h3>
        <%= pageContext.getServletConfig() %>
        
        <h3>exception</h3>
        <%= pageContext.getException() %>
        
        <h3>session</h3>
        <%= pageContext.getSession() %>
        
        
        
    </body>
</html>
