<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style type="text/css">
    table * {
        border: 1px solid black;
        border-radius: 5px;
        caption-side: bottom;
        text-align: center;
        background-color: antiquewhite
    }
</style>
<head>
    <title>Category List</title>
</head>
<body>
<table>
    <tr>
        <th>Name</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${categories}" var="category">
        <tr>
            <td>${category.categoryName}</td>
            <td>
                <a href="/formCategory/${category.id}">Edit</a>
                <a href="/deleteCategory/${category.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<a href="/formCategory">Add</a>
<a href="/home">Home Page</a>
</body>
</html>
