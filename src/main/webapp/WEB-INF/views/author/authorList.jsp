<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Author List</title>
</head>
<body>
<table>
    <tr>
        <th>Name</th>
        <th>Surname</th>
    </tr>
    <c:forEach items="${authors}" var="author">
        <tr>
            <td>${author.name}</td>
            <td>${author.surname}</td>
            <td>
                <a href="/formAuthor/${author.id}">Edit</a>
                <a href="/deleteAuthor/${author.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
<a href="/formAuthor">Add</a>
<a href="/home">Home Page</a>

</html>
