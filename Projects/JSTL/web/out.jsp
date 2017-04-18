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
        
        <hr/>
        
        <% pageContext.setAttribute("att", "<hr/> steht für eine Trennlinie"); %>
        <c:out value="${att}" default="Alternativer Text 1"/> <br/>
        <c:out value="${nichtda}" default="Alternativer Text 2"/> <br/>

        <hr/>
        
        <c:out value="${att}">Alternativer Text 3.a</c:out> <br/>
        <c:out value="${nichtda}">Alternativer Text 3.b</c:out> <br/>
        
        <hr/>
        
        <c:out value="${nichtda}">
            Alternativer Text 4. Zeile 1<br/>
            Alternativer Text 4. Zeile 2<br/>
            Alternativer Text 4. Zeile 3<br/>
        </c:out> <br/>
        
        <hr/>
        
        <c:out value="${att}" escapeXml="${not empty att}">
            Alternativer Text 5. Zeile 1<br/>
            Alternativer Text 5. Zeile 2<br/>
            Alternativer Text 5. Zeile 3<br/>
        </c:out> <br/>
        
        <hr/>
        
        <c:out value="${nichtda}" escapeXml="${not empty nichtda}">
            Alternativer Text 6. Zeile 1<br/>
            Alternativer Text 6. Zeile 2<br/>
            Alternativer Text 6. Zeile 3<br/>
        </c:out> <br/>
        
        
            
    </body>
</html>
