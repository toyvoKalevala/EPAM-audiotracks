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

        <label style="color:black" ;>
            <c:if test="${not empty txForFeedback}">
                <fmt:message key="${txForFeedback}"/>
            </c:if>
        </label>

        <c:if test="${not empty userTracks}">
            <table style="width: fit-content">
                <thead>
                <tr style="padding-top: 10px">
                    <th><fmt:message key="label.trackName"/></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="userTrack" items="${userTracks}">
                    <tr>
                        <td>${userTrack.trackName}</td>
                        <td>
                            <form style="position: relative; top: 0; left: 0; margin: auto" method="post"
                                  action="controller?command=showFeedbackPage">
                                <input type="hidden" value="${userTrack.trackId}" name="trackId"/>
                                <input type="submit" value="<fmt:message key="button.addFeedback"/>"/>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:if>
    </div>

</div>

<jsp:include page="footer.jsp"/>

</body>

</html>
