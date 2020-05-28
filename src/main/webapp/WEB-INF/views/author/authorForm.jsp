<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Author Form</title>
</head>
<body>
<from:form method="post" modelAttribute="author" action="/formAuthor">
    <form:hidden path="id"/>
    <div>
        <label>Name: <form:input path="name"/></label>
        <form:errors path="name"/>
    </div>
    <div>
        <label>Surname: <form:input path="surname"/></label>
        <form:errors path="surname"/>
    </div>
</from:form>

</body>
<div>
    Home page-
    <a href="/home"> home page </a>
</div>
</html>
