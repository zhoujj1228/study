<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page session="false" %>
<html> 
<head> 
<title>register</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css" />" > 
</head> 
<body> 
<h1>Welcome to register</h1> 


<!-- <form action="/register/doRegister" method="POST">
	<div>id:<input type="text" name="id"/></div>
	<div>name:<input type="text" name="name"/></div>
	<div>password:<input type="text" name="pass"/></div>
	<div><input type="submit" value="register"/></div>
</form> -->

<form method="POST">
	<div>id:<input type="text" name="id"/></div>
	<div>name:<input type="text" name="name"/></div>
	<div><input type="submit" value="register"/></div>
</form>
</body> 
</html>