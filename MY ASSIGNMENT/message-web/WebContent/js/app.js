var app=angular.module('NGChart',[]);

app.controller('AppCltr', function($scope){
	
	
	
	$scope.exportImg=function(){
		alert(123);
		var canvas = document.getElementById('canvas');
		var context = canvas.getContext('2d');
		var dataURL = canvas.toDataURL("images/png").replace("images/png", "images/octet-stream");
		//window.location.href=dataURL;
		alert(dataURL);
		
		$http({
            method: "post",
            url: "EmployeeController?action=exportToExcel",
            data:{"data":dataURL}
		}).success(alert("SUccess"));
		
		
		//document.getElementById('canvasImg').src = dataURL;
		//window.open(canvas.toDataURL('image/png'));
		
		/*var blob = new Blob([document.getElementById('exportable').innerHTML], {
            type: "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8"
        });
        saveAs(blob, "Report.xls");*/
		
		
		//var dataToPost = dataURL; /* PostData*/
		//var queryParams = {params: {action: 'exportToExcel'}};/* Query Parameters*/
		/*$http.post("EmployeeController"  URL , dataToPost, queryParams)
		        .success(function(serverResponse, status, headers, config) {
		            // Updating the $scope postresponse variable to update theview
		            $scope.postresponse = serverResponse.data.firstName + " " + serverResponse.data.lastName;
		        }).error(function(serverResponse, status, headers, config) {
		            alert("failure");
		        }
		    );*/
		
	};
});