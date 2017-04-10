<%@page import="java.util.TreeMap"%>
<%@page import="java.util.Map"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Klammer mit Beans</h1>
        
        <jsp:useBean id="d1" class="java.util.Date"/>
        
        \${d1.time} = ${d1.time} <br/>
        \${d1["time"]} = ${d1["time"]} <br/>
        \${d1['time']} = ${d1['time']} <br/>
        
        falsch: \${d1[time]} = ${d1[time]} <br/>
        
        <% pageContext.setAttribute("prop", "time"); %>
        richtig: \${d1[prop]} = ${d1[prop]} <br/>
        
        
        <h1>Klammer mit Maps</h1>
        <%
            Map<String, Object> map = new TreeMap<>();
            map.put("mo", "Montag");
            map.put("di", "Dienstag");
            map.put("der 3. Tag", "Mittwoch");
            
            pageContext.setAttribute("map", map);
        %>
        
        \${map.mo} = ${map.mo} <br/>
        falsch: \${map[mo]} = ${map[mo]} <br/>
        richtig: \${map["mo"]} = ${map["mo"]} <br/>
        richtig: \${map['mo']} = ${map['mo']} <br/>
        
        
        <%-- ${map.der 3. Tag} --%>
        \${map["der 3. Tag"]} = ${map["der 3. Tag"]} <br/>
        
        
        
    </body>
</html>
