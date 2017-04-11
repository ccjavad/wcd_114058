<%-- 
    Document   : operatorenArithmetische
    Created on : 11.04.2017, 11:38:32
    Author     : apatrin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <h1>Arithmetische</h1>
        <h2>Alias-Namen (s. Buch)</h2>
        
        \${8 / 2} = ${8 / 2} <br/>
        \${8 div 2} = ${8 div 2} <br/>
        
        <%
            // int x = 4 / 0; 
            double x = 8.0 / 0; //Infinity
        %>
        Infinity: ${8 / 0} <br/>
        
        
        \${8 % 2} = ${8 % 2} <br/>
        \${8 mod 2} = ${8 mod 2} <br/>
        
        <%--
            ArithmeticException: 
                ${8 mod 0} <br/>
        --%>
        
        <hr/>
        
        <% pageContext.setAttribute("x", 5); %>
        \${2 * x} = ${2 * x} <br/>
        
        \${2 * nichtda} = ${2 * nichtda} <br/>
        \${2 * null} = ${2 * null} <br/>
        
        
        <hr/>
        
        \${3 * 5} = ${3 * 5} <br/>
        \${3 * '5'} = ${3 * '5'} <br/>
        \${3 * "5"} = ${3 * "5"} <br/>

        <% pageContext.setAttribute("x", 5); %>
        \${3 * x} = ${3 * x} <br/>

        <% pageContext.setAttribute("x", "5"); %>
        \${3 * x} = ${3 * x} <br/>
        
        <% 
//            long var = Long.parseLong("Fünf"); //NumberFormatException
            pageContext.setAttribute("x", "Fünf"); 
        %>
        
        <%--
            NumberFormatException:
                ${3 * x}
        --%>
        
    </body>
</html>
