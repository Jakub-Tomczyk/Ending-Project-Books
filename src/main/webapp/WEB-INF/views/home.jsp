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
    Add new user -
<a href="/form"> Add new user </a>
</div>
<div>
    List all users-
    <a href="/usersList"> users list </a>
</div>

<div>
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
