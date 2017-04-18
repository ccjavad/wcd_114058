<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="memory.MemoryImage, memory.Memory" %>
<%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Memory</title>
    </head>
    <body>
        <h1>Memory</h1>

        neues Spiel starten:
        <a href="newGame?level=EASY">leicht</a>
        <a href="newGame?level=NORMAL">normal</a>
        <a href="newGame?level=HARD">schwer</a>
        <hr/>

        <%--
            
            synchronized(session) {
                Memory game = (Memory)session.getAttribute("game");

                if(game!=null) {
                    List<MemoryImage> list = game.getImages();

                    for(int i=0; i<list.size(); i++) {
                        MemoryImage img = list.get(i);

                        if(img.isOpen()) {
                            String name = img.getName();
        %>
        
        <img src="images/<%= name %>" width="50"/>
        
        <%
                        } else {
        %>

        <a href="openImage?index=<%=i%>"><img src="images/cover.png" width="50"/></a>
        <%
                        }
                    }
                }
            }
        --%>


        <%-- 
            Achtung! Synchronisieren fehlt
        --%>
        
        <c:forEach items="${game.images}" var="img" varStatus="status">
            <c:choose>
                <c:when test="${img.open}">
                    <img src="images/${img.name}" width="50"/>
                </c:when>
                <c:otherwise>
                    <a href="openImage?index=${status.count-1}"><img src="images/cover.png" width="50"/></a>
                </c:otherwise>
            </c:choose>
        </c:forEach>
                    
        </body>
    </html>
