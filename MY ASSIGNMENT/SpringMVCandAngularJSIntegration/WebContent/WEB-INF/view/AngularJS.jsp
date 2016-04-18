<html ng-app>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Spring MVC and AngularJS integration</title>
		<script src="angular.js"></script>
		<script>
			function Hello($scope, $http) 
			{
				$http.get('http://localhost:8080/SpringExamples/springcontent.json').

                success(function(data) 
               	{

                    $scope.user = data;

                });
			}
		</script>
		
	</head>
	<body >
		<div ng-controller="Hello">
			<h3>SpringMVC & AngularJS Integration</h3>
			<p>Name:{{user.name}}</p>
			<p>EmailId:{{user.emailId}}</p>
		</div>

	</body>
</html>