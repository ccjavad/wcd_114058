<%@page import="javax.annotation.Resource"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        Es gibt ein Webfragment (s. Das Projektverzeichnis '_build_exam_frg')
        mit dem env-entry für die Namen 'x' (x=-7) und 'z'<br/>
        
        Im DD gibt es env-entry für die Namen 'x' (x=505) und 'y' <br/>
        
        Die Frage ist: wird x geladen? Wenn ja, welchen Wert hat x
        
        <%!
            @Resource(name = "x")
            Integer x;
            
            @Resource(name = "y")
            Integer y;
            
            @Resource(name = "z")
            Integer z;
        %>
        
        <hr/>
        x (aus dem DD, DD hat Vorrang) = <%= x %> <br/>
        y (aus dem DD, kein Konflikt) = <%= y %> <br/>
        z (aus dem Webfragment, kein Konflikt) = <%= z %> <br/>
        
    </body>
</html>
