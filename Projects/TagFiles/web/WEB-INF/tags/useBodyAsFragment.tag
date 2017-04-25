<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@attribute name="message" rtexprvalue="true"%>

<%@attribute name="count" rtexprvalue="true" required="true"%>

<%@variable name-given="index" scope="NESTED" variable-class="java.lang.Long" %>

<c:forEach begin="1" end="${count}" varStatus="status">
    <c:set var="index" value="${status.count}" />
    <jsp:doBody/> <%-- die JSP versucht das Attribut 'index' auszugeben --%>
    -- TagFile: message '${message}' hat den Typ ${message["class"]} <br/>
</c:forEach>