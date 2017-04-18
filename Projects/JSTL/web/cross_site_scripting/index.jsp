<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Cross-site scripting</h1>
        
        <pre>
            1. Der User A darf seine Texte erstellen (textVerfassen.jsp), 
                die in der Anwendung (auf dem Server) gespeichert werden 
                (s. das Servlet 'SaveUserTextServlet')

            2. Der User B kann den text von User A sehen (textZeigen.jsp)
        </pre>
        
        
        <a href="textVerfassen.jsp">Der User A erstellt seinen Text</a>
        <br/>
        
        <a href="textZeigen.jsp">der User B sieht sich den Text von User A an</a>
        
    </body>
</html>
