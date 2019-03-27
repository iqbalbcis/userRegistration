<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1252">
<title>Login form</title>

<link rel="stylesheet" href="<c:url value="/css/formError_and_others.css" />">

</head>
<body>

	<h1 class="forheader">Login User</h1>
	<form:form action="/Maven_webapp/submit.html" method="POST"
		modelAttribute="userCommand">
		<table id="table_format">
			<tr>
				<td></td>
				<td><form:errors path="*" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="username">Username</form:label></td>
				<td><form:input path="username" /></td>
				<%-- <td><form:errors path="username" cssClass="error" /></td> --%>
			</tr>
			<tr>
				<td><form:label path="password">Password</form:label></td>
				<td><form:password path="password" /></td>
				<%-- <td><form:errors path="password" cssClass="error" /></td> --%>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Login" class="buttonsize"/></td>
			</tr>
			<tr>
				<td></td>
				<td><a href="/Maven_webapp/registration.html">Not registered?</a></td>
			</tr>
		</table>

	</form:form>

</body>
</html>

<!-- //=======================================================================================
<a href="registration">Registration Form</a>
<a href="registration.html">Registration Form</a> it will come with html extension -->