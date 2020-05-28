<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book List</title>
</head>
<body>
<table>
    <tr>
        <th>Title</th>
        <th>Author</th>
        <th>Publisher</th>
        <th>Description</th>
        <th>Rating</th>
        <th>Category</th>
    </tr>
    <c:forEach items="${books}" var="book">
        <tr>
            <td>${book.title}</td>
            <td>${book.author}</td>
            <td>${book.publisher}</td>
            <td>${book.description}</td>
            <td>${book.rating}</td>
            <td>${book.category}</td>
            <td>
                <a href="/formBook/${book.id}">Edit</a>
                <a href="/deleteBook/${book.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<a href="/formBook">Add</a>
<a href="/home">Home Page</a>

</body>
</html>
