<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book Form</title>
</head>
<body>
<h1>Add Book Form</h1>
<from:form method="post" modelAttribute="book" action="/form">
    <form:hidden path="id"/>
    <div>
        <label>Title: <form:input path="title"/></label>
        <form:errors path="title"/>
    </div>
    <div>
        <label>Author: <form:input path="author"/></label>
        <form:errors path="author"/>
    </div>
    <div>
        <label>Publisher: <form:input path="publisher"/></label>
        <form:errors path="publisher"/>
    </div>
    <div>
        <label>Description: <form:textarea path="city"/></label>
        <form:errors path="city"/>
    </div>
    <div>
        <label>Rating: <form:select path="aboutMe"/></label>
        <form:errors path="aboutMe"/>
    </div>
    <input type="submit" name="Save"/>
</from:form>
</body>
</html>
