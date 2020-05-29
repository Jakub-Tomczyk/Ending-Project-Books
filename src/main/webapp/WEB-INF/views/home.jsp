<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
</head>
<body>
Welcome to Home Page :-) <br>
What You would like to do?
<br>
<div>
    <br>
    Add new User -
<a href="/form"> add new user </a>
</div>
<div>
    <br>
    List of all Users-
    <a href="/usersList"> users list </a>
</div>
<div>
    <br>
    Add new Book -
    <a href="/formBook"> add new Book </a>
</div>
<div>
    <br>
    List of all Books-
    <a href="/bookList"> books list </a>
</div>
<div>
    <br>
    Add new Author -
    <a href="/formAuthor"> add new Author </a>
</div>
<div>
    <br>
    List of all Authors-
    <a href="/authorList"> authors list </a>
</div>
<div>
    <br>
    Add new Publisher -
    <a href="/formPublisher"> add new Publisher </a>
</div>
<div>
    <br>
    List of all Publishers-
    <a href="/publisherList"> publisher list </a>
</div>
<div>
    <br>
    Add new Category -
    <a href="/formCategory"> add new Category </a>
</div>
<div>
    <br>
    List of all Category-
    <a href="/categoryList"> category list </a>
</div>

<!-- poniżej ma być to dla admina. A powyżej reszta odnośników -->

<div>
    <br>
    Login
    <a href="/about">login</a>
</div>
<div>
    <br>
    Admin
    <a href="/admin" />admin</a>
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
