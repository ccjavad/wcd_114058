<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="mtf" tagdir="/WEB-INF/tags/" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <mtf:useBodyAsFragment message="1 + 2 = ${1+2}" count="3">
            ${index} 
        </mtf:useBodyAsFragment>
        
        <hr/>
        
        <mtf:useAttributeAsFragment>
            <jsp:attribute name="frg1">
                1 + 1 = ${1+2} <br/>
            </jsp:attribute>
        </mtf:useAttributeAsFragment>
        
    </body>
</html>
