<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Author List</title>
</head>
<body>
<table>
    <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>City</th>
        <th>About User</th>
    </tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.city}</td>
            <td>${user.aboutMe}</td>
            <td>
                <a href="/formEdit/${user.id}">Edit</a>
                <a href="/delete/${user.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
<a href="/form">Add</a>
<a href="/home">Home Page</a>

</body>
</html>
