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

        <label style="color:black; font-size: 20px; display: block;
                   margin-bottom: 20px;">
            <c:if test="${not empty trackIsOrdered}">
                <fmt:message key="${trackIsOrdered}"/>
                <br/>
            </c:if>
        </label>

        <jsp:include page="../components/trackCatalog.jsp"/>

    </div>

</div>

<jsp:include page="../components/footer.jsp"/>

</body>

</html>
