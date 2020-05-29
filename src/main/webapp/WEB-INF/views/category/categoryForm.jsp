<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Category Form</title>
</head>
<body>
<from:form method="post" modelAttribute="category" action="/formCategory">
    <form:hidden path="id"/>
    <div>
        <label>Name: <form:input path="categoryName"/></label>
        <form:errors path="categoryName"/>
    </div>
    <input type="submit" name="Save"/>
</from:form>

<div>
    Home page-
    <a href="/home"> home page </a>
</div>
</body>
</html>
