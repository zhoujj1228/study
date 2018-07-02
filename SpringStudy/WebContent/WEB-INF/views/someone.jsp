<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page session="false" %>
<html> 
<head> 
<title>getOneById byPath</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css" />" > 
</head> 
<body> 
<h1>Welcome to getOneById byPath</h1> 
<div><c:out value="${testDomain.id }"></c:out></div>
<div><c:out value="${testDomain.name }"></c:out></div>
</body> 
</html>