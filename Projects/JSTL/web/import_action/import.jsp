<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <h1>Interne Ressourcen einbinden</h1>
        
        <%@include file="toInclude.html" %>
        <jsp:include page="toInclude.html" />
        
        <hr/>
        
        <%@include file="toInclude.jsp" %>
        <%--
            Problem mit der useBean, die dieselbe id hat
        <%@include file="toInclude.jsp" %>
        --%>
        
        <jsp:include page="toInclude.jsp" />
        <jsp:include page="toInclude.jsp?color=red" />
        
        
        <hr/>
        
        <c:import url="toInclude.html"/>
        
        <c:import url="toInclude.jsp"/>
        <c:import url="toInclude.jsp?color=red"/>
        
        
        <h2>import mit var und scope</h2>
        <c:import url="generateDayNames.jsp" var="text" scope="page"/>
        <c:forEach items="${text}" var="day">
            ${day} - 
        </c:forEach>
        <br/>
        text ist nach der import da: ${text}
            
        
        <h2>import mit varReader</h2>
        <c:import url="generateDayNames.jsp" varReader="reader">
            reader im Body: ${reader} <br/>
        </c:import>
        reader ist nach dem Body weg: ${reader} <br/>
            

        <h1>Externe Ressourcen einbinden</h1>
        
        <h2>Andere Server mit Http</h2>
        <c:import url="http://if-schleife.de/" var="text2"/>
        <c:if test="${not empty text2}">
            Die Antwort von http://if-schleife.de/ liegt in dem Attribut text2 vor
        </c:if>
            
            
        <h2>Derselbe Container, eine 'Foreign App' (nicht in der Prüfung)</h2>
        <%--
            In der context.xml:
                <Context path="/JSTL" crossContext="true"/>
        --%>
        
        Der Text mit der service() von Servlet aus der Wetter-App: 
        <c:import url="/wind" context="/Wetter"/>
        
    </body>
</html>
