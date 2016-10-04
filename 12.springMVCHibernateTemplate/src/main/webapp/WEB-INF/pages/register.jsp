<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<body>
	<form:form modelAttribute="student" method="post">
        <div>
            <label>name:</label>
            <form:input path="name"/>
            <form:errors path="name"/>
        </div>
        <div>
            <label>age:</label>
            <form:input path="age"/>
            <form:errors path="age"/>
        </div>
        <div>
            <label>sex:</label>
            <form:input path="sex"/>
            <form:errors path="sex"/>
        </div>
        <div>
            <input type="submit" value="submit"/>
        </div>
    </form:form>
</body>
</html>