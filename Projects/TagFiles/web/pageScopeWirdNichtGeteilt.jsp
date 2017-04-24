<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="mtf" tagdir="/WEB-INF/tags/scopes/" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <h1>Page-Scope wird nicht geteilt</h1>
        
        <c:set var="request-att" value="request-value" scope="request"/>
        JSP. request-att: ${requestScope["request-att"]} <br/>


        <c:set var="page-att" value="page-value"/>
        JSP. VOR mtf:scopeAccess. page-att: ${pageScope["page-att"]} <br/>

        <mtf:scopeAccess/>

        JSP. NACH mtf:scopeAccess. page-att: ${pageScope["page-att"]} <br/>
        
        
        
        
    </body>
</html>
