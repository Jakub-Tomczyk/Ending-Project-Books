<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Category List</title>
</head>
<body>
<table>
    <tr>
        <th>Name</th>
    </tr>
    <c:forEach items="${categories}" var="category">
        <tr>
            <td>${category.nameCategory}</td>
            <td>
                <a href="/formAuthor/${category.id}">Edit</a>
                <a href="/deleteAuthor/${category.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<a href="/formCategory">Add</a>
<a href="/home">Home Page</a>
</body>
</html>
