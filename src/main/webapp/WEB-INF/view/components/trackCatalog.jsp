<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="languages"/>

<table>
    <thead>
    <tr style="padding-top: 10px">
        <th><fmt:message key="track.name"/></th>
        <th><fmt:message key="track.album"/></th>
        <th><fmt:message key="track.price"/></th>
    </tr>
    </thead>
    <tbody>

    <c:forEach var="track" items="${tracks}">
        <c:if test="${track.isBlocked == 0}">
            <tr>
                <td>${track.name}</td>
                <td>${track.album}</td>
                <td>${track.price}</td>
                <c:if test="${isAdmin == false}">
                    <td>
                        <form style="position: relative; top: 0; left: 0; margin: auto" method="post"
                              action="controller?command=orderTrackFromCatalog">
                            <input type="hidden" name="trackId" value="${track.id}"/>
                            <input type="submit" value="<fmt:message key="button.orderTrack"/>"/>
                        </form>
                    </td>
                </c:if>
                <c:if test="${isAdmin == true}">
                    <td>
                        <form style="position: relative; top: 0; left: 0; margin: auto" method="post"
                              action="controller?command=deleteTrackFromCatalog">
                            <input type="hidden" name="trackId" value="${track.id}"/>
                            <input type="submit" value="<fmt:message key="button.deleteTrack"/>"/>
                        </form>
                    </td>
                </c:if>
            </tr>
        </c:if>
    </c:forEach>

    </tbody>
</table>