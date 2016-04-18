<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Registration Page</title>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script>
	var myapp = angular.module("myapp", []);
	myapp
			.controller(
					"StudentController",
					function($scope, $http) {

						$scope.idDisable = false;
						$scope.nameDisable = false;
						$scope.classDisable = false;
						$scope.monthDisable = false;
						$scope.feeDisable = false;
						$scope.btnDisable = false;
						$scope.tableDisable = true;
						var check;

						$scope.submitData = function() {

							alert("inside submit function");
							var remainingAmount;
							var studentId = $scope.studentId;
							var studentName = $scope.studentName;
							var studentClass = $scope.studentClass;
							var month = $scope.feeMonth;
							var paidAmount = $scope.studentFee;

							alert("paidAmount" + paidAmount);
							if (paidAmount < 10000) {
								remainingAmount = 10000 - paidAmount;
							}
							if (paidAmount == 0) {
								remainingAmount = 10000;
							}
							var studentData = {
								"studentId" : studentId,
								"studentName" : studentName,
								"studentClass" : studentClass,
								"month" : month,
								"paidAmount" : paidAmount,
								"remainingAmount" : remainingAmount
							};
							if (check == true) {
								$http.post(
												'http://localhost:8090/studentfeemanagementweb/student/updateStudentUsingId',
												studentData)
										.success(function(data) {
											alert("success");
											$scope.tableDisable = false;
											$scope.students = data;
										});

							} else {
								$http.post('http://localhost:8090/studentfeemanagementweb/student/studentregistrationpage',studentData)
								.success(function(data) {
											alert("success");
											$scope.tableDisable = false;
											$scope.students = data;
										});
							}
						}

						$scope.remove = function() {

							var index = angular.element(document.querySelector("input[id=radio]:checked")).val();
							$http.post(
									'http://localhost:8090/studentfeemanagementweb/student/deleteStudentUsingId/'
											+ index).success(function(data) {
								alert("success");
								$scope.students = data;
							});
						}
						$scope.search = function() {

							var searchData = $scope.searchFilter;
							$http.post(
									'http://localhost:8090/studentfeemanagementweb/student/searchStudent/'
											+ searchData).success(
									function(data) {
										alert("success");
										$scope.students = data;
									});

						}

						$scope.edit = function(index) {

							check = true;
							$scope.studentId = $scope.students[index].studentId;
							$scope.studentName = $scope.students[index].studentName;
							$scope.studentClass = $scope.students[index].studentClass;
							$scope.feeMonth = $scope.students[index].month;
							$scope.studentFee = $scope.students[index].paidAmount;
							var remainingAmount = $scope.students[index].remainingAmount;

							if (remainingAmount == 0) {
								$scope.idDisable = true;
								$scope.nameDisable = true;
								$scope.classDisable = true;
								$scope.monthDisable = true;
								$scope.feeDisable = true;
								$scope.btnDisable = true;
								alert("this field can not be updated");
							} else {
								$scope.idDisable = true;
							}
						}

						$scope.searchByUnPaidRecords = function() {
							alert("inside searchByUnPaidRecords");
							$http
									.post(
											'http://localhost:8090/studentfeemanagementweb/student/unpaidStudents')
									.success(function(data) {
										alert("success");
										$scope.students = data;
									});

						}

						$scope.searchByPaidRecords = function() {
							alert("inside searchByPaidRecords");
							$http
									.post(
											'http://localhost:8090/studentfeemanagementweb/student/paidStudents')
									.success(function(data) {
										alert("success");
										$scope.students = data;
									});
						}

					});
</script>

</head>
<body ng-app="myapp" ng-controller="StudentController">
	<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container-fluid" style="background-color:#2B547E">
		<div class="navbar-header">
			<a class="navbar-brand" href="#" style="color:activeborder;">Student Fee Management</a>
		</div>
		<ul class="nav navbar-nav" style="margin-left:800px; ">
			<li class="active"><a href="#">Home</a></li>
			<li><a href="#">Sign Up</a></li>
			<li><a href="#myModal" data-toggle="modal" data-target="#myModal">Sign In</a></li>
			<li><a href="#">Page 3</a></li>
		</ul>
	</div>
	</nav>
	<!-- <div class="container">
		<div class="page-header" align="center"
			style="background-color: #696969; color: yellow; margin-top: 1px;">
			<h2 style="position: relative; margin-top: 3px; padding-top: 18px;">Student
				Fee Management</h2>
		</div>

	</div> -->
	<br>
	<br>
	<br>
	<br>
	<center>
		<div class="panel panel-primary"">
			<div class="panel-heading">
				<h3 class="panel-title">Fee Submission Form</h3>
			</div>
			<div class="panel-body">
				<form name="myForm">
					<table>
						<tr>
							<td><label> Student Id:</label></td>
							<td><input name="id" class="form-control" id="inputdefault"
								type="number" ng-model="studentId" ng-disabled="idDisable"
								placeholder="Enter Student Id" /></td>

						</tr>
						<tr>
							<td><label>Student Name:</label></td>
							<td><input name="name" class="form-control"
								id="inputdefault" type="text" ng-model="studentName"
								ng-disabled="nameDisable" placeholder="Enter Student Name" /></td>
						</tr>
						<tr>
							<td><label>Student Class:</label></td>
							<td><input class="form-control" id="inputdefault"
								type="text" ng-model="studentClass" ng-disabled="classDisable"
								placeholder="Enter Student Class" /></td>
						</tr>
						<tr>
							<td><label>Month:</label></td>
							<td><select class="form-control" id="inputdefault"
								ng-model="feeMonth" ng-disabled="monthDisable">
									<option value="January">January</option>
									<option value="February">February</option>
									<option value="March">March</option>
									<option value="April">April</option>
									<option value="May">May</option>
									<option value="June">June</option>
									<option value="July">July</option>
									<option value="August">August</option>
									<option value="September">September</option>
									<option value="October">October</option>
									<option value="November">November</option>
									<option value="December">December</option>
							</select></td>
						</tr>
						<tr>
							<td><label>Amount:</label></td>
							<td><input class="form-control" id="inputdefault"
								type="number" ng-model="studentFee" ng-disabled="feeDisable"
								placeholder="Enter Amount" /></td>
						</tr>

						<tr>
							<td><input type="button" value="Submit"
								class="btn btn-success" ng-click="submitData()"
								ng-disabled="btnDisable" />
						</tr>

					</table>
				</form>
			</div>
		</div>
	</center>
	<br>
	<br>
	
	<center>
		<input type="text" ng-model="searchFilter" ng-hide="tableDisable" />
		&nbsp;&nbsp;&nbsp;
		<input type="button" class="btn btn-primary" value="Search"ng-click="search()" ng-hide="tableDisable" /> 
		<input type="button" class="btn btn-primary" value="Unpaid Records" ng-click="searchByUnPaidRecords()" ng-hide="tableDisable" /> 
		<input type="button" class="btn btn-primary" value="Paid Records" ng-click="searchByPaidRecords()" ng-hide="tableDisable" />
	</center>
	<br>
	<br>
	<center>
		<div class="container" ng-hide="tableDisable">
			<table class="table table-hover">

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

				<tbody>
					<tr class="success" ng-repeat="student in students">
						<td><input id='radio' type='radio'
							value={{student.studentId}}></td>
						<td>{{student.studentId}}</td>
						<td>{{student.studentName}}</td>
						<td>{{student.studentClass}}</td>
						<td>{{student.month}}</td>
						<td>{{student.paidAmount}}</td>
						<td>{{student.remainingAmount}}</td>
						<td><input type="button" value="Delete"
							class="btn btn-danger" ng-click="remove()" />&nbsp;&nbsp;<input
							type="button" value="Update" class="btn btn-warning"
							ng-click="edit($index)" /></td>

					</tr>
				</tbody>
			</table>
		</div>
	</center>
		 <div class="modal fade" id="myModal">
		<div class="modal-dialog">
      		<div class="modal-content">
        		<div class="modal-header" style="background-color:#2B547E;">
         			 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
         			 <h4 class="modal-title" style="color:activeborder;">Log-in</h4>
        		</div>
        		<div class="modal-body">
          			<div class="form-group">
    					<label for="exampleInputEmail1">Email</label>
    					<input class="form-control" id="exampleInputEmail1" placeholder="Enter email" type="email">
  		  			</div>
		  		<div class="form-group">
		  			<label for="exampleInputPassword1">Password</label>
					<input class="form-control" id="exampleInputPassword1" placeholder="Password" type="password">
		 		 </div>
         		 <p class="text-right"><a href="#">Forgot password?</a></p>
        	</div>
        	<div class="modal-footer">
          		<a href="#" data-dismiss="modal" class="btn">Close</a>
          		<a href="#" class="btn btn-primary">Log-in</a>
        	</div>
      </div>
    </div> 
</body>
</html>
