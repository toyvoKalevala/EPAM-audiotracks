<form id="usersForm" method="post" action="controller?command=logout"/>
<input form="usersForm" name="userDiscount" value="${userForList.discount}">
<input form="usersForm" type="submit" value="<fmt:message key="button.changeDiscount"/>"/>