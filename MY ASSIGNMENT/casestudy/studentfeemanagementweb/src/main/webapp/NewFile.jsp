<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
		<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
		<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	</head>
	<script>
	var myapp = angular.module("myapp", []);
	myapp.controller("StudentController",function($scope, $http){
		
		$scope.registerStudent=function(){
			alert("inside register student function");
			var studentName=$scope.studentName;
			var studentClass=$scope.studentClass;
			var studentEmail=$scope.studentEmail;
			var studentPassword=$scope.studentPassword;
			
			var studentData = {
					"studentName" : studentName,
					"studentClass" : studentClass,
					"studentEmail" : studentEmail,
					"studentPassword" : studentPassword
					
				};
			$http.post('http://localhost:8090/studentfeemanagementweb/student/studentregistrationpage',studentData)
			.success(function(data) {
						alert("success");
						
					});
		}
	});
	
	
	</script>
	<body ng-app="myapp" ng-controller="StudentController">
		<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid" style="background-color:#2B547E">
			<div class="navbar-header">
				<a class="navbar-brand" href="#" style="color:activeborder;">Student Project Management</a>
			</div>
			<ul class="nav navbar-nav" style="margin-left:800px; ">
				<li class="active"><a href="#">Home</a></li>
				<li><a href="#studentLoginForm" data-toggle="modal" data-target="#studentLoginForm">student</a></li>
				<li><a href="#facultyLoginForm" data-toggle="modal" data-target="#facultyLoginForm">faculty</a></li>
			</ul>
		</div>
		</nav>

		<div class="modal fade" id="studentLoginForm">
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
         		 	<p class="text-right"><a href="#registerForm" data-toggle="modal" data-target="#studentRegisterForm">Register Yourself?</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">Forgot password?</a></p>
        		</div>
        		<div class="modal-footer">
          			<a href="#" data-dismiss="modal" class="btn">Close</a>
          			<a href="#" class="btn btn-primary">Log-in</a>
        		</div>
     		  </div>
    	  </div> 
     </div>
     <div class="modal fade" id="facultyLoginForm">
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
         		 	<p class="text-right"><a href="#registerForm" data-toggle="modal" data-target="#facultyRegisterForm">Register Yourself?</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">Forgot password?</a></p>
        		</div>
        		<div class="modal-footer">
          			<a href="#" data-dismiss="modal" class="btn">Close</a>
          			<a href="#" class="btn btn-primary">Log-in</a>
        		</div>
     		  </div>
    	  </div> 
     </div>
     <div class="modal fade" id="studentRegisterForm">
			<div class="modal-dialog">
      			<div class="modal-content">
        			<div class="modal-header" style="background-color:#2B547E;">
         			 	<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
         			 	<h4 class="modal-title" style="color:activeborder;">Sign-Up</h4>
        			</div>
        			<div class="modal-body">
          				<div class="form-group">
    						<label for="exampleInputName1">Name</label>
    						<input class="form-control" id="exampleInputEmail1" ng-model="studentName" placeholder="Enter name" type="name">
  		  			</div>
		  			<div class="form-group">
		  				<label for="exampleInputClass1">Class</label>
						<input class="form-control" id="exampleInputClass1" ng-model="studentClass" placeholder="Enter class" type="class">
		 		 	</div>
		 		 	<div class="form-group">
		  				<label for="exampleInputPassword1">Email</label>
						<input class="form-control" id="exampleInputPassword1" ng-model="studentEmail" placeholder="Enter email" type="email">
		 		 	</div>
		 		 	<div class="form-group">
		  				<label for="exampleInputPassword1">Password</label>
						<input class="form-control" id="exampleInputPassword1"  ng-model="studentPassword" placeholder="Enter password" type="password">
		 		 	</div>
        		</div>
        		<div class="modal-footer">
          			<a href="#" data-dismiss="modal" class="btn">Close</a>
          			<a href="#" class="btn btn-primary" ng-click="registerStudent()">Register</a>
        		</div>
     		  </div>
    	  </div> 
     </div>
      <div class="modal fade" id="facultyRegisterForm">
			<div class="modal-dialog">
      			<div class="modal-content">
        			<div class="modal-header" style="background-color:#2B547E;">
         			 	<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
         			 	<h4 class="modal-title" style="color:activeborder;">Sign-Up</h4>
        			</div>
        			<div class="modal-body">
          				<div class="form-group">
    						<label for="exampleInputName1">Name</label>
    						<input class="form-control" id="exampleInputEmail1" placeholder="Enter name" type="name">
  		  			</div>
		 		 	<div class="form-group">
		  				<label for="exampleInputPassword1">Email</label>
						<input class="form-control" id="exampleInputPassword1" placeholder="Enter email" type="email">
		 		 	</div>
		 		 	<div class="form-group">
		  				<label for="exampleInputPassword1">Password</label>
						<input class="form-control" id="exampleInputPassword1" placeholder="Enter password" type="password">
		 		 	</div>
        		</div>
        		<div class="modal-footer">
          			<a href="#" data-dismiss="modal" class="btn">Close</a>
          			<a href="#" class="btn btn-primary">Register</a>
        		</div>
     		  </div>
    	  </div> 
     </div>
	</body>
</html>