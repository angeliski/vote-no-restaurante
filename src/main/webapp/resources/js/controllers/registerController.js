angular.module("voteRestaurant").controller("registerController", function($scope, $state, RestaurantService) {

	$scope.vote = function(name, email) {
		RestaurantService.vote(name, email, function() {
			$state.go("ranking");
		});
	}

});