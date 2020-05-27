<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Category Form</title>
</head>
<body>
<h1> Add Category </h1>
<form:form method="post" modelAttribute="category" action="/form">
    <form:hidden path="id"/>
    <div>
        <label>Name: <form:input path="nameCategory"/></label>
        <form:errors path="nameCategory"/>
    </div>
    <input type="submit" name="Save"/>
</form:form>
</body>
</html>
