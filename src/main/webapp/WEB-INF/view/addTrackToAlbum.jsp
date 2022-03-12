<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="languages"/>

<label style="color:black; font-size: 20px;" ;>
    <c:if test="${not empty successAdding}">
        <fmt:message key="${successAdding}"/>
    </c:if>
</label>

<form style="position: relative; top: 0; left: 0" method="post" action="controller?command=addTrackToAlbum">

    <select name="tracks">
        <c:forEach var="track" items="${tracks}">
            <option value="${track.id}">${track.name}</option>
        </c:forEach>
    </select>

    <select name="albums">
        <c:forEach var="album" items="${albums}">
            <option value="${album.id}">${album.name}</option>
        </c:forEach>
    </select>

    <input type="submit" value="<fmt:message key="button.addTrackToAlbum"/>"/>

</form>