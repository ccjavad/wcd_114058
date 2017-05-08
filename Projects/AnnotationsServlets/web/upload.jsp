<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <form action="upload" method="post" enctype="multipart/form-data">
            File 1: <input type="file" name="file1"/> <br/>
            File 2: <input type="file" name="file2"/> <br/>
            
            <input type="submit"/>
        </form>
        
    </body>
</html>
