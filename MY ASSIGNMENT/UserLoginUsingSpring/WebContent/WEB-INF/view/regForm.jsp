<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Registration</title>

</head>
<body>

	
	<form action="./submitForm.htm" method="post">
		<fieldset>
		<legend>User Registration</legend>
		<table>
			<tr>
				<td><spring:message code="reg.name"/></td>
				<td><input type="text" name="name"/></td>
				<td><div style="color:red"><form:errors path="user.name" /></div></td>
			</tr>	
			<tr>
				<td><spring:message code="reg.contact"/></td>
				<td><input type="number" name="contact"/></td>
				<td><div style="color:red"><form:errors path="user.contact" /></div></td>
			</tr>
		
			<tr>
				<td><spring:message code="reg.email"/></td>
				<td><input type="text" name="email"/></td>
				<td><div style="color:red"><form:errors path="user.email" /></div></td>
			</tr>
		
			<tr>
				<td><spring:message code="reg.username"/></td>
				<td><input type="text" name="username"/></td>
				<td><div style="color:red"><form:errors path="user.username" /></div></td>
			</tr>
			<tr>
				<td><spring:message code="reg.password"/></td>
				<td><input type="password" name="password"/></td>
				<td><div style="color:red"><form:errors path="user.password" /></div></td>
			</tr>
			<tr>
				
				<td colspan="2"><input type="submit" value="Register"/></td>
			</tr>
		
		</table>
	</form>
	
</fieldset>
</body>
</html>