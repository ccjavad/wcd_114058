<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <c:forEach begin="1" end="3">
            wdh 
        </c:forEach>
        <br/>
        
        <c:forEach begin="1" end="3" var="i">
            i=${i} 
        </c:forEach>
        <br/>
        Nach dem Body ist i weg. i=${i}
        
        <hr/>
        
        mit step: <br/>
        <c:forEach begin="1" end="9" step="2" var="i">
            i=${i} 
        </c:forEach>
        
        <hr/>
        
        mit step und varStatus: <br/>
        <c:forEach begin="1" end="9" step="2" var="i" varStatus="status">
            <b>${status.count}.</b>
            i=${i} <br/>
        </c:forEach>
        
            
    </body>
</html>
