<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="./updateContact.htm?">
		
		<table>
		    
			<tr>
				<td>Name</td>
				<td><input type="text" value=${contact.name} name="name" /></td>
				
			</tr>	
			<tr>
				<td>Contact</td>
				<td><input type="number" value=${contact.contact}  name="contact"/></td>
				
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" value=${contact.email} name="email"/></td>
				
			</tr>
			<tr>
				<td>Address</td>
				<td><input type="text" value=${contact.address} name="address"/></td>
				
			</tr>
			<tr>
				
				<td colspan="2"><input type="submit" value="UPDATE"/></td>
			</tr>
			
		</table>
		</form>	

</body>
</html>