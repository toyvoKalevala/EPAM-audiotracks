<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="languages"/>

<div class="left-column">
    <div id="buttons">
        <c:if test="${isAdmin == false}">
            <a class="button-menu" href="controller?command=userOrders"><fmt:message key="menu.userOrders"/></a>
            <a class="button-menu" href="controller?command=userTracks"><fmt:message key="menu.userTracks"/></a>
        </c:if>
        <a class="button-menu" href="controller?command=trackCatalog"><fmt:message key="menu.catalog"/></a>
        <c:if test="${isAdmin == true}">
            <a class="button-menu" href="controller?command=userManagement"><fmt:message key="menu.users"/></a>
        </c:if>
    </div>
</div>