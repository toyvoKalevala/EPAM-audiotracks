<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="languages"/>

<form style="position: relative; top: 0; left: 0" method="post" action="controller?command=addNewAssembly">
    <input type="text" value="<fmt:message key="input.assemblyName"/>" onfocus="this.value=''" name="assemblyName"/>
    <input type="submit" value="<fmt:message key="button.addNewAssembly"/>"/>
</form>