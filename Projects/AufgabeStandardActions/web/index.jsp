<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:useBean id="dateInputHelper" class="beans.DateBean"/>
        
        <h1>Datum formatieren</h1>
        <form action="date.jsp" method="get">
            <h3>Datum:</h3>
            <%--
            <input name="date" value="${dateInputHelper.dateFormattedSimple}"/> (TT.MM.JJJJ)
            --%>
            <input name="date" value="<jsp:getProperty name="dateInputHelper" 
                             property="dateFormattedSimple" />"/> (TT.MM.JJJJ)
            
            <h3>Sprache</h3>
            <input type="radio" name="lang" value="de" checked/> deutsch <br/>
            <input type="radio" name="lang" value="en"/> englisch <br/>
            
            <h3>Datum-Stil</h3>
            
            <input type="radio" name="dateStyle" value="SHORT" /> SHORT <br/>
            <input type="radio" name="dateStyle" value="MEDIUM" checked/> MEDIUM <br/>
            <input type="radio" name="dateStyle" value="LONG" /> LONG <br/>
            <input type="radio" name="dateStyle" value="FULL" /> FULL <br/>
            
            <h3>Zeit-Stil</h3>
            
            <input type="radio" name="timeStyle" value="SHORT" /> SHORT <br/>
            <input type="radio" name="timeStyle" value="MEDIUM" checked/> MEDIUM <br/>
            <input type="radio" name="timeStyle" value="LONG" /> LONG <br/>
            <input type="radio" name="timeStyle" value="FULL" /> FULL <br/>
            
            <input type="submit" value="Formatiert anzeigen"/>
        </form>
        
    </body>
</html>
