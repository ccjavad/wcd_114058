<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag pageEncoding="UTF-8"%>
-- Tag-File. request-att: ${requestScope["request-att"]} <br/>
-- Tag-File. page-att (nicht gefunden): ${pageScope["page-att"]} <br/>
<c:set var="page-att" value="tag-file-page-value"/>
-- Tag-File. page-att (für sich erzeugt): ${pageScope["page-att"]} <br/>
