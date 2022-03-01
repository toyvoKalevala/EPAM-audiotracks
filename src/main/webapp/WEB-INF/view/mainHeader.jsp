<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="languages"/>

<header class="header">

    <div class="logo">
        <a href="<c:url value="controller?command=goOnMain"/>"><img src="static/images/logo.jpg"></a>
    </div>

    <div class="sign-in">
        <a class="sign-in-btn" href="<c:url value="controller?command=logout"/>"><img src="static/images/exit.png"></a>
    </div>

    <div class="dropdown">
        <a class="dropbtn"><img src="static/images/eng.jpg"></a>
        <div class="dropdown-content">
            <a href="<c:url value="controller?command=changeLocale_eng"/>"><img src="static/images/eng.jpg"></a>
            <a href="<c:url value="controller?command=changeLocale_ru"/>"><img src="static/images/rus.jpg"></a>
            <a href="<c:url value="controller?command=changeLocale_by"/>"><img src="static/images/by.jpg"></a>
        </div>
    </div>

</header>
