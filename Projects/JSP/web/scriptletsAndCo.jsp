<%-- Kommentar --%>

<%-- Directive: --%>
<%@page contentType="text/html;charset=UTF-8" %>

<html>
Zeile 1 (template text) <br/>
Zeile 2 (wieder ein template text) <br/>

<%-- Scriptlet: --%>
<%
    int x = 3;
    System.out.println("Hallo Admin!");

    out.println("x = " + x + "<br/>");
%>


<%-- Expression: --%>
<%= "x = " + x + "<br/>" %>

x = <%= x %> <br/>

y = <%= y %> <br/>


<%-- Declaration: --%>
<%! 
    int y = 333;
    
    void testMethod() {
    }
    
    class InnerClass {
    }
%>



</html>