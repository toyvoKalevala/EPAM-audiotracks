<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="languages"/>

<table>
    <thead>
    <tr style="padding-top: 10px">
        <th><fmt:message key="track.id"/></th>
        <th><fmt:message key="track.name"/></th>
        <th><fmt:message key="track.album"/></th>
        <th><fmt:message key="track.price"/></th>
    </tr>
    </thead>
    <tbody>

    <form method="post" action="controller?command=orderTrack"/>
    <input type="text" name="trackId" value="<fmt:message key="input.enterTrackId"/>" onfocus="this.value=''"/>
    <input type="submit" value="<fmt:message key="button.orderTrack"/>"/>
    <form/>

    <c:forEach var="track" items="${tracks}">
        <tr>
            <td>${track.id}</td>
            <td>${track.name}</td>
            <td>${track.album}</td>
            <td>${track.price}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>