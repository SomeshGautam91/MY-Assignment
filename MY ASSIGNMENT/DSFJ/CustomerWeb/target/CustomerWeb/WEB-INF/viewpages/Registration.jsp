<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script>
	$(document).ready(function() {
		$('#btnSUBMIT').click(function() {
			alert("hello");
			
			$.ajax({
				url : 'http://localhost:8080/CustomerWeb/web/customer/customerregistration',
				type : 'post',
				data : {"name":$('#name').val(),"emailId":$('#emailId').val()},
				error : function(data) { alert(data); },
				success : function(data,textStatus) {
					alert("success");
					$("#tblGrid tbody").empty();
					$.each(data, function(index, customer){
						$("#tblGrid tbody").append("<tr id="+customer.id+"><td><input name='rd' type='radio' value='"+customer.id+"'/></td><td>"+customer.id+"</td><td>"+customer.name+"</td><td>"+customer.emailId+"</td><td><input type='button' id='btnEdit' value='EDIT'/></td><td><input type='button' id='btnDelete' value='DELETE'/></td>"
								);
					}); 
 
				}
			});
		})
		
	
		$('#btnEDIT').click(function() {
			alert("IN EDIT");
			
			$.ajax({
				url : 'http://localhost:8080/CustomerWeb/web/customer/customerregistration',
				type : 'post',
				data : {"name":$('#name').val(),"emailId":$('#emailId').val()},
				error : function(data) { alert(data); },
				success : function(data,textStatus) {
					alert("success");
					$("#tblGrid tbody").empty();
					$.each(data, function(index, customer){
						$("#tblGrid tbody").append("<tr id="+customer.id+"><td><input name='rd' type='radio' value='"+customer.id+"'/></td><td>"+customer.id+"</td><td>"+customer.name+"</td><td>"+customer.emailId+"</td><td><input type='button' id='btnEDIT' value='EDIT'/></td><td><input type='button' id='btnDelete' value='DELETE'/></td>"
								);
					}); 

				}
			});
		})
	
	
	
	})
</script>

</head>
<body>
	<center>
	<center>User Registration</center>
	<form:form  modelAttribute="customerForm">
		<table class=>
			<tr>
				<td><spring:message code="Customer.Name"></spring:message></td>
				<td><form:input type="text" path="name" id="name"></form:input></td>
				<td><form:errors cssClass="errors" path="name"></form:errors></td>
			</tr>
			<tr>
				<td><spring:message code="Customer.Email"></spring:message></td>
				<td><form:input type="text" path="emailId" id="emailId"></form:input></td>
				<td><form:errors cssClass="errors" path="emailId"></form:errors></td>
			</tr>
			<tr>
				<td colspan="2"><input type="button" value="Register"
					id="btnSUBMIT" />
			</tr>

		</table>
	</form:form>
	</center>
	
	<center>
	<table  border="2" id="tblGrid" style="margin-top: 30px;">
		<thead>
			<th></th>
			<th >Id</th>
			<th >Name</th>
			<th >EmailId</th>
			<th colspan="2">Action</th>
		</thead>
		<tbody >
		
		</tbody>
	</center>
	
	</table>
	

</body>
</html>