<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>back.jsp</h1>
        
        <% 
            pageContext.include("toInclude.jsp");
//            request.getRequestDispatcher("toInclude.jsp").include(request, response);
        %>
        
    </body>
</html>
