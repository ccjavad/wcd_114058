<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <jsp:include page="sayHello.jsp?userName=Tom"/>
        testParam. userName = <%= request.getParameter("userName") %> <br/>
        
        <jsp:include page="sayHello.jsp">
            <jsp:param name="userName" value="Jerry"/>
        </jsp:include>
        testParam. userName = <%= request.getParameter("userName") %> <br/>
        
        
    </body>
</html>
