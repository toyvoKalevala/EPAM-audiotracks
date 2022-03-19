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

<jsp:include page="../components/mainHeader.jsp"/>

<div class="flex-container">

    <jsp:include page="../components/leftColumn.jsp"/>

    <div class="main">
        <table>
            <thead>
            <tr style="padding-top: 10px">
                <th>id</th>
                <th><fmt:message key="user.login"/></th>
                <th><fmt:message key="user.role"/></th>
                <th><fmt:message key="user.discount"/></th>
            </tr>
            </thead>
            <tbody>

            <form method="post" action="controller?command=changeDiscount"/>
            <input type="text" name="userId" value="<fmt:message key="input.enterUserId"/>" onfocus="this.value=''"/>
            <input type="text" name="userDiscount" value="<fmt:message key="input.enterUserDiscount"/>"
                   onfocus="this.value=''"/>
            <input type="submit" value="<fmt:message key="button.changeDiscount"/>"/>
            <form/>

            <c:forEach var="userForList" items="${users}">
                <tr>
                    <td>${userForList.id}</td>
                    <td>${userForList.login}</td>
                    <td>
                        <c:choose>
                            <c:when test="${userForList.isAdmin == true}">
                                <fmt:message key="user.admin"/>
                            </c:when>
                            <c:otherwise>
                                <fmt:message key="user.user"/>
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>${userForList.discount}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

</div>

<jsp:include page="../components/footer.jsp"/>

</body>

</html>
