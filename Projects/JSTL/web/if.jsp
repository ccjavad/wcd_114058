<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:if test="true" >
            1. Im Body der if. ${1+1==2} <br/>
        </c:if>
            
        <c:if test="<%=1+1==2%>" >
            2. Im Body der if.<br/>
        </c:if>
            
        <c:if test="${1+1==2}" >
            3. Im Body der if.<br/>
        </c:if>
            
        <c:if test="${1+1==123}" >
            4. Im Body der if.<br/>
        </c:if>
            
        <c:if test="${22/2==111}" var="erg" >
            5. Im Body. erg = ${erg} <br/>
        </c:if>
        5. Nach dem Body. erg = ${erg} <br/>
        
        <c:if test="${2 == 1+1}" var="erg2" scope="request">
            6. Im Body<br/>
        </c:if>
        6. Nach dem Body. erg2 = ${erg2} <br/>
            

    </body>
</html>
