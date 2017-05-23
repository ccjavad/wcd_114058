<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Einloggen:</h1>
        
        <form action="j_security_check" method="post">
            Name: <input name="j_username"/>
            Password: <input type="password" name="j_password"/>
            
            <input type="submit" />
        </form>
    </body>
</html>
