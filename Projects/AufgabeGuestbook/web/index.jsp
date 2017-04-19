<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <h1>Gästebuch</h1>

        <c:forEach items="${guestbookEntries}" var="entry">
            Datum: ${entry.date} <br/>
            Username: <c:out value="${entry.userName}" /> <br/>
            Eintrag: <c:out value="${entry.userText}" /> <br/>
            <br/>
        </c:forEach>
        
        <hr/>
        
        <form action="addEntry" method="post">
            Name: <input name="userName"/> <br/>
            Text: <textarea name="userText"></textarea>
            
            <br/>
            <input type="submit"/>
        </form>
            
    </body>
</html>
