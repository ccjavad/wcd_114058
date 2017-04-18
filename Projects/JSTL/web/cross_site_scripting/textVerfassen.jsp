<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        Text eingeben: <br/>
        
        <form action="saveUserText" method="post">
            <textarea name="userText"><script> alert('Hallo mit Javascript') </script></textarea>
            <br>/
        <input type="submit"/>
        </form>
        
    </body>
</html>
