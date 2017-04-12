<%@page import="utils.DateUtils"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="df" uri="/WEB-INF/tlds/dateUtils" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        getDate: ${df:getDate()} <br/> <br/>
        
        <jsp:useBean id="d" class="java.util.Date"/>
        \${d} = ${d} <br/>
        ${df:addDays(d, 2)}
        nach addDays. \${d} = ${d} <br/> <br/>
        
        <%
            // DateUtils.print(d, pageContext.getOut() );
        %>
        printDate: ${df:printDate(d, pageContext.out)} <br/> <br/>
        
        
        
        ${df:createDate("datum", "session", pageContext)}
        \${sessionScope.datum} = ${sessionScope.datum} <br/> <br/>
        
        
        
        format (de): ${df:formatDate(datum, "de")} <br/>
        format (en): ${df:formatDate(datum, "en")} <br/>
        format (fr): ${df:formatDate(datum, "fr")} <br/>
        format (it): ${df:formatDate(datum, "it")} <br/>
        
    </body>
</html>
