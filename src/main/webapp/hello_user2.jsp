<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body>
Welcome to your page!
<c:if test="${empty param.userName}">
    <jsp:forward page="CollectName.jsp"/>
</c:if>
Hello ${param.userName}.
</body>
</html>