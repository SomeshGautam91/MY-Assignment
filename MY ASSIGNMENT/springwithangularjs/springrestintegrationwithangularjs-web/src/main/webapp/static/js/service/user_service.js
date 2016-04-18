app.factory('UserService',['$http', '$q', function($http, $q){
	
	return{
			fetchAllUsers: function() {
            return $http.get('http://localhost:8080/springrestintegrationwithangularjs-web/getAllUser/')
                    .then(
                            function(response){
                                return response.data;
                            }, 
                            function(errResponse){
                                console.error('Error while fetching users');
                                return $q.reject(errResponse);
                            }
                    );
		
		
		  }
	
	}
}]);