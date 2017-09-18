<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>

#container {
	width: 1000px;
	margin: 0px auto;
}



</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New Dojo</title>
</head>
<body>

    
   	<div id="container">
   	
   	<h1>New Dojo</h1>
   	
	<form:form method="POST" action="/newDojo" modelAttribute="dojo">
		<form:hidden path="id"/>
	    <form:label path="name">Name
	    <form:errors path="name"/>
	    <form:input path="name"/></form:label><br>
	    
	    <input type="submit" value="Create"/>
	</form:form>
	<br>
	<a href="/newNinja">Add Ninja</a><br>


	</div>

</body>
</html>