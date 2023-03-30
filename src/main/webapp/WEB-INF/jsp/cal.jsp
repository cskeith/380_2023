<!DOCTYPE html>
<html>
<head>
    <title>Example</title>
</head>
<body>
<h2>Calculation</h2>
<form:form method="POST" modelAttribute="calForm">
    <form:label path="op1">Operand 1</form:label><br/>
    <form:input type="text" path="op1"/><br/><br/>
    <form:label path="op2">Operand 2</form:label><br/>
    <form:input type="text" path="op2"/><br/><br/>
    <input type="submit" value="Submit"/>
</form:form>
<c:if test="${!empty result}">
    <p>${result}</p>
</c:if>
</body>
</html>