<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="mtf" tagdir="/WEB-INF/tags/scopes/" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <mtf:returnMitVariable>
            JSP. Im Body der Tagdatei-Action. result: ${pageScope.result} <br/>
        </mtf:returnMitVariable>
        JSP. Nach dem Body der Tagdatei-Action. result: ${pageScope.result} <br/>
        
    </body>
</html>
