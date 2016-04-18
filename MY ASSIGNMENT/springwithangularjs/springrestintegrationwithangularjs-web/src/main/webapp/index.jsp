<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<html>
  <head>  
    <title>AngularJS $http Example</title>
    <meta charset="utf-8">  
    <meta name="viewport" content="width=device-width, initial-scale=1">
   	<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
   	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <!-- 	<style>
  		.username.ng-valid{
  		
  			background-color: green;
  		}
  		.username.ng-dirty.ng-invalid-required{
  			background-color: red;
  		}
  		/* .userName.ng-dirty.ng-invalid-minlength.ng-invalid-maxlength{
  			background-color: lightpink;
  		} */
  	
  	</style> -->
  	 <script>
  			var myApp= angular.module("myModule",[]);
  			myApp.controller('UserController',['$scope','UserService',function($scope,UserService){
  					$scope.user={id:null,userName:'',userAddress:'',userEmail:''};
  					$scope.users=[];
  				    var checkEdit=false;
  				    var dataIndex;
  				    
  				    $scope.fetch=function(){
  				    	
  				    	$scope.fetch();
  				    }
  		
					$scope.submit=function(){
  						$scope.user.userName=$scope.userName;
  						$scope.user.userEmail=$scope.userEmail;
  						$scope.user.userAddress=$scope.userAddress;
						$scope.reset();
  						if(checkEdit==true){
  							
  							
  							$scope.user.id=dataIndex;
  							$scope.editUser($scope.user);
  						}
  						else{
  								$scope.createUser($scope.user);
  						}
  					}
					$scope.edit=function(index){
						$scope.userName=$scope.users[index].userName;
						$scope.userEmail=$scope.users[index].userEmail;
						$scope.userAddress=$scope.users[index].userAddress;
						dataIndex=$scope.users[index].id;
						checkEdit=true;
						
						
						
						
					}
  					$scope.createUser=function(user){
  						 UserService.createUser(user)
  						 .then(
                                 function(d) {
                                      $scope.users = d;
                                 },
                                  function(errResponse){
                                      console.error('Error while creating user in controller');
                                  }
                         	);
  						
  						
  					}
  					$scope.editUser=function(user){
  						UserService.updateUser(user)
  						.then(
  								
  								function(d){
  									$scope.users=d;	
  								
  								},
  								function(errResponse){
                                    console.error('Error while edit user in controller');
                                }
  						
  						
  							);
  					}
  					$scope.remove=function(index){
  						dataIndex=$scope.users[index].id;
  						UserService.deleteUser(dataIndex)
						.then(
  								
  								function(d){
  									$scope.users=d;	
  								
  								},
  								function(errResponse){
                                    console.error('Error while edit user in controller');
                                }
  						
  						
  							);
  						
  						
  					}
  					$scope.fetch=function(){
  						
  						UserService.fetchUser()
  						.then(
  								function(d){
  									$scope.users=d;	
  								
  								},
  								function(errResponse){
                                    console.error('Error while edit user in controller');
                                }
  						
  						);
  					}
  					$scope.reset=function(){
  						
  						$scope.userName='';
  						$scope.userEmail='';
  						$scope.userAddress='';
  					}
  			}]);
  			myApp.factory('UserService',['$http','$q',function($http,$q){
  				return{
  					
  						createUser:function(user){
  								return $http.post('http://localhost:8080/springrestintegrationwithangularjs-web/registerUser',user)
  							 	.then(
                                    	 function(response){
                                         	return response.data;
                                    	 }, 
                                    	 function(errResponse){
                                         	console.error('Error while creating user in service');
                                         	return $q.reject(errResponse);
                                     	 }
                             		);
  						},
  						updateUser:function(user){
   							 return $http.post('http://localhost:8080/springrestintegrationwithangularjs-web/updateUser',user)
   							 .then(
                                      function(response){
                                          return response.data;
                                      }, 
                                      function(errResponse){
                                          console.error('Error while edit  user in service');
                                          return $q.reject(errResponse);
                                      }
                              	);
   							 
  						},
  						fetchUser:function(){
  							 return $http.get('http://localhost:8080/springrestintegrationwithangularjs-web/getAllUser')
   							 .then(
                                      function(response){
                                          return response.data;
                                      }, 
                                      function(errResponse){
                                          console.error('Error while edit  user in service');
                                          return $q.reject(errResponse);
                                      }
                              	);
  							
  						},
  						deleteUser:function(dataIndex){
  							return $http.get('http://localhost:8080/springrestintegrationwithangularjs-web/deleteUser/'+dataIndex)
  							.then(
  									function(response){
  										return response.data;
  									},
  									function(errResponse){
  										console.error('Error while delete user in service');
  										return $q.reject(errResponse);
  										
  									}
  									
  							
  							 
  								);
  							
  						}
  					}
   					 
  				
  			}]);
  
  
  
  </script>
  </head>
  <body ng-app="myModule" ng-controller="UserController ">
 	 <div class="container">
	     <form name="myForm" ng-submit="submit()">
		     	<div class="form-group">
		   			 <label for="name">Name:</label>
		    		 <input type="name" class="form-control" name="name" class="username" ng-model="userName" ng-pattern="/^[a-zA-Z]*$/" required ng-minlength="4" ng-maxlength="15">
		    		 <span ng-show="myForm.name.$error.minlength">
		    		 	<p style="color:red">Mininmum Length required is 4</p>
		    		 </span>
		    		 <span ng-show="myForm.name.$error.maxlength">
		    		 	<p style="color:red">Maximum Length required is 15</p>
		    		 </span>
		    		  <span ng-show="myForm.name.$error.required">
		    		 	<p style="color:red">This field is required</p>
		    		 </span>
		    		 <span ng-show="myForm.name.$invalid">
		    		 	<p style="color:red">Name can contain only letters(a-z/A-Z)</p>
		    		 </span> 
		    		
		    		
		 	    </div>
		  		<div class="form-group">
		   			 <label for="email">Email address:</label>
		   			 <input type="email" class="form-control" name="email" class="userEmail"   ng-model="userEmail" required>
		   			 <span ng-show="myForm.email.$error.required">
		   			 	<p style="color:red">This field is required</p>
		   			 </span>
		   			  <span class="error" ng-show="myForm.email.$error.email">
        				<p style="color:red">Not a vaild email!</p>
        			 </span> 
		 		</div>
		 		<div class="form-group">
		   			<label for="address">Address:</label>
		    		<input type="address" class="form-control" name="address" class="userAddress"  ng-model="userAddress" required >
		    		 <span ng-show="myForm.address.$error.required">
		   			 	<p style="color:red">This field is required</p>
		   			 </span>
		   			
		 		</div>
		 		<input type="submit" class="btn btn-success custom-width" ng-disabled="myForm.$invalid" value="Submit"/>
		 		<button type="submit" class="btn btn-success custom-width"ng-click="fetch()">fetch Users</button>
	     </form>  
    </div>
    <center><input type="text" ng-model="username" ng-model="useraddress" ng-model="useremail"/><br><br></center>
    <table class="table table-hover">
            <thead>
                 <tr>
                     <th>ID.</th>
                     <th>Name</th>
                     <th>Address</th>
                     <th>Email</th>
                     <th width="20%"></th>
                 </tr>
            </thead>
            <tbody>      
            	 <tr ng-repeat="u in users|filter:username|filter:useraddress|filter:useremail">
                      <td><span ng-bind="u.id"></span></td>
                      <td><span ng-bind="u.userName"></span></td>
                      <td><span ng-bind="u.userAddress"></span></td>
                      <td><span ng-bind="u.userEmail"></span></td>
                      <td>
                          <button type="button" ng-click="edit($index)" class="btn btn-success custom-width">Edit</button>  <button type="button" ng-click="remove($index)" class="btn btn-danger custom-width">Remove</button>
                      </td>
                 </tr>
           	</tbody>
     </table>
  </body>
 
</html>
