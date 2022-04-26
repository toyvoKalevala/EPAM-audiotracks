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
        <form style="position: relative; top: 0; left: 0" method="post" action="controller?command=addFeedback">
            <input type="hidden" value="${trackId}" name="trackId"/>
            <input type="text" value="<fmt:message key="input.enterFeedback"/>"
                   onfocus="this.value=''" name="feedbackText"/>
            <input type="submit" value="<fmt:message key="button.addFeedback"/>"/>
        </form>
    </div>

</div>

<jsp:include page="../components/footer.jsp"/>

</body>

</html>
