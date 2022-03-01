<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="languages"/>

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