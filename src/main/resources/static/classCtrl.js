/**
 * 
 */
var app = angular.module('smartClass', []);

app.controller('classCtrl', function($scope, $http) {

	$scope.init = function() {
		$http.get("http://localhost:8080/welcomeData")
			.then(function(response) {
				$scope.notifications = response.data.message;
			}, function(error) {
				console.log(error);
			});
	}
	$scope.init();

	$scope.send = function() {
		var formData = JSON.stringify({ "title": $scope.title, "body": $scope.body });
		$http.post("http://localhost:8080/note", formData)
			.then(function() {
				alert("Success!");
			}, function(error) {
				console.log(error);
			});

	};
});