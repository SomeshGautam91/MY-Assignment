<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="userwelcome.jsp"></jsp:include>
<center>
<table border="1" style="position:relative;top:170px">
	<tr>
		<th>Name</th>
		<th>Contact</th>
		<th>Email</th>
		<th>Address</th>
		<th>Operation</th>
	</tr>
	<c:forEach items="${contacts}" var="contact">
		
	<tr>
		<td><c:out value="${contact.name}"/></td>
		<td><c:out value="${contact.contact}"/></td>
		<td><c:out value="${contact.email}"/></td>
		<td><c:out value="${contact.address}"/></td>
		<td><a href="../contact/deleteContact.htm?uid=${contact.id}">Delete</a><a href="../contact/updateContact1.htm?uid=${contact.id}&uname=${contact.name}&ucontact=${contact.contact}&uemail=${contact.email}&uaddress=${contact.address}">Edit</a></td>
		
	</tr>
	</c:forEach>
</table>
</center>
</body>
</html>