<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <h1>useBean sucht immer zuerst nach einem Attribut</h1>
        
        <h2>id und class: Falls das Attribut nicht gefunden wird, 
            wird ein neues Attribut erzeugt</h2>
        
        <jsp:useBean id="d1" class="java.util.Date"/>
        d1 = ${d1}
        
        <%--
           java.util.Date d1 = (java.util.Date)pageContext
                   .getAttribute("d1", PageContext.PAGE_SCOPE);
           if(d1==null) {
               d1 = new java.util.Date();
               pageContext.setAttribute("d1", d1, PageContext.PAGE_SCOPE);
           }
        --%>
        
        
        <h2>scope: page|request|session|application</h2>
        
        <jsp:useBean id="d2" class="java.util.Date" scope="request"/>
        d2 = <%= request.getAttribute("d2") %> <br/>
        d2 = <%= d2 %>
        
        <%--
        java.util.Date d2 = null;
        d2 = (java.util.Date) pageContext.getAttribute("d2", PageContext.REQUEST_SCOPE);
        if (d2 == null){
          d2 = new java.util.Date();
          pageContext.setAttribute("d2", d2, PageContext.REQUEST_SCOPE);
        }        
        --%>
        
        
        <h2>id, class und type (Typ der lokalen Variable)</h2>
        
        <jsp:useBean id="d3" type="java.lang.Comparable" class="java.util.Date"/>
        d3 = ${d3} <br/>
        
        <% 
            //d4, wenn sie von einem Controller kommt (hier simuliert)
            request.setAttribute("d4", 77.3);
            //mit dem RequestDispatcher weitergeleitet zu der useBean.jsp
        %>
        
        <jsp:useBean id="d4" type="java.lang.Comparable" class="java.util.Date" scope="request"/>
        d4 = ${d4} <br/>
        
        <%--
        java.lang.Comparable d4 = null;
        d4 = (java.lang.Comparable) pageContext.getAttribute("d4", PageContext.REQUEST_SCOPE);
        if (d4 == null){
          d4 = new java.util.Date();
          pageContext.setAttribute("d4", d4, PageContext.REQUEST_SCOPE);
        }
        --%>
        
        
        
        <h2>id und type: suchen nach dem Attribut. Nicht gefunden - Exception</h2>
        
        <% pageContext.setAttribute("d5", new Date()); %>
        
        <jsp:useBean id="d5" type="java.util.Date">
            Der Body für die useBean mit id und type wird in jedem Fall ignoriert
        </jsp:useBean>
        
        <%--
        java.util.Date d5 = null;
        d5 = (java.util.Date) pageContext.getAttribute("d5", PageContext.PAGE_SCOPE);
        if (d5 == null){
          throw new java.lang.InstantiationException("bean d5 not found within scope");
        }
        --%>
        
    </body>
</html>
