<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script>
$(document).ready(function()
        {                         
              $('#btnSUM').click(function()
                            {     
                                   var sum= new Object();
                                   sum.number1= parseInt($('#number1').val());
                                   sum.number2= parseInt($('#number2').val());
                                   var jsonString=JSON.stringify(sum);
                                   var jsonobject= jQuery.parseJSON(jsonString);
                                   console.log(jsonString);
                                   console.log(jsonobject);
                                   $.ajax({                   
                                            url: 'http://localhost:8081/sumrest/call',    
                                            type: 'post', 
                                            data : jsonString,
                                            contentType: 'application/json',
                                            dataType: 'json',
                                            async: true,
                                            crossDomain : true,
                                            success: function(data)        
                                            {
                                                   //alert("success");
                                      			   $('#view').val(data);
                                            }
                                          });
                            })
        })
</script>
</head>
<body>

	<table>
		<tr>
			<td>1st Number</td>
			<td><input type="number" name="number1" id="number1"/></td>
		</tr>	
		<tr>
			<td>2nd Number</td>
			<td><input type="number" name="number2" id="number2"/><tr>
		</tr>		
	   	
		 <tr>
			<td>Result</td>
			<td><input type="text" name="result" id="view"></div></td>
		</tr>
		 <tr>
			<td></td>
			<td><input type="button" value="Sum" id="btnSUM" /><tr>
		</tr>	
	
	</table>

</body>
</html>