<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.js"></script>
<script>
	$(document).ready(function(){
		$("#contactForm").show();
	});



</script>


</head>
<body>

	<form action="#" id="contactForm">
		<table>
			<tr>
				<td>Name</td>
				<td><input type="text" name="contactName" id="contactName"/></td>
			</tr>	
			<tr>
				<td>Contact</td>
				<td><input type="number" name="contactNo" id="contactNo"/></td>
			</tr>	
			<tr>
				<td>Email</td>
				<td><input type="text" name="contactEmail" id="contactEmail"/></td>
			</tr>	
			<tr>
				<td>Address</td>
				<td><input type="text" name="contactAddress" id="contactAddress"/></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Save" id="contactName"/></td>
			</tr>		
		
		
		</table>
	</form>

</body>
</html>