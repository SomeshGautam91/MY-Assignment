<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Student Registration Page</title>
		<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
		<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
		<script>
				var myapp = angular.module("myapp", []);
				myapp.controller("StudentController",function($scope, $http) {
						
					$scope.submitData = function() {
						alert("inside submit function");
						var studentId = $scope.studentId;
						var studentName = $scope.studentName;
						var studentClass=$scope.studentClass;
						var date=$scope.feeMonth;
						var amount=$scope.studentFee;

					var studentData = {
						"studentId" : studentId,
						"studentName" : studentName,
						"studentClass":studentClass,
						"date":date,
						"amount":amount
						};
					alert(studentData);
					$http.post('http://localhost:8080/studentfeemanagementweb/web/student/studentregistrationpage',studentData)
					.success(function(data) {
						alert("success");
						$scope.students = data;		
						});

					}
			});
		
		
		
		</script>
		
	</head>
	<body ng-app="myapp" ng-controller="StudentController">
		<center>
			<form>
				<table>
					<tr>
						<td>Student Id:</td>
						<td><input type="number" ng-model="studentId" /></td>
					</tr>
					<tr>
						<td>Student Name:</td>
						<td><input type="text" ng-model="studentName" /></td>
					</tr>
					<tr>
						<td>Student Class:</td>
						<td><input type="text"  ng-model="studentClass" /></td>
					</tr>
					<tr>
						<td>Date:</td>
						<td>
							<select ng-model="feeMonth">
								<option value="January">Jan</option>
								<option value="February">Feb</option>
								<option value="March">Mar</option>
								<option value="April">Apr</option>
								<option value="May">May</option>
								<option value="June">June</option>
								<option value="July">July</option>
								<option value="August">August</option>
								<option value="September">Sept</option>
								<option value="October">Oct</option>
								<option value="November">Nov</option>
								<option value="December">Dec</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>Amount(fee):</td>
						<td><input type="number" ng-model="studentFee" /></td>
					</tr>
				
					<tr>
						<td colspan="2"><input type="button" value="Submit" ng-click="submitData()"/>
					</tr>
		
				</table>
			</form>
		</center>
		<center>
			<div>
				<table border="1" id="table1">
				<tr>
						<th>SELECT</th>
						<th>Student Id</th>
						<th>Student Name</th>
						<th>Student Class</th>
						<th>Month</th>
						<th>Paid Amount</th>
						<th>Remaining Balance</th>
						<th colspan="2">Action</th>
				</tr>

			<tr ng-repeat="student in students">
				<td><input id='radio' type='radio' value={{student.studentId}}></td>
				<td>{{student.studentId}}</td>
				<td>{{student.studentName}}</td>
				<td>{{student.studentClass}}</td>
				<td>{{student.month}}</td>
				<td>{{student.paidAmount}}</td>
				<td>{{student.remainingAmount}}</td>
				<td><input type="button" value="Delete" ng-click="remove()"/>||<input type="button" value="Update" ng-click="edit()"/></td>
					
			</tr>
		</table>
	</div>
		</center>

	</body>
</html>

