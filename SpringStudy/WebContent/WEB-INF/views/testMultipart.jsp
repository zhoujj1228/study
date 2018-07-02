<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page session="false" %>
<html> 
<head> 
<title>testMultipart</title>
</head> 
<body> 
<h1>Welcome to testMultipart</h1> 
<form method="post" action="testMultipart" enctype="multipart/form-data">
<!-- <form method="post" action="testMultipart" > -->
	<div>id:<input type="text" name="id" value="1" /></div>
	<div>name:<input type="text" name="name" value="1" /></div>
	<div>photo:<input type="file" name="profilePicture" accept="image/jpeg,image/gif,image/png" /></div>
	<div><input type="submit" value="upload"/></div>
</form>
</body> 
</html>