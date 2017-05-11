<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <sql:query var="resSet" dataSource="jdbc/TestDB">
            select * from staedte
        </sql:query>
        
        <c:forEach items="${resSet.rows}" var="rowData">
            ${rowData.name} / ${rowData.land} / ${rowData.einwohner}  <br/>
        </c:forEach>
            
    </body>
</html>
