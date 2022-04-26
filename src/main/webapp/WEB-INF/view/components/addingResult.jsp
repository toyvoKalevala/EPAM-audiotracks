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