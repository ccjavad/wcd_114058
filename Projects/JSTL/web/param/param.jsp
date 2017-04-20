<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <jsp:include page="test.jsp?heute=Montag"/>
        
        <jsp:include page="test.jsp">
            <jsp:param name="heute" value="Dienstag"/>
        </jsp:include>
        
        
        <hr/>
        
        <c:import url="test.jsp?heute=Montag"/>
        
        <c:import url="test.jsp">
            <c:param name="heute" value="Dienstag"/>
        </c:import>
        
        
        <hr/>
        
        <c:url value="target.html">
            <c:param name="color" value="red"/>
            <c:param name="color" value="orange"/>
        </c:url>
    </body>
</html>
