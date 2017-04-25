<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="ma" uri="com.mycompany.taglib" %>
<%@taglib prefix="mtf" tagdir="/WEB-INF/tags/" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        date: <ma:date/> <br/>
        time: <ma:time/> <br/>
        
        <hr/>
        zeit: <mtf:zeit/>
        
    </body>
</html>
