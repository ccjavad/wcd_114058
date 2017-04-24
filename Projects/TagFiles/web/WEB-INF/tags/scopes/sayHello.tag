<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%-- 
    1. attribute-Directive ersetzt den tag <attribute> aus dem TLD 
    2. Es ensteht auch ein Webanwendungsattribut im Page-Scope der Tagdatei
--%>
<%@attribute name="userName" required="true" rtexprvalue="false"%>
Hallo ${userName}
