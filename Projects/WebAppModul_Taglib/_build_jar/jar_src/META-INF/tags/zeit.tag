<%@tag import="java.util.Date"%>
<%@tag import="java.text.DateFormat"%>
<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%
    String result = DateFormat.getTimeInstance().format(new Date());
%>
<%= result %>