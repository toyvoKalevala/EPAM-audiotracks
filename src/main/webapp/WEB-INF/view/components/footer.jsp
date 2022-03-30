<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="languages"/>
<%@ taglib prefix="ex" uri="/WEB-INF/view/tag/custom.tld" %>

<footer class="footer">

    <div class="about">
        <phone>
            <c:if test="${locale == 'ru' || locale == 'by'}">
                <ex:DateTime dateTimeFormat="ruBy"/>
            </c:if>
            <c:if test="${locale == 'eng'}">
                <ex:DateTime dateTimeFormat="eng"/>
            </c:if>
            <c:if test="${locale == null}">
                <ex:DateTime dateTimeFormat="ruBy"/>
            </c:if>
        </phone>
    </div>

</footer>
