<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Show All Users</title>


<style type="text/css"> 
#mydiv {
    position:absolute;
    top: 50%;
    left: 50%;
    width:30em;
    height:18em;
    margin-top: -9em; /*set to a negative number 1/2 of your height*/
    margin-left: -15em; /*set to a negative number 1/2 of your width*/
    border: 1px solid #ccc;
    background-color: #f3f3f3;
}

</style>


<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>


<script>





$(document).ready(function(){
	var test= ${employees};
	var actFlg;
	addData(test);
	
	$("#addUser").click(function(){
		$("#addEmp").show();
		actFlg="addEmployee";
	});
	
	
	$("#editUser").click(function(){
		actFlg="editEmployee";
		var row_id= $("input[name=rd]:checked").val();
		if(row_id== undefined || row_id==null){
			alert("Please select appropriate row");
			return;
		}
		$("#addEmp").show();
		$("#emp_id").val($("tr#"+row_id).find("td:nth-child(2)").text());
		$("#emp_name").val($("tr#"+row_id).find("td:nth-child(3)").text());
		$("#emp_desig").val($("tr#"+row_id).find("td:nth-child(4)").text());
		$("#emp_loc").val($("tr#"+row_id).find("td:nth-child(5)").text());
		$("#emp_depart").val($("tr#"+row_id).find("td:nth-child(6)").text());	
	}); 
	
	
	
	$("#btnCancel").click(function(){
		$("#addEmp").hide();
	});
	
	$("#btnAdd").click(function(){
		var emp_id=$("#emp_id").val();
		var emp_name=$("#emp_name").val();
		var emp_desig=$("#emp_desig").val();
		var emp_loc=$("#emp_loc").val();
		var emp_depart=$('#emp_depart').val();
		var formData={'emp_id':emp_id,'emp_name':emp_name,'emp_desig':emp_desig,'emp_loc':emp_loc,'emp_depart':emp_depart};
		
		if(actFlg=="addEmployee"){
			$.ajax({ 
				type : "POST",	
				url : "EmployeeController?action=addEmployee",
				data : formData, 
				async : false, 
				error : function(data) { alert("Error"); },
				success : function(data, textStatus) {	
					alert(textStatus);
					$("#addEmp").hide();
					$("#tblGrid tbody").empty();
					addData(data);
				}
			});
		}
		
		if(actFlg=="editEmployee"){
			$.ajax({ 
				type : "POST",	
				url : "EmployeeController?action=editEmployee",
				data : formData, 
				async : false, 
				//dataType : "json",
				error : function(data) { alert("Error"); },
				success : function(data, textStatus) {	
					$("#addEmp").hide();
					$("#tblGrid tbody").empty();
					addData(data);
				}
			});
		}
	});
	
	$("#delUser").click(function(){
		var emp_id= $("input[name=rd]:checked").val();
		var formData={'emp_id':emp_id};
		var conf=confirm("Are you sure you want to delete selected record?");
		if(conf){
			$.ajax({ 
				type : "POST",	
				url : "EmployeeController?action=deleteEmployee",
				data : formData, 
				async : false, 
				//dataType : "json",
				error : function(data) { alert("Error"); },
				success : function(data, textStatus) {	
					$("#tblGrid tbody").empty();
					addData(data);
				}
			});
		}else{
			return;
		}
	});
	
	function addData(data){
		$.each(data, function(index, emp){
			$("#tblGrid tbody").append("<tr id="+emp.emp_id+"><td><input name='rd' type='radio' value='"+emp.emp_id+"'/></td><td>"+emp.emp_id+"</td><td>"+emp.emp_name+"</td><td>"+emp.emp_loc+"</td><td>"+emp.emp_desig+"</td><td>"+emp.emp_depart+"</td>");
		});
	}
	
});

</script>
</head>
<body>
<center>

<%! int counter; %>
<%
	out.print(++counter);
%>

<div id="addEmp" style="display:none;border:1px solid #000; padding:8px;background-color:#fff; margin:8px;width:400px; height:250px; position:absolute; z-index:12345; top: 30%;  left: 35%;">
		
		<form id="frmAddEmp" name="frmAddEmp">
		EMP ID:<br/>
		<input type="text" name="emp_id" id="emp_id" value="" /><br/>
		EMP Name:<br/>
		<input type="text" name="emp_name" id="emp_name" value="" /><br/>
		EMP Designation:<br/>
		<select name="emp_desig" id="emp_desig">
			<option value="PM">PM</option>
			<option value="TL">TL</option>
			<option value="ML">ML</option>
			<option value="SSE">SSE</option>
			<option value="SE">SE</option>
			<option value="Trainee">Trainee</option>
		</select><br/>
		EMP Location:<br/>
		<select name="emp_loc" id="emp_loc">
			<option value="Bangalore">Bangalore</option>
			<option value="Chennai">Chennai</option>
			<option value="Gurgaon">Gurgaon</option>
			<option value="Hyderabad">Hyderabad</option>
			<option value="Indore">Indore</option>
			<option value="Mumbai">Mumbai</option>
			<option value="Pune">Pune</option>
		</select><br/>
		EMP Department:<br/>
		<select name="emp_depart" id="emp_depart">
			<option value="Java">Java</option>
			<option value="SAP">SAP</option>
			<option value="Testing">Testing</option>
			
		</select>
		<br/><br/>
			<input type="button" value="ADD EMPLOYEE" id="btnAdd" />&nbsp;
			<input type="reset" value="CANCEL" id="btnCancel" />
		</form>
</div>



    <table border=1 id="tblGrid">
        <thead>
            <tr style="green">
            	<th></th>
                <th>Employee Id</th>
                <th>Employee Name</th>
                <th>Designation</th>
                <th>Location</th>
                <th>Department</th>
            </tr>
        </thead>
        <tbody>
           
        </tbody>
    </table>
    <p>
	    <a id="addUser" href="javascript:void(0);">Add User</a>&nbsp;&nbsp;
	    <a id="editUser" href="javascript:void(0);">Update User</a>&nbsp;&nbsp;
	    <a id="delUser" href="javascript:void(0);">Delete User</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	    <a href="javascript:history.back();">Back</a>
	</p>
	</center>
</body>
</html>