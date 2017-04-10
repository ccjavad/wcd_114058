<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Punkt mit Beans</h1>
        
        <% pageContext.setAttribute("d1", new Date()); %>
        \${d1} = ${d1} <br/>
        
        <%-- Property einer Bean: --%>
        \${d1.time} = ${d1.time} <br/>
        
        
        <jsp:useBean id="d1" type="java.util.Date"/>
        wdh. mit getProperty: <jsp:getProperty name="d1" property="time"/>
        <br/>
        
        
        <%-- keine Exception: --%>
        \${nichtda.time} = ${nichtda.time} <br/>
        
        <%-- 
            PropertyNotFoundException:
                ${d1.nichtda}
        --%>
        
        
        
        <h1>Punkt mit Maps</h1>
        
        <%
            Map<String, Object> map = new HashMap<>();
            map.put("mo", 1);
            map.put("di", 2);
            map.put("mi", 3);
            
            request.setAttribute("map", map);
        %>
        
        \${map.mo} = ${map.mo} <br/>
        
        \${map.nichtda} = ${map.nichtda} <br/>
        
        
    </body>
</html>
