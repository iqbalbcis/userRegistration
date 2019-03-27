<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1252">
<title>Edit for update</title>

<link rel="stylesheet" href="<c:url value="/css/formError_and_others.css" />">

</head>

<body>
	<h1 class="forheader">Edit user for update</h1>
	
	<form:form action="/Maven_webapp/updateUser.html" method="POST" modelAttribute="userCommand">
		<table id="table_format">
			
			<spring:message code="label.input.dateformat" var="placeholder" />
			<tr>
				<%-- <td><form:label path="userId">User Id</form:label></td> --%>
				<td><form:hidden path="userId" /></td>
			</tr>
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
				<td><form:input path="dateOfBirth" title="${placeholder}" /></td>
				<!-- use sql date in moodel, otherwise date can't be map with @Modelattribute when form:input display the date -->
				<%-- <td><form:errors path="dateOfBirth" cssClass="error"/></td>  --%>
			</tr>
			<tr>
				<td></td>
				<td><form:errors path="dateOfBirth" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label path="ddate">Joining Date</form:label></td>
				<td><form:input path="ddate" title="${placeholder}" /></td>
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
				<td><input type="submit" value="Update" class="buttonsize"/></td>
			</tr>
			
		</table>
	</form:form>
</body>
</html>