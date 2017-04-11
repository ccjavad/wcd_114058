<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Logische</h1>
        <h2>Alias-Namen (s. Buch)</h2>
        
        \${ true && false } = ${ true && false } <br/>
        \${ true and false } = ${ true and false } <br/>
        
        <hr/>
        <%
            Boolean.parseBoolean("TrUe"); //liefert true
        %>
        
        \${true && nichtda} = ${true && nichtda} <br/>
        \${!nichtda} = ${!nichtda} <br/>
        \${not nichtda} = ${not nichtda} <br/>
        
        \${"hallo" && true} = ${"hallo" && true} <br/>
        
        <hr/>
        <%-- nicht in der Prüfung: --%>
        
        \${empty null} = ${empty null} <br/>
        \${empty nichtda} = ${empty nichtda} <br/>
        
        <%
            //ArrayList hat isEmpty-Methode
            pageContext.setAttribute("list", new ArrayList<>());
            pageContext.setAttribute("date", new Date());
        %>
        \${empty list} = ${empty list} <br/>
        \${empty date} = ${empty date} <br/>
        
    </body>
</html>
