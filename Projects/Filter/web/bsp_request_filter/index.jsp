<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <form action="target.jsp">
            Name: <input name="userName" value="Müller"/>
            <input type="submit" value="GET"/>
        </form>
        
        <hr/>
        
        <form action="target.jsp" method="post">
            Name: <input name="userName" value="Müller"/>
            <input type="submit" value="POST"/>
        </form>
        
        
    </body>
</html>
