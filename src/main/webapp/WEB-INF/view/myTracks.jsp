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
        <table>
            <thead>
            <tr style="padding-top: 10px">
                <th><fmt:message key="label.trackName"/></th>
                <th><fmt:message key="track.price"/></th>
            </tr>
            </thead>
            <tbody>

            <form method="post" action="controller?command=payForTracks"/>
            <input type="submit" value="<fmt:message key="button.payForTracks"/>"/>
            <form/>

            <c:forEach var="order" items="${orders}">
                <tr>
                    <td>${order.trackName}</td>
                    <td>${order.price}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

</div>

<jsp:include page="footer.jsp"/>

</body>

</html>
