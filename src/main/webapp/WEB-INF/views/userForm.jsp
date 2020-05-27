<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Form</title>
</head>
<body>
<h1>User Create Form</h1>
<from:form method="post" modelAttribute="user" action="/form">
    <form:hidden path="id"/>
    <div>
        <label>Name: <form:input path="firstName"/></label>
        <form:errors path="firstName"/>
    </div>
    <div>
        <label>Surname: <form:input path="lastName"/></label>
        <form:errors path="lastName"/>
    </div>
    <div>
        <label>Password: <form:input path="password"/></label>
        <form:errors path="password"/>
    </div>
    <div>
        <label>City: <form:input path="city"/></label>
        <form:errors path="city"/>
    </div>
    <div>
        <label>About Me: <form:textarea path="aboutMe"/></label>
        <form:errors path="aboutMe"/>
    </div>
    <input type="submit" name="Save"/>
</from:form>
</body>
</html>
