angular.module("voteRestaurant").controller("registerController", ['$scope','$state','RestaurantService' ,function($scope, $state, RestaurantService) {

	$scope.vote = function(name, email) {
		RestaurantService.vote(name, email, function() {
			$state.go("ranking");
		});
	}

}]);