<%@page import="java.util.Arrays"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Attribute</h1>
        
        <h3>Erzeugen mit setAttribute</h3>
        <%
            application.setAttribute("att", Arrays.asList("a", "b", "c"));
            session.setAttribute("att", new Date());
            request.setAttribute("att", "req-scope-value");
            pageContext.setAttribute("att", 33);
            
            //Extra in JspContext:
            pageContext.setAttribute("att", "Habe das Date ersetzt", PageContext.SESSION_SCOPE);
        %>
        
        att (Application-Scope): <%= application.getAttribute("att") %> <br/>
        att (Session-Scope): <%= session.getAttribute("att") %> <br/>
        att (Request-Scope): <%= request.getAttribute("att") %> <br/>
        att (Page-Scope): <%= pageContext.getAttribute("att") %> <br/>
        
        att (Application-Scope über pageContext): 
            <%= pageContext.getAttribute("att", PageContext.APPLICATION_SCOPE) %> <br/>
        
        <h3>Löschen mit removeAttribute</h3>
        
        <%
//            application.removeAttribute("att");
//            session.removeAttribute("att");
//            request.removeAttribute("att");

            //Achtung! Die removeAttribute(String) aus der JspContect
            // löscht das Atrtibut 'att' aus ALLEN Scopes!!!
//            pageContext.removeAttribute("att");
            
            pageContext.removeAttribute("att", PageContext.PAGE_SCOPE);
        %>
        
        att (Application-Scope): <%= application.getAttribute("att") %> <br/>
        att (Session-Scope): <%= session.getAttribute("att") %> <br/>
        att (Request-Scope): <%= request.getAttribute("att") %> <br/>
        att (Page-Scope): <%= pageContext.getAttribute("att") %> <br/>
        
        <h1>Wichtig: findAttribute</h1>
        att: <%= pageContext.findAttribute("att") %> <br/>
        
    </body>
</html>
