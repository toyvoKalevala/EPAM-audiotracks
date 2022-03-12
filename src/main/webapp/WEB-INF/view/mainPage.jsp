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

            <jsp:include page="popularTracks.jsp"/>

        </c:if>

        <c:if test="${isAdmin == true}">

            <jsp:include page="addNewTrack.jsp"/>

            <jsp:include page="addNewAlbum.jsp"/>

            <jsp:include page="addTrackToAlbum.jsp"/>

        </c:if>

    </div>

</div>

<jsp:include page="footer.jsp"/>

</body>

</html>
