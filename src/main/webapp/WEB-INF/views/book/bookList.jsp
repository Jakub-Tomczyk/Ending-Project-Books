<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style type="text/css">
    table * {
        border: 1px solid black;
        border-radius: 5px;
        caption-side: bottom;
        text-align: center;
        background-color: lightgray
    }
</style>
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
        <th>Action</th>
    </tr>
    <c:forEach items="${books}" var="book">
        <tr>
            <td>${book.title}</td>
            <td><c:forEach items="${book.author}" var="auth">
                ${auth.fullName}
            </c:forEach></td>
            <td><c:forEach items="${book.publisher}" var="publ">
                ${publ.publisherName}
            </c:forEach></td>
            <td>${book.description}</td>
            <td>${book.rating}</td>
            <td><c:forEach items="${book.category}" var="categ">
                ${categ.categoryName}
            </c:forEach></td>
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
