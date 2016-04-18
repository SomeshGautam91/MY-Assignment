<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Controller Servlet</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script>


$(document).ready(function(){
	
	if($('#rememberme').is(':checked'))
	{
		document.getElementById("name").value=localStorage.getItem("name");
		document.getElementById("password").value=localStorage.getItem("password");
		
	}
	
	$("#submit").click(function(){
		
		if($('#rememberme').is(':checked'))
		{
			
			localStorage.setItem("name",document.getElementById("name").value);
			localStorage.setItem("password",document.getElementById("password").value);
			
		
		}
			
	});
});

</script>

</head>
<body>
<center>
<form action="CS" method="post"> 
<table >
     <tr>
     	<td>Name:</td>
	 	<td><input type="text" name="name" id="name"/></td>
	 </tr>
	 <tr>
     	<td>Password:</td>
	 	<td><input type="password" name="password" id="password"/></td>
	 </tr>
	<tr>
		<td></td>
		<td><input type="checkbox" name="rememberme"  id="rememberme" value=false/>Remember Me</td>
		
	</tr>
	<tr>
		<td></td>
		<td><input type="submit" value="Login" id="submit"/>&nbsp;&nbsp;&nbsp;<a href="Register.jsp">Register</a></td>
		
	</tr>
	

</table>
</form> 
</center>
</body>
</html>