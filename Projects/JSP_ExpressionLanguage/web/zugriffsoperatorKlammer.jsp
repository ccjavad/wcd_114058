<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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
            map.put("do", "Donnerstag");
            
            pageContext.setAttribute("map", map);
        %>
        
        \${map.mo} = ${map.mo} <br/>
        falsch: \${map[mo]} = ${map[mo]} <br/>
        richtig: \${map["mo"]} = ${map["mo"]} <br/>
        richtig: \${map['mo']} = ${map['mo']} <br/>
        
        <%--
            'do' ist ein Java-Schlüßelwort!
                ${map.do}
        --%>
                
        <%-- 
            kein Map-Zugriff mit dem Punkt bei komplexen Schlüßeln:
                ${map.der 3. Tag} 
        --%>
        \${map["der 3. Tag"]} = ${map["der 3. Tag"]} <br/>
        
        
        <h1>Klammer mit Listen und Arrays</h1>
        
        <%
            List<Integer> list = new ArrayList<>();
            list.add(1); // 0
            list.add(7000); // 1
            list.add(3); // 2
            
            pageContext.setAttribute("list", list);
            
            Map<String, Integer> m2 = new HashMap<>();
            m2.put("mo", 1);
            m2.put("di", 2);
            
            pageContext.setAttribute("days", m2);
        %>
        
        \${list[1]} = ${list[1]} <br/>
        \${days.mo} = ${days.mo} <br/>
        \${list[ days.mo ]} = ${list[ days.mo ]} <br/> <br/>
        
        \${days["mo"]} = ${days["mo"]} <br/>
        \${list[ days["mo"] ]} = ${list[ days["mo"] ]} <br/>
        
        <hr/>
        
        <%
            String[] arr = { "jan", "feb" };
            Map<String, Object> m3 = new HashMap<>();
            
            m3.put("arr", arr);
            
            pageContext.setAttribute("m3", m3);
        %>
        
        \${m3.arr[1]} = ${m3.arr[1]} <br/>
        \${m3["arr"][1]} = ${m3["arr"][1]} <br/>
        
        
    </body>
</html>
