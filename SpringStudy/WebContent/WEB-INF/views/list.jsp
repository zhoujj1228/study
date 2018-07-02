<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page session="false" %>
<html> 
<head> 
<title>list</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css" />" > 
</head> 
<body> 
<h1>Welcome to list</h1> 
<a href="<c:url value="/list" />">Spittles</a> |
<a href="<c:url value="/spitter/register" />">Register</a> 

<c:forEach items="${testList}" var="testDomain">
	<li id="testDomain_<c:out value="testDomain.id"/>">
		<div class="testDomainId">
			<c:out value="${testDomain.id }"></c:out>
		</div>
		<div class="testDomainName">
			<c:out value="${testDomain.name }"></c:out>
		</div>
	</li>
</c:forEach>
</body> 
</html>