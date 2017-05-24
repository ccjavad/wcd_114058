<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="login">Einloggen</a> 
        oder 
        <a href="signin.jsp">Account erstellen</a>
        
        
        <hr/>
        
        <pre>

     Die Anwendung:

        - Es gibt zwei Rollen: 'kunde' und 'administrator'
        - Neue User können sich als Kunden registrieren (signing.jsp)
        - Administratoren und registrierte Kunden können sich einloggen und ausloggen
          !!!Einloggen/Ausloggen wurde mit Webcontainer-Security realisiert. Auth-Methode: FORM
        - Beim Einloggen wird der User abhängig von seiner Rolle zur 'admin.jsp'
          oder zur 'kunde.jsp' weitergeleitet
        - Administratoren können die Liste aller Accounts sehen (admin.jsp). 
          Die Liste wird automatisch aktualisiert

    Vorbereitung (Admin):

        - Mysql-Server installieren
        - Datenbank anlegen, s. Skript 'META-INF/admin_create_db.sql'
            !!! Datenbanknamen, Tabellennamen und Spaltennamen bitte im Skript nachschlagen
            !!! Mit dem Skript werden 2 Test-Kunden und 1 Test-Administrator angelegt
        - Anwendungskonfiguration für Tomcat evtl. anpassen (META-INF/context.xml)
            !!! Normaleweise nicht nötig. Die Security-Realm ist im Tag 'Realm' konfiguriert

    Schwächen der Anwendung:

        - Kein Caching der Userdaten. Die Ansicht für Administratoren 
         (s. admin.jsp) fragt jede 2 Sek. danach ob die Liste aktualisiert wurde
         (evtl. ServiceLocator)
        - Die Ansicht für Administratoren zeigt die komplette Accounts-Liste: 
          ein Problem mit großen Listen
        - SQL-Injections möglich. Usernamen und Passwörter werden ohne Kontrollen
          in die Datenbank übernommen
        - SQL-Transaktionen fehlen
        - Fehlerbehandlung fehlt meistens
        ...

        </pre>
        
    </body>
</html>
