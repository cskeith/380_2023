<!DOCTYPE html>
<html>
<head>
    <title>Guest Book</title>
</head>
<body>
<h1>Guest Book</h1>
<c:if test="${fn:length(entries) == 0}">
    <p>There is no message yet.</p>
</c:if>
<c:if test="${fn:length(entries) > 0}">
    <ul>
        <c:forEach var="entry" items="${entries}">
            <c:url value="/guestbook/edit/${entry.id}" var="myURL"/>
            <li>
                #${entry.id} - ${entry.name} (<fmt:formatDate value="${entry.date}" pattern="yyyy-MM-dd"/>):
                [<a href="${myURL}">Edit</a>] <br/>
                <c:out value="${entry.message}" escapeXml="true"/><br/>
            </li>
        </c:forEach>
    </ul>
</c:if>
<p><a href="<c:url value="/guestbook/add" />">Add Comment</a></p>
</body>
</html>