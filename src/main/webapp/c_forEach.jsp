<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String[] companyList = {"Tesla", "Microsoft", "Meta"};
    request.setAttribute("companyList", companyList);
%>
<!DOCTYPE html>
<html>
<head>
    <title>Looping Collections</title>
</head>
<body>
<h1>Looping Collections</h1>

<h2>JSP scripting</h2>
<ul>
    <%
        String[] companies = (String[]) request.getAttribute("companyList");
        for (String company : companies) {
    %>
    <li><%= company %>
    </li>
    <% } %>
</ul>

<h2>JSTL</h2>
<ul>
    <c:forEach var="company" items="${companyList}">
        <li>${company}</li>
    </c:forEach>尸
</ul>
</body>
</html>
