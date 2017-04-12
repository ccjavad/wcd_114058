<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="points" uri="ein eindeutiger beliebiger String. Hier für die Lib mit Point-Funktionen" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>EL-Funktionen</h1>
        
        <pre>
            1. public Klasse
            2. public static Methode
            3. TLD-Datei im WEB-INF oder Unterverzeichnis von WEB-INF
            4. EL-Funktion in der TLD-Datei deklarieren
            5. taglib-Directive
            6. EL-Funktion mit dem gewählten Präfix aufrufen
        </pre>
        
        random: ${ points:random() } <br/>
        
        <jsp:useBean id="p1" class="utils.Point"/>
        p1: ${p1} <br/>
        
        ${points:move(p1, 50, 77)}
        p1 nach move: ${p1} <br/>
        
        ${ points:createAsAttribute(30, 12, "p2", pageContext) }
        p2: ${p2} <br/>
        
        ${ points:setAsAttribute(p2, "p3", pageContext) }
        p3: ${p3} <br/>
        
        <hr/>
        
        ${ points:setAsAttribute( points:random(), "p4", pageContext) }
        p4 = ${p4}
        
        
    </body>
</html>
