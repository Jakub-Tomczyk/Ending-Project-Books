<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Author Form</title>
</head>
<body>
<h1>Add Author</h1>
<form:form method="post" modelAttribute="author" action="/form">
    <form:hidden path="id"/>
    <div>
        <label>Name: <form:input path="fullName"/></label>
        <form:errors path="fullName"/>
    </div>
    <input type="submit" name="Save"/>
</form:form>

</body>
</html>
