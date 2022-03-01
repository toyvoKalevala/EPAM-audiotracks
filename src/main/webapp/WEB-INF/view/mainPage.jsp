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

    <div class="left-column">
        <div id="buttons">
            <a class="button-menu" href="test.html"><fmt:message key="menu.catalog"/></a>
            <a class="button-menu" href="test.html"><fmt:message key="menu.userTracks"/></a>
            <a class="button-menu" href="test.html"><fmt:message key="menu.users"/></a>
        </div>
    </div>

    <div class="main">

        <p><fmt:message key="main.welcome"/></p>

        <div class="flex-table">

            <div class="left-table">
                <c:forEach var="track" items="${tracks}">
                    <div class="list">
                            ${track.name}<br>
                    </div>
                </c:forEach>
            </div>

            <div class="right-table">
                <c:forEach var="feedback" items="${feedbacks}">
                    <div class="list">
                            ${feedback.text}
                    </div>
                </c:forEach>
            </div>

        </div>

    </div>

</div>

<jsp:include page="footer.jsp"/>

</body>

</html>
