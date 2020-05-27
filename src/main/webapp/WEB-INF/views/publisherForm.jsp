<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Publisher Form</title>
</head>
<body>
<h1>Add Publisher</h1>
<form:form method="post" modelAttribute="publisher" action="/form">
    <form:hidden path="id"/>
    <div>
        <label>Name: <form:input path="name"/></label>
        <form:errors path="name"/>
    </div>
    <input type="submit" name="Save"/>
</form:form>

</body>
</html>
