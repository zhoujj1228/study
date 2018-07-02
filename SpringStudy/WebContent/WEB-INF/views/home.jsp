<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page session="false" %>
<html> 
<head> 
<title>Spittr</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css" />" > 
</head> 
<body> 
<h1>Welcome to Spittr</h1> 
<a href="<c:url value="/list" />">list</a> |
<a href="<c:url value="/listByNum?start=1&end=4" />">listByNum </a> |
<a href="<c:url value="/getSomeOne/id2" />">getSomeOneById </a> |
<a href="<c:url value="/register" />">Register</a> |
<a href="<c:url value="/testMultipart" />">testMultipart</a> |
<a href="<c:url value="/testExceptionToHttpStatus" />">testExceptionToHttpStatus</a> |
<a href="<c:url value="/testControllerExceptionHandler" />">testControllerExceptionHandler</a> |
<a href="<c:url value="/testPlaceHolderRedirect" />">testControllerExceptionHandler</a> |
<a href="<c:url value="/testFlashAttrRedirect" />">testControllerExceptionHandler</a> |
</body> 
</html>