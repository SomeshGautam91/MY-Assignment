<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<form action="EmployeeController">
			<h2 align="center">LOGIN</h2>
			<table align="center">
				<tr>
					<td>UserName</td>
					<td><input type="text" name="username"/></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password"/></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="SUBMIT"/>&nbsp;&nbsp;<a href="EmployeeController">Registration</a></td>
				</tr>
				
			</table>		
		
		</form>

	</body>
</html>