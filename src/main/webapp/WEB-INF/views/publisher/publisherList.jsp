<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Publisher List</title>
</head>
<body>
<table>
    <tr>
        <th>Name</th>
    </tr>
    <c:forEach items="${publishers}" var="publisher">
        <tr>
            <td>${publisher.publisherName}</td>
            <td>
                <a href="/formPublisher/${publisher.id}">Edit</a>
                <a href="/deletePublisher/${publisher}.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<a href="/formPublisher">Add</a>
<a href="/home">Home Page</a>
</body>
</html>
