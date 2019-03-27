<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1252">
<title>Register new user</title>

<link rel="stylesheet" href="<c:url value="/css/formError_and_others.css" />">

</head>

<body>
	<h3 class="spaceRight"><a href="/Maven_webapp/viewAllUsers.html">View all data</a></h3>
	<h1 class="forheader">Register New User</h1>
	
	<form:form action="/Maven_webapp/addUser.html" method="POST" modelAttribute="userCommand">
		<table id="table_format">
			<tr>
				<td><form:label path="username">Username</form:label></td>
				<td><form:input path="username" /></td>
				<%-- <td><form:errors path="username" cssClass="error"/></td> --%>
			</tr>
			<tr>
				<td></td>
				<td><form:errors path="username" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label path="password">Password</form:label></td>
				<td><form:password path="password" /></td>
				<%-- <td><form:errors path="password" cssClass="error"/></td> --%>
			</tr>
			<tr>
				<td></td>
				<td><form:errors path="password" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label path="password2">Retype Password</form:label></td>
				<td><form:password path="password2" /></td>
				<%-- <td><form:errors path="password2" cssClass="error"/></td> --%>
			</tr>
			<tr>
				<td></td>
				<td><form:errors path="password2" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label path="sex">Sex</form:label></td>
				<td><form:radiobutton path="sex" value="M" label="Male" />&nbsp;&nbsp;&nbsp;
					<form:radiobutton path="sex" value="F" label="Female" /></td>
				<%-- <td><form:errors path="sex" cssClass="error"/></td> --%>
			</tr>
			<tr>
				<td></td>
				<td><form:errors path="sex" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label path="email">Email</form:label></td>
				<td><form:input path="email" /></td>
				<%-- <td><form:errors path="email" cssClass="error"/></td> --%>
			</tr>
			<tr>
				<td></td>
				<td><form:errors path="email" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label path="dateOfBirth">Date of birth</form:label></td>
				<td><form:select path="dobDay" items="${dobDays}" /> <form:select
						path="dobMonth" items="${dobMonths}" /> <form:select
						path="dobYear" items="${dobYears}" /></td>
				<%-- <td><form:errors path="dateOfBirth" cssClass="error"/></td> --%>
			</tr>
			<tr>
				<td></td>
				<td><form:errors path="dateOfBirth" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label path="ddate">Joining Date</form:label></td>
				<td><input type="date" name="ddate" id="datepicker" value="2019-01-01"></td>
				<%-- <td><form:errors path="ddate" cssClass="error"/></td> --%>
			</tr>
			<tr>
				<td></td>
				<td><form:errors path="ddate" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label path="subcription">Subscription</form:label></td>
				<td><form:input path="subcription" /></td>
				<%-- <td><form:errors path="subcription" cssClass="error"/></td> --%>
			</tr>
			<tr>
				<td></td>
				<td><form:errors path="subcription" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label path="addressLine">Address Line</form:label></td>
				<td><form:input path="addressLine" /></td>
				<%-- <td><form:errors path="addressLine" cssClass="error"/></td> --%>
			</tr>
			<tr>
				<td></td>
				<td><form:errors path="addressLine" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label path="postcode">UK Postcode</form:label></td>
				<td><form:input path="postcode" /></td>
				<%-- <td><form:errors path="postcode" cssClass="error"/></td> --%>
			</tr>
			<tr>
				<td></td>
				<td><form:errors path="postcode" cssClass="error"/></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Register" class="buttonsize"/></td>
			</tr>
			
		</table>
		
	</form:form>
	
	<script src="<c:url value="/js/all.js"/>"></script>
</body>
</html>