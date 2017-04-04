<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <pre>
        1. JSP (Textdatei) erzeugen und mit der Webanwendung deployen

Bei der ersten Anfrage zu der JSP:

        2. Translieren (zu .java Datei übersetzen)
        3. Kompilieren zu .class Datei

    wie mit jedem Servlet:

        4. Klasse laden
        5. Java-Objekt erzeugen
        6. Servlet initialisieren mit jspInit()
        
Bei der ersten und allen anderen Anfragen zu der JSP:
    
        7. Anfrage mit _jspService() behandeln

Wenn das Servlet zerstört wird:

        8. Aufräumen mit jspDestroy()

        </pre>
        
    <%!
        static {
            System.out.println("--> Klasse wird geladen");
        }

        {
            System.out.println("--> Java-Objekt erzeugen");
        }

        public void jspInit() {
            System.out.println("--> Servlet initialisieren mit jspInit()");
        }

        public void jspDestroy() {
            System.out.println("--> Aufräumen mit jspDestroy()");
        }
    %>
    
    <%
        System.out.println("--> Anfrage mit _jspService() behandeln");
    %>
        
    </body>
</html>
