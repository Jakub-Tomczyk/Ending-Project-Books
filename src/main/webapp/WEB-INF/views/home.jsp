<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Testowanie</title>
</head>
<body>
Home Page :-)
<br>
<div>
    <br>
    Add new User -
<a href="/form"> add new user </a>
</div>
<div>
    <br>
    List all Users-
    <a href="/usersList"> users list </a>
</div>
<div>
    <br>
    Add new Book -
    <a href="/formBook"> add new Book </a>
</div>
<div>
    <br>
    List all Books-
    <a href="/bookList"> books list </a>
</div>
<div>
    <br>
    Add new Author -
    <a href="/formAuthor"> add new Author </a>
</div>
<div>
    <br>
    List all Authors-
    <a href="/authorList"> authors list </a>
</div>


<!-- poniżej ma być to dla admina. A powyżej reszta odnośników -->

<div>
    <br>
    Only for Admin -
    <a href="/about">admin login</a>
</div>
<nav>
    <sec:authorize access="isAuthenticated()">
        <form action="<c:url value="/logout"/>" method="post">
            <input type="submit" value="Logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
    </sec:authorize>
</nav>

</body>
</html>
