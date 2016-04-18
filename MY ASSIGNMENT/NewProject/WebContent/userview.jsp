<%@page import="java.util.Iterator"%>
<%@ page import="java.util.ArrayList,com.yash.training.model.Users"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="1" align="center">
		<h2 align="center">USERS</h2>
		<tr>
			<th>Name</th>
			<th>Contact</th>
			<th>Email</th>
		</tr>

<%
	
		
		ArrayList<Users> users=(ArrayList<Users>)request.getAttribute("List");
		Iterator<Users> iterator=users.iterator();
		while(iterator.hasNext())
		{
			Users user=iterator.next();
			out.println("<tr>");
			
			out.println("<td>"+user.getName()+"</td>");
			out.println("<td>"+user.getContact()+"</td>");
			out.println("<td>"+user.getEmail()+"</td>");
			
			out.println("</tr>");
		}
		
%>






	</table>
</body>
</html>