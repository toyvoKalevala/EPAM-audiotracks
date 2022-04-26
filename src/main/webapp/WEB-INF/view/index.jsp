<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="languages"/>

<html>
<head>
    <link rel="stylesheet" href="static/styles/style.css"/>
</head>
<body>

<jsp:include page="components/header.jsp"/>

<div class="container">
    <form method="post" action="controller?command=login">
        <%--@declare id="login"--%><%--@declare id="password"--%>
        <label class="login-row" for="login"><fmt:message key="label.login"/></label>
        <input class="login-row" type="text" name="login"/>
        <label class="login-row" for="password"><fmt:message key="label.password"/></label>
        <input class="login-row" type="password" name="password"/>
        <input class="login-row-btn" type="submit" value="<fmt:message key="button.login"/>"/>
        <label style="color:red" ;>
            <c:if test="${not empty errorMessage}">
                <fmt:message key="${errorMessage}"/>
            </c:if>
        </label>
    </form>
</div>

<jsp:include page="components/footer.jsp"/>

</body>

</html>
