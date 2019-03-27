<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1252">
<title>Individual data</title>

<link rel="stylesheet"
	href="<c:url value="/css/styleForDispalyTable.css" />">

</head>
<body>
	<a href="/Maven_webapp/login.html">Logout </a>
	<br />
	<br />
	<%=request.getSession().getAttribute("userLogged") + " is logged"%><br />
	<br />

	<form>
		<!-- i don't need any action for this form  -->
		<table border="1" class="tableFormatter">
			<thead>
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Sex</th>
					<th>Email</th>
					<th>Date of Birth</th>
					<th>Joining Date</th>
					<th>Subscription</th>
					<th>Address</th>
					<th>Post Code</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="user" items="${list}">
					<tr>
						<td>${user.userId}</td>
						<td>${user.username}</td>
						<td>${user.sex}</td>
						<td>${user.email}</td>
						<td>${user.dateOfBirth}</td>
						<td>${user.ddate}</td>
						<td>${user.subcription}</td>
						<td>${user.addressLine}</td>
						<td>${user.postcode}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</form>
</body>
</html>
