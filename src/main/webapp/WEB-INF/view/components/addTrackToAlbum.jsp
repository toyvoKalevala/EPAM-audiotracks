<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="languages"/>

<form style="position: relative; top: 0; left: 0" method="post" action="controller?command=addTrackToAlbum">

    <select name="trackId" style="padding: 6px; font-size: medium;">
        <c:forEach var="track" items="${tracks}">
            <option name="trackId" value="${track.id}">${track.name}</option>
        </c:forEach>
    </select>

    <select name="albumId" style="padding: 6px; font-size: medium;">
        <c:forEach var="album" items="${albums}">
            <option name="albumId" value="${album.id}">${album.name}</option>
        </c:forEach>
    </select>

    <input type="submit" value="<fmt:message key="button.addTrackToAlbum"/>"/>

</form>