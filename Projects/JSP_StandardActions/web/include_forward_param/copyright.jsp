<%@page import="java.time.LocalDate"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
Copyright 
<% 
   int year = LocalDate.now().getYear();
%>
<%= year %>
