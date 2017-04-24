<%-- 
    Scripting-Kommentare wie bei der JSP
--%>

<%--
    Directives:

        Wie bei einer JSP: taglib, include

        Nur für JSP:        page-Directive
        Nur für Tag-Files:  tag-Directive, attribute-Directive und variable-Directive
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@tag pageEncoding="UTF-8" isELIgnored="false" import="java.util.Date"%>
<%@tag body-content="scriptless" %>
<%@tag dynamic-attributes="dynAttsMap" %> <%-- Nicht in der Prüfung. dynAttsMap wird die Map mit dynamischen Attributen sein: ${dynAttsMap} --%>

<%--
    Template Texte: wie bei einer JSP
--%>
Hallo, ich bin Template-Text<br/>

<%--
    Scriptlets, Expression und Declarations: wie bei einer JSP
--%>
<%! int y = 5; %>
<% int x = 3; %>
x + y = <%= x + y %> <br/>

