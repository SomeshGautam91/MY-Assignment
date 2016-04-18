<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Login</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<center>
	<form action="./loginFormSubmit.htm" method="post">
		<fieldset style="width:300px " >
		<legend>User Login</legend>
		<table>
			<tr>
				<td style="color:red">Username</td>
				<td><input type="text" name="username"/></td>
				
			</tr>	
			<tr>
				<td style="color:red">password</td>
				<td><input type="password" name="password"/></td>
				
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Login" style="color:red"/></td>
			</tr>
			
			</table>
			</fieldset>
	</form>
</center>
</body>
</html>