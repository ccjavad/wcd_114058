<%@page import="java.util.EnumSet"%>
<%@page import="java.util.Set"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        Session-ID: ${pageContext.session.id} <br/>
        
        <a href="index.jsp">aktualisieren (ohne URL-rewriting)</a> <br/>
        
        <c:url var="target" value="index.jsp"/>
        <a href="${target}">aktualisieren (mit URL-rewriting, aber nicht für SSL-Session-Tracking)</a> <br/>

        
        <h1>Session Tracking Modes im DD:</h1>
        tracking-mode im session-config
        
        
        <h1>Session Tracking Modes dynamisch:</h1>

        <%
//           dynamisch setzen geht spätestens in einem ServletContextListener:
//            Set<SessionTrackingMode> myModes = EnumSet.of(SessionTrackingMode.SSL);
//            application.setSessionTrackingModes(myModes);
        %>
        
        <h2>default:</h2>
        <%
            Set<SessionTrackingMode> defaultModes 
                = application.getDefaultSessionTrackingModes();
        %>
        
        ${pageContext.servletContext.defaultSessionTrackingModes}

        <h2>effective:</h2>
        <%
            Set<SessionTrackingMode> effectiveModes 
                    = application.getEffectiveSessionTrackingModes();
        %>
        
        ${pageContext.servletContext.effectiveSessionTrackingModes}
        
    </body>
</html>
