<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <jsp:useBean id="a1" class="beans.Auto"/>
        a1: ${a1} <br/>
        
        <jsp:setProperty name="a1" property="farbe" value="grün"/>
        a1: ${a1} <br/>
        
        a1.farbe: <jsp:getProperty name="a1" property="farbe"/> <br/>
        
        <hr/>
        
        <jsp:useBean id="a2" class="beans.Auto"/>
        <jsp:setProperty name="a2" property="farbe" param="color"/>
        a2.farbe: <jsp:getProperty name="a2" property="farbe"/> <br/>
        
        <hr/>
        
        <jsp:useBean id="a3" class="beans.Auto"/>
        a3: ${a3} <br/>
        <jsp:setProperty name="a3" property="*"/>
        a3: ${a3} <br/>
        
    </body>
</html>
