<%@page import="java.io.PrintWriter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <h3>request</h3>
        <%= request %>
        
        <h3>response</h3>
        <%= response %>
        
        <h3>out</h3>
        JSP (JspWriter): <%=out%> <br/>
        Servlet (PrintWriter): <%= response.getWriter() %> <br/>
        
        <%
            out.println("Zeile 1<br/>");
            
            PrintWriter pw = response.getWriter();
            pw.println("Zeile 2<br/>"); //Direkt an den PrintWriter (nicht empfohlen)
        %>
        
        
        <h3>application</h3>
        application: <%= application %> <br/>
        im Servlet: <%= getServletContext() %> <br/>
        
        
        <h3>config</h3>
        config: <%= config %> <br/>
        im Servlet: <%= getServletConfig() %>
        
        
        <h3>session</h3>
        <%@page session="true" %>
        session: <%= session %> <br>
        im Servlet: <%= request.getSession() %> 
        
        
        <h3>exception</h3>
        <%@page isErrorPage="true" %>
        exception: <%= exception %>
        
        
        <h3>pageContext</h3>
        pageContext: <%= pageContext %>
        
        
        
    </body>
</html>
