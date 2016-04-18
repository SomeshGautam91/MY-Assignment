<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form action="customer/customerregistration" modelAttribute="customerForm">
		<table border="1">
			<tr>
				<td><spring:message code="Customer.Name"></spring:message></td>
				<td><form:input type="text" path="name"></form:input></td>
			</tr>
			<tr>
				<td><spring:message code="Customer.Email"></spring:message></td>
				<td><form:input type="text" path="emailId"></form:input></td>
			</tr>		
			<tr>
				<td><form:button name="Submit">Register You</form:button></td>
			</tr>	
		
		</table>
	</form:form>

</body>
</html>