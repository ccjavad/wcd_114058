<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Vergleichsoperatoren</h1>
        <h2>Alias-Namen (s. das Buch, S. 396)</h2>
        
        \${ 2 == 1+1 } = ${ 2 == 1+1 } <br/>
        \${ 2 eq 1+1 } = ${ 2 eq 1+1 } <br/>
        
        <%
            String s1 = new String("A");
            String s2 = new String("A");
            out.println("Java. s1 == s2: " + (s1 == s2));
            out.print("<br/>");
            out.println("Java. s1.equals(s2): " + s1.equals(s2));
            
            pageContext.setAttribute("s1", s1);
            pageContext.setAttribute("s2", s2);
        %>
        <br/>
        
        (wie die equals) \${ s1 == s2 }: ${ s1 == s2 } <br/>
        
        
        <hr/>
        \${ 1 < 22 }: ${ 1 < 22 } <br/>
        \${ 1 < "22" }: ${ 1 < "22" } <br/>
        
        \${ 1 < nichtda }: ${ 1 < nichtda } <br/>
        \${ -1 < nichtda }: ${ -1 < nichtda } <br/>
        \${ 0 == nichtda }: ${ 0 == nichtda } <br/>
        
        
        
    </body>
</html>
