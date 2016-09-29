/* jshint unused: false */
// jshint undef:false
define(['angular', 'sample-module'], function (angular, sampleModule) {
	'use strict';
	return sampleModule.controller(
				'LoginCtrl',
				[
						'$scope',
						'$rootScope',
						'$log',
						'$http',
						'$location',

						function($scope, $rootScope, $log, $http, $location) {

							$rootScope.user = "";
							$rootScope.userAvailable = false;
							// This object will be filled by the form
							$scope.user = {};

							$scope.loginerror = '';

							console.log('hello to loginfgggg');

							// Register the login() function

							$scope.login = function() {
								if((angular.isUndefined($scope.user.username))|| $scope.user.username=='' || $scope.user.username == null){
									$scope.loginerror = 'Please enter Username';
									
								}
								else if((angular.isUndefined($scope.user.password))|| $scope.user.password=='' || $scope.user.password == null){
									$scope.loginerror = 'Please enter password';
									
								}
								else{
								
								var loginObject = {

									username : $scope.user.username,

									password : $scope.user.password

								}

								var loginParams = JSON.stringify(loginObject);
								

								$http(
										{

											method : 'POST',

											url : 'https://scp-transport-demand-portal.run.aws-usw02-pr.ice.predix.io/login',

											data : loginParams,

											headers : {

												'Content-Type' : 'application/json'

											}
										})
										.then(
												function(data) {
													if(data.data.status=="200"){
														$rootScope.user = $scope.user.username;
														$rootScope.userAvailable = true;
														$location.url('/sv-charts');
													}
													else{
														$scope.loginerror = 'Username or password not valid.';
													}
													

												},
												function(error,data,status) {
													console.log("response:"+data+ "status"+status);
													console.log(error);

													$scope.loginerror = 'Authentication failed.';
													
												
												});
								}
							};
			

	}]);
});
