<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<form:errors path="user.*"></form:errors>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="./submitForm.htm" method="post">
		<table>
			<tr>
				<td>Name</td>
				<td><input type="text" name="name"/></td>
				
			
			</tr>	
			<tr>
				<td>Contact</td>
				<td><input type="text" name="contact"/></td>
			
			</tr>
			<tr>
				<td>DOB</td>
				<td><input type="text" name="dob"/></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" name="email"/></td>
			</tr>
			<tr>
				<td>SkillSet</td>
				<td>
					<select name="skillSets" multiple="multiple">
						<option value="Core Java">Core Java</option>
						<option value="Spring">Spring</option>
						<option value="Hibernate">Hibernate</option>
						<option value="Advance Java">Advance Java</option>
						<option value="Struts">Struts</option>
						<option value="JSP">JSP</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>Street</td>
				<td><input type="text" name="userAddress.street"/></td>
			</tr>
			<tr>
				<td>City</td>
				<td><input type="text" name="userAddress.city"/></td>
			</tr>
			<tr>
				<td>Zip</td>
				<td><input type="text" name="userAddress.zip"/></td>
			</tr>
			<tr>
				
				<td colspan="2"><input type="submit" value="Register"/></td>
			</tr>
		
		
		</table>
	</form>

</body>
</html>