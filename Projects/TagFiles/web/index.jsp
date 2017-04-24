<%@page contentType="text/html" pageEncoding="UTF-8"  %>
<%@taglib prefix="mtf" tagdir="/WEB-INF/tags/" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <pre>
            - Tag-File ist die Schablone für SimpleTagSupport
            
            - Der Name der Tag-Datei ist der name der neuen Action
            - Die Tag-Datei muss im /WEB-INF/tags/ oder einem weiteren Unterordner liegen
                - Alle Tag-Dateien aus einem Verzeichnis (aber nicht aus den Unterverzeichnissen)
                  bilden eine Bibliothek

            - taglib-Directive mit 'prefix' und 'tagdir' einsetzen
        </pre>
        
        date: <mtf:date/> <br/>
        
        <hr/>
        
        <mtf:vergleichMitJsp/>
        
        
        
    </body>
</html>
