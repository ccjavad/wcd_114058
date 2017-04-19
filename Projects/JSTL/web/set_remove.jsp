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
            pageContext.setAttribute("att", "Page-Scope-Att");
            request.setAttribute("att", "Request-Scope-Att");
            session.setAttribute("att", "Session-Scope-Att");
            application.setAttribute("att", "Application-Scope-Att");
        %>
        
        att (page): ${pageScope.att} <br/>
        att (request): ${requestScope.att} <br/>
        att (session): ${sessionScope.att} <br/>
        att (application): ${applicationScope.att} <br/>

        <%
            // löscht in ALLEN scopes:
            // pageContext.removeAttribute("att"); löscht alle Attribute
            
            // löscht im angegebenen Scope:
            // pageContext.removeAttribute("att", PageContext.SESSION_SCOPE);
        %>

        <%-- 
           Achtung! 
            - remove ohne scope löscht 'att' aus ALLEN Scopes!
            - remove mit scope löscht 'att' aus dem angegebenen Scope
        --%>
        
        <c:remove var="att" scope="session"/>
            
        <h3>nach remove:</h3>
        
        att (page): ${pageScope.att} <br/>
        att (request): ${requestScope.att} <br/>
        att (session): ${sessionScope.att} <br/>
        att (application): ${applicationScope.att} <br/>
        
        
        <%-- 
           Achtung! 
            set mit var und value=null funktioniert wie remove!
        --%>
        
        <c:set var="att" value="${nichtda}" scope="application"/>
        
        <h3>nach set mit var, value=null, ohne scope</h3>
        
        att (page): ${pageScope.att} <br/>
        att (request): ${requestScope.att} <br/>
        att (session): ${sessionScope.att} <br/>
        att (application): ${applicationScope.att} <br/>
    </body>
</html>
