<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="languages"/>

<form style="position: relative; top: 0; left: 0" method="post" action="controller?command=addNewTrack">
    <input type="text" value="<fmt:message key="input.trackName"/>" onfocus="this.value=''" name="trackName" required/>
    <input type="text" value="<fmt:message key="input.trackPrice"/>" onfocus="this.value=''" name="trackPrice"
           required pattern="\d{1,3}\.\d{2}" title="For example 1.10"/>
    <input type="submit" value="<fmt:message key="button.addNewTrack"/>"/>
</form>