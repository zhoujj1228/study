<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page session="false"%>
<!DOCTYPE html>
<head>
<title>registerbylist</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/style.css" />">
<script type="text/javascript" src="js/jquery-1.11.2.js"></script>
<script type="text/javascript">
	function registerbylist() {
		alert('registerbylist1');
		var testList = [];
		var user1 = {};
		user1.id = "001";
		user1.name = "001name";
		var user2 = {};
		user2.id = "002";
		user2.name = "002name";
		testList.push(user1);
		testList.push(user2);
		alert('registerbylist2');

		$.ajax({
			headers : {
				'Accept' : 'application/json',
				'Content-Type' : 'application/json'
			},
			type : 'POST',
			dataType : "json",
			data : JSON.stringify(testList),
			url : '/SpringStudy/registerbylist',
			success : function() {
				alert('success');
			}

		});
	    alert('registerbylist3');
	}

</script>
</head>
<body>
	<h1>Welcome to registerbylist</h1>


	<!-- <form action="/register/doRegister" method="POST">
	<div>id:<input type="text" name="id"/></div>
	<div>name:<input type="text" name="name"/></div>
	<div>password:<input type="text" name="pass"/></div>
	<div><input type="submit" value="register"/></div>
</form> -->

	<a href="#" onclick="registerbylist()">registerbylist</a>
</body>
</html>