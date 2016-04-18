<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script>
	$(document).ready(function(){
		var actFlg;
		$('#addFormDiv').hide();
		$("#view").empty();
			$.ajax({
						type:'POST',
						url:'http://localhost:8080/sumrest/fetchAllUser',
						contentType:'application/json',
						dataType:'json',
						async:true,
						error:function(data){alert("error")},
						crossDomain:true,
						success:function(data)
						{
							
							$.each(data,function(key,value)
							{
								$("#view").append("<tr id="+value.userId+"><td><input name='rd' type='radio' value='"+value.userId+"'/></td><td>"+value.userId+"</td><td>"+value.name+"</td><td>"+value.location+"</td></tr>");
							});
							$("#result").html("Total Records:"+data.length);
						}
		
		
	      		});
		
	
		$('#btnADD').click(function(){
			actFlg="addEmployee";
			$('#addFormDiv').show();
		
		});
		
		$("#btnSave").click(function(){
			
			
			var User= new Object();
            User.userId= parseInt($('#userid').val());
            User.name=$('#username').val();
            User.location=$('#userlocation').val();
            
            var jsonString=JSON.stringify(User);
            
            $("#view").empty();
            $('#addFormDiv').hide();
            if(actFlg=="editEmployee")
            {
            	
            $.ajax({
						type:'put',
						url:'http://localhost:8080/sumrest/updateUser',
						contentType:'application/json',
						dataType:'json',
						data:jsonString,
						async:true,
						error:function(data){alert("error")},
						crossDomain:true,
						success:function(data)
						{
							
							$.each(data,function(key,value)
							{
								$("#view").append("<tr id="+value.userId+"><td><input name='rd' type='radio' value='"+value.userId+"'/></td><td>"+value.userId+"</td><td>"+value.name+"</td><td>"+value.location+"</td></tr>");
							});
							$("#result").html("1 record updated");
							$("#newresult").html(data.length+" record(s) found");
							
						}


  				});
            }
            if(actFlg=="addEmployee")
            {
            	$.ajax({
							type:'POST',
							url:'http://localhost:8080/sumrest/insertUser',
							contentType:'application/json',
							dataType:'json',
							data:jsonString,
							async:true,
							error:function(data){alert("error")},
							crossDomain:true,
							success:function(data)
							{
						
								$.each(data,function(key,value)
								{
									$("#view").append("<tr id="+value.userId+"><td><input name='rd' type='radio' value='"+value.userId+"'/></td><td>"+value.userId+"</td><td>"+value.name+"</td><td>"+value.location+"</td></tr>");
								});
								$("#result").html("1 record added");
								$("#newresult").html(data.length+" record(s) found");
								
							}

						});
            	
            		}
			
			
			
		});
		
		$("#btnDelete").click(function()
		{
		
			var user_id= $("input[name=rd]:checked").val();
			var user=new Object();
// 			user.userId=user_id;
			var jsonString=JSON.stringify(user);
			$("#view").empty();
			var conf=confirm("Are you sure you want to delete selected record?");
			if(conf){
				$.ajax({ 
					type : 'DELETE',	
					url : "http://localhost:8080/sumrest/deleteUser"+ '/' + user_id,
					contentType:'application/json',
					data : jsonString, 
					async : true, 
					dataType : 'json',
					error : function(data) { alert("Error"); },
					success:function(data)
					{
						
						$.each(data,function(key,value)
						{
							$("#view").append("<tr id="+value.userId+"><td><input name='rd' type='radio' value='"+value.userId+"'/></td><td>"+value.userId+"</td><td>"+value.name+"</td><td>"+value.location+"</td></tr>");
						});
						$("#result").html("1 record deleted");
						$("#newresult").html(data.length+" record(s) found");
					}

				});
			}
			else
			{
				return;
			}
		});
		
		
		
		
		
		
		
		
        $("#btnSEARCH").click(function(){
			
			var searchData=$("#txtSEARCH").val();
			var user=new Object();
			if($.isNumeric(searchData))
			{
				
				user.userId=parseInt(searchData);
				var jsonString=JSON.stringify(user);
				$("#view").empty();
			    $('#addFormDiv').hide();
			    $.ajax({
					type:'POST',
					url:'http://localhost:8080/sumrest/searchUserById',
					contentType:'application/json',
					dataType:'json',
					data:jsonString,
					async:true,
					error:function(data){alert("error")},
					
					success:function(data)
					{
					
						$.each(data,function(key,value)
						{
							$("#view").append("<tr id="+value.userId+"><td><input name='rd' type='radio' value='"+value.userId+"'/></td><td>"+value.userId+"</td><td>"+value.name+"</td><td>"+value.location+"</td></tr>");
						});
						$("#result").html(data.length+" record(s) found");
					}


				});
				
			}
			else
			{
				user.name=searchData;
				user.location=searchData;
				var jsonString=JSON.stringify(user);
		        $("#view").empty();
		        $('#addFormDiv').hide();
		     	$.ajax({
								type:'POST',
								url:'http://localhost:8080/sumrest/searchUserByName',
								contentType:'application/json',
								dataType:'json',
								data:jsonString,
								async:true,
								error:function(data){alert("error")},
								
								success:function(data)
								{
									
									$.each(data,function(key,value)
									{
										$("#view").append("<tr id="+value.userId+"><td><input name='rd' type='radio' value='"+value.userId+"'/></td><td>"+value.userId+"</td><td>"+value.name+"</td><td>"+value.location+"</td></tr>");
										
									});
									$("#result").html(data.length+" record(s) found");
								}


		  				});
				
			}
            
           
			
			
			
		});
        
        $("#btnEdit").click(function(){
        	actFlg="editEmployee";
    		var userid= $("input[name=rd]:checked").val();
    		if(userid== undefined || userid==null)
    		{
    			alert("Please select appropriate row");
    			return;
    		}
    		$("#addFormDiv").show();
    		$("#userid").val($("tr#"+userid).find("td:nth-child(2)").text());
    		$("#username").val($("tr#"+userid).find("td:nth-child(3)").text());
    		$("#userlocation").val($("tr#"+userid).find("td:nth-child(4)").text());
    		
    	}); 
		
		
	});


</script>
</head>
<body>
		<center>
		
		<input type="button" value="ADDUser" id="btnADD" style="margin-top:10px"/>
		<input type="text" name="txtSEARCH" id="txtSEARCH" style="margin-top:10px"/>
		<input type="button" value="search" id="btnSEARCH" style="margin-top:10px"/>
		
		<table border="1" style="margin-top:30px">
			<thead>
				<th></th>
				<th>User_Id</th>
				<th>Name</th>
				<th>Location</th>
			</thead>
			<tbody  id="view">
			</tbody >	
		</table>
		
		<p id="result"></p>
		<p id="newresult"></p>
		
		<input type="button" value="Delete" id="btnDelete" style="margin-top:10px; position:relative;"/>&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="button" value="EDIT" id="btnEdit" style="margin-top:10px"/>
		
		</center>
		
		<center style="margin-top:30px; position:relative;">
		<div id="addFormDiv">
			<table border="1">
				<tr>
					<td>User_Id</td>
					<td><input type="text" name="userid" id="userid"/></td>	
				</tr>
			
				<tr>
					<td>User_Name</td>
					<td><input type="text" name="username" id="username"/></td>	
			
				</tr>
				<tr>
					<td>User_Location</td>
					<td><input type="text" name="userlocation" id="userlocation"/></td>	
			
				</tr>
				<tr>
					<td></td>
					<td><input type="button" value="ADD" id="btnSave"/></td>	
			
				</tr>
			</table>	
		</div>
		</center>

</body>
</html>