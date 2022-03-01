<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="languages"/>

<html>

<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="static/styles/style.css"/>
</head>

<body>

<jsp:include page="mainHeader.jsp"/>

<div class="flex-container">

    <jsp:include page="leftColumn.jsp"/>

    <div class="main">

        <c:if test="${isAdmin == false}">
            <p><fmt:message key="main.welcome"/></p>
        </c:if>

        <c:if test="${isAdmin == true}">
            <div class="admin-button">
                <p><fmt:message key="button.addNewGenre"/></p>
            </div>
            <div class="admin-button">
                <p><fmt:message key="button.addNewAlbum"/></p>
            </div>
            <div class="admin-button">
                <p><fmt:message key="button.addNewTrack"/></p>
            </div>
        </c:if>

        <jsp:include page="popularTracks.jsp"/>

    </div>

</div>

<jsp:include page="footer.jsp"/>

</body>

</html>
