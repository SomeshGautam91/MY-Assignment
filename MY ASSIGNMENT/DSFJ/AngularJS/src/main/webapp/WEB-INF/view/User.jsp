<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>AngularJS Example</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
<script src="/WEB-INF/JS/app.js"></script>
<script src="/WEB-INF/JS/user_controller.js"></script>
<script src="/WEB-INF/JS/user_service.js"></script>

<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body ng-app="myApp">
	<div class="panel-heading">
		<center>
			<span class="lead">User Registration Form </span>
		</center>
	</div>
	<div class="container">
		<form role="form">
			<div class="form-group">
				<label for="usr">Name:</label> <input type="text"
					class="form-control" id="username">
			</div>
			<div class="form-group">
				<label for="pwd">Email:</label> <input type="password"
					class="form-control" id="password">
			</div>
			<div class="form-group">
				<label for="pwd">Address:</label> <input type="text"
					class="form-control" id="address">
			</div>
			<button type="button" class="btn btn-success" ng-click="">Register</button>
			<button type="button" class="btn btn-danger">Reset Form</button>
		</form>
	</div>
	<div class="panel-heading">
		<center>
			<span class="lead">List of Users </span>
		</center>
	</div>
	<div class="container">
		<table class="table">
			<thead>
				<tr>
					<th>Firstname</th>
					<th>Lastname</th>
					<th>Email</th>
				</tr>
			</thead>
			<tbody>
				<tr ng-repeat="u in ctrl.users">
					<td><span ng-bind="u.id"></span></td>
					<td><span ng-bind="u.username"></span></td>
					<td><span ng-bind="u.address"></span></td>
					<td><span ng-bind="u.email"></span></td>
					<td>
						<button type="button" ng-click="ctrl.edit(u.id)"
							class="btn btn-success custom-width">Edit</button>
						<button type="button" ng-click="ctrl.remove(u.id)"
							class="btn btn-danger custom-width">Remove</button>
					</td>
				</tr>
			</tbody>
		</table>
	</div>

</body>
</html>