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

	$scope.load = function() {
		$http.get("http://localhost:8080/get")
			.then(function(response) {
				$scope.nList = response.data;
			}, function(error) {
				console.log(error);
			});
	}

	$scope.init();
	$scope.load();
});