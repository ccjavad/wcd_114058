<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="ma" uri="com.mycompany.taglib" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        date: <ma:date/> <br/>
        time: <ma:time/> <br/>
        
        <hr/>
        zeit: <mtf:zeit/>


        <h1>Jar-Datei vorbereiten</h1>
        s. das Unterverzeichnis '_build_jar' aus dem Projekt 'WebAppModul_Taglib'
        
        <h2>Struktur der Jar-Datei</h2>
        <pre>
             /                       (Wurzel der Jar-Datei)
              |- META-INF/
                |- taglib.tld           (TLD)
                |-tags/              (Ordner für Tag-Dateien. Muss sein!)
                    |- zeit.tag         (Tag-Datei)
              |- com/                (Packages mit Klassen)
                |- mycompany/
                    |- taglib/
                        |- HandlerDate.class

        </pre>
        
        
    </body>
</html>
