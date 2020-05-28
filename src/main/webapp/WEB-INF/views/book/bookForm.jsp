<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book Form</title>
</head>
<body>
<h1>Add Book Form</h1>
<from:form method="post" modelAttribute="book" action="/formBook">
    <form:hidden path="id"/>
    <div>
        <label>Title: <form:input path="title"/></label>
        <form:errors path="title"/>
    </div>
    <div>
        <label>Author: <from:select path="author" items="${authors}" itemLabel="fullName" itemValue="id" multiple="true"/></label>
        <form:errors path="author"/>
    </div>
    <div>
        <label>Publisher: <form:select path="publisher" items="${publishers}" itemLabel="publisher" itemValue="id" multiple="true" /></label>
        <form:errors path="publisher"/>
    </div>
    <div>
        <label>Description: <form:textarea path="description"/></label>
        <form:errors path="description"/>
    </div>
    <div>
        <label>Rating: <form:select path="rating" items="${ratings}"  multiple="false"/></label>
        <form:errors path="rating"/>
    </div>
    <div>
        <label>Category: <from:select path="category" items="${categories}" itemLabel="category" itemValue="id" multiple="true"/></label>
        <from:errors path="category"/>
    </div>
    <input type="submit" name="Save"/>
</from:form>
</body>
<div>
    Home page-
    <a href="/home"> home page </a>
</div>
</html>
