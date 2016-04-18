<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <script src="//code.jquery.com/jquery-1.9.1.js"></script>
 <script src="//ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"></script>
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script>
  
  
  $(function() {
  
    
    $("#registerForm").validate({
       
    	rules: {
            name: "required",
            contact:{
                required: true,
                maxlength:10
            },
            email: {
                required: true,
                email: true
            },
            password: {
                required: true,
                minlength: 5,
                maxlength:10
            },
            agree: "required"
        },
        
        
        messages: { 
        	name: 
        		{
        		required:"Please enter your first name",
        		maxlength:"Contact must be of 10 digits"
        		},
        	
            contact: "Please enter your contact no.",
            password: {
                required: "Please provide a password",
                minlength: "Your password must be at least 5 characters long"
            },
            email: "Please enter a valid email address",
            agree: "Please accept our policy"
        },
        
        submitHandler: function(form) {
            form.submit();
        }
    });

  });
  </script>
</head>
<body>
<form action="RVS" method="post" id="registerForm">
<table>
	<tr>
		<td>Name<td>
		<td><input type="text" name="name"/></td>
	</tr>	
	<tr>
		<td>ContactNo<td>
		<td><input type="text" name="contact"/></td>
	</tr>	
	<tr>
		<td>Email<td>
		<td><input type="text" name="email"/></td>
	</tr>
	<tr>
		<td>Password<td>
		<td><input type="password" name="password"/></td>
	</tr>	
	<tr>
		<td><td>
		<td><input type="submit"  value="Submit"/></td>
	</tr>			

</table>
</form>
</body>
</html>