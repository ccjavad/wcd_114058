<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="ma" uri="/WEB-INF/myactions" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <ma:date/>
        
        <hr/>
        
        <ma:outer>
            <ma:inner/>
        </ma:outer>
        
        <hr/>
        
        <ma:produkt name="Milch" e101="20" e500="3" e444="${15+2}"/>
        
    </body>
</html>
