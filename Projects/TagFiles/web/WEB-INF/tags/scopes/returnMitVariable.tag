<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%@variable name-given="result" scope="AT_BEGIN" %>

<c:set var="result" value="String erzeugt in der Tagdatei 'returnMitVariable.tag'"/>
-- Tag-File. result: ${pageScope.result} <br/>
<jsp:doBody/>