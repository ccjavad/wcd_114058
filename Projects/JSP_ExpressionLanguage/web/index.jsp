<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Primäre Aufgabe von EL: Suche nach einem Attribut mit einem Identifier</h1>
        
        ${anton}
        
        <%
            Object obj = pageContext.findAttribute("anton");
            if(obj==null) {
                obj = "";
            }
            
            out.print(obj);
        %>
        
        <h2>Identifier:</h2>
        
        - Regeln wie in Java: bestehen aus Buchstaben, Untestrich... <br/>
        - Reservirte Schlüßelwörter aus Java und EL sind keine Identifier <br/>
        Also falsch: int, class, (java) /  div, empty (EL) <br/>
        - Auch die impliziten EL-Objekte sind keine Identifier (pageContext...)
        
        
        <h2>Literale</h2>
        - Ganzzahligen Literale: ${12} <br/>
        - Gleitkomma-Literale: ${12.5} <br/>
        - String-Literale: ${"text1"} oder ${'text1'} <br/>
        - Boolean-Literale (res. Schlüßelwörter): ${true} oder ${false} <br/>
        
        
        <h2>Implizite Objekte</h2>
        pageContext, pageScope...
        
        
        <h2>Operatoren</h2>
        s. weitere Beispiele
        
        
        <h2>Funtionen</h2>
        s. weitere Beispiele
        
        
        <h2>EL 'ausschalten'</h2>
        
        <h3>Im DD:</h3>
        
        <%--
            <jsp-config>
                <jsp-property-group>
                    <url-pattern>index.jsp</url-pattern>

                    <el-ignored>true</el-ignored>
                </jsp-property-group>
            </jsp-config>
        --%>

        <h3>mit der page-Directive</h3>
        <%@page isELIgnored="true" %>
        
        1 + 3 = ${1 + 3} <br/>
        
        
        
    </body>
</html>
