<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <% 
            request.setAttribute("userText",
                    "<script>alert('alert mit Javascript')</script>");
        %>
        
        
        <c:out value="${userText}" /> <br/>
        <c:out value="${userText}" escapeXml="true" /> <br/>
        <br/>
        
        <c:out value="<b>steht für fett</b>"/> <br/>
        <c:out value="<b>steht für fett</b>" escapeXml="false"/> <br/>
        
        
            
    </body>
</html>
