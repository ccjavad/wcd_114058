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
-- Hallo, ich bin Template-Text<br/>

<%--
    Scriptlets, Expression und Declarations: wie bei einer JSP (s. implizite Objekte)
--%>
<%! int y = 5; %>
<% int x = 3; %>
-- x + y = <%= x + y %> <br/>

<%--
    Implizite Objekte für Scriptlets wie bei einer JSP, aber:
           JSP hat pageContext
           Tag-File hat jspContext

           <%= pageContext %> in einer Tag-Datei führt zum Compilerfehler
--%>
-- Tag-File. jspContext: <%= jspContext %> <br/>


<%--
    Standard-Actions:
        - alle, die eine JSP haben kann: useBean, getProperty...
        - und eigene (nur für Tag-Files): jsp:doBody (s. testDoBody.tag), jsp:invoke
--%>
<jsp:useBean id="d1" class="java.util.Date"/>


<%--
    Expression Language: wie bei einer JSP
--%>
-- Tag-File. pageContext: ${pageContext} <br/>


<%--
    CustomActions: wie bei einer JSP
--%>
<c:forEach begin="1" end="3" var="x">
  ${x}
</c:forEach>