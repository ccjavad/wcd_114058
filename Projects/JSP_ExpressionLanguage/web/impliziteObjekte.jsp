<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <h1>pageContext (eine Bean)</h1>
        
        Expression. pageContext: <%= pageContext %> <br/>
        EL. pageContext: ${pageContext} <br/>
        
        <hr/>
        über pageContext zu HttpSession und zu der Session-ID: 
            ${pageContext.session.id} <br/>
            
        <hr/>
        Expression. Auf ein Attribut im Page-Scope zugreifen: 
            <%= pageContext.getAttribute("att") %> <br/>
            
        EL (geht, nicht in der Prüfung!). Auf ein Attribut im Page-Scope zugreifen: 
            ${ pageContext.getAttribute("att") }
        
            
            
        
        <h1>pageScope, requestScope, sessionScope, applicationScope 
            - Maps mit den Attributen</h1>
            
        <% 
            pageContext.setAttribute("att", "Heute ist Dienstag");
            session.setAttribute("att", 305);
        %>
        att aus dem Page-Scope: \${att} = ${att} <br/>
        att aus dem Session-Scope: \${sessionScope.att} = ${sessionScope.att} <br/>

        
        <%
            pageContext.setAttribute("com.mycompany.myatt", "Mittwoch");
        %>
        \${pageScope["com.mycompany.myatt"]} = ${pageScope["com.mycompany.myatt"]} <br/>
        
        
        
        <h1>cookie - Map (String to Cookie)</h1>
        Map (String to Cookie): ${cookie} <br/>
        Cookie: ${cookie.JSESSIONID} <br/>
        Cookie-Name: ${cookie.JSESSIONID.name} <br/>
        Cookie-Value: ${cookie.JSESSIONID.value} <br/>
           

        
        <h1>initParam - Map (String to String) mit den Contextparameter aus DD</h1>
        \${initParam["server-ip"]} = ${initParam["server-ip"]} <br/>

        
        
        <h1>header und headerValues - Maps mit den Request-Headers</h1>
        <h2>header: String to String</h2>
        <h2>headerValues: String to String[]</h2>
        
        User-Agent: ${header["user-agent"]} <br/>
        
        String[] mit Values: ${headerValues["user-agent"]} <br/>
        User-Agent: ${headerValues["user-agent"][0]} <br/>
        Nichts: ${headerValues["user-agent"][1]} <br/>
        
        
        
        
        <h1>param und paramValues - Maps mit den Request-Parameter</h1>
        <h2>param (String to String)</h2>
        <h2>paramValues (String to String[])</h2>
        
        <a href="impliziteObjekte.jsp?size=big&color=red&color=orange">test 
            (mehrere Parameter)</a> <br/>
        
        \${param.size} = ${param.size} <br/>
        \${param.color} = ${param.color} <br/>
        
        String[] mit Werten für 'color' = ${paramValues.color} <br/>
        \${paramValues.color[0] = ${paramValues.color[0]} <br/>
        \${paramValues.color[1] = ${paramValues.color[1]} <br/>
        
    </body>
</html>
