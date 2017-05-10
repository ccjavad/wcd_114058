<%@page import="javax.annotation.Resource"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <%!
            /*
            <env-entry>
                <env-entry-name>kursname</env-entry-name>
                <env-entry-type>java.lang.String</env-entry-type>
                <env-entry-value>OCEJWCD</env-entry-value>
            </env-entry>
            */
            
            @Resource(name = "kursname")
            private String kursname; //Java Attribut in einer Declaration
        %>
        
        kursname: <%= kursname %>
        
    </body>
</html>
