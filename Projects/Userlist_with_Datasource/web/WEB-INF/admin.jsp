<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>admin</title>
        
        <script>
            var userlistChecksum = -1;
            
            function updateUserlist() {
                var xmlhttp = new XMLHttpRequest();
                
                xmlhttp.open("GET", "getUserlist", true);
                
                xmlhttp.onreadystatechange = function () {
                    if( xmlhttp.readyState === 4 && xmlhttp.status === 200 ) {
                        var out = document.getElementById("id-user-list");
                        out.innerHTML = xmlhttp.responseText;
                        
                    } else {
                        console.log("response status: " + xmlhttp.status);
                        console.log("response text: " + xmlhttp.responseText);
                    }
                };
                
                xmlhttp.send();
            }
            
            function checkUserlistChecksum() {
                var xmlhttp = new XMLHttpRequest();
                
                xmlhttp.open("GET", "userlistChecksum", true);
                
                xmlhttp.onreadystatechange = function () {
                    if( xmlhttp.readyState === 4 && xmlhttp.status === 200 ) {
                        
                        var serverChecksum = xmlhttp.responseText;
                        
                        if(userlistChecksum!=serverChecksum) {
                            userlistChecksum = serverChecksum;
                            updateUserlist();
                        }
                        
                    } else {
                        console.log("response status: " + xmlhttp.status);
                        console.log("response text: " + xmlhttp.responseText);
                    }
                };
                
                xmlhttp.send();
            }
        </script>
    </head>
    <body onload="setInterval(checkUserlistChecksum, 2000)">
        <c:set var="userName" value="${pageContext.request.userPrincipal.name}"/>
        Administrator: ${userName} (<a href="logout">logout</a>)
        
        <h3>Alle User mit einem Account:</h3>
        <ol id="id-user-list">
            loading...
        </ol>
    </body>
</html>
