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

        <c:if test="${isAdmin == false}">

            <label style="color:black; font-size: 20px; display: block;
                   margin-bottom: 20px;">
                <c:if test="${not empty trackIsOrdered}">
                    <fmt:message key="${trackIsOrdered}"/>
                    <br/>
                </c:if>
            </label>

            <jsp:include page="../components/trackCatalog.jsp"/>

        </c:if>

        <c:if test="${isAdmin == true}">

            <label style="color:black; font-size: 20px; display: block;
                   margin-bottom: 20px;">
                <c:if test="${not empty assemblyAdded}">
                    <fmt:message key="${assemblyAdded}"/>
                    <br/>
                </c:if>
            </label>
            <label style="color:black; font-size: 20px; display: block;
                   margin-bottom: 20px;">
                <c:if test="${not empty albumAdded}">
                    <fmt:message key="${albumAdded}"/>
                    <br/>
                </c:if>
            </label>
            <label style="color:black; font-size: 20px; display: block;
                   margin-bottom: 20px;">
                <c:if test="${not empty successAdding}">
                    <fmt:message key="${successAdding}"/>
                    <br/>
                </c:if>
            </label>
            <label style="color:black; font-size: 20px; display: block;
                   margin-bottom: 20px;">
                <c:if test="${not empty trackAddedToAssembly}">
                    <fmt:message key="${trackAddedToAssembly}"/>
                </c:if>
            </label>

            <details>
                <summary><fmt:message key="label.addNewTrack"/></summary>
                <br/>
                <jsp:include page="../components/addNewTrack.jsp"/>
            </details>
            <br/>
            <details>
                <summary><fmt:message key="label.addNewAlbum"/></summary>
                <br/>
                <jsp:include page="../components/addNewAlbum.jsp"/>
                <jsp:include page="../components/addTrackToAlbum.jsp"/>
            </details>
            <br/>
            <details>
                <summary><fmt:message key="label.addNewAssembly"/></summary>
                <br/>
                <jsp:include page="../components/addNewAssembly.jsp"/>
                <jsp:include page="../components/addTrackToAssembly.jsp"/>
            </details>
        </c:if>

    </div>

</div>

<jsp:include page="../components/footer.jsp"/>

</body>

</html>
