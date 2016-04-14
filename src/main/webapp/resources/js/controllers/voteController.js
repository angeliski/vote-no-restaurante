angular.module("voteRestaurant").controller("voteController", function($scope, $state, RestaurantService) {
	$scope.viewRestaurant = [];
	$scope.votes = [];

	RestaurantService.get(function(data) {
		$scope.viewRestaurant.push(data);
	});
	RestaurantService.get(function(data) {
		$scope.viewRestaurant.push(data);
	});

	$scope.vote = function(restaurant) {
		$scope.votes.push(restaurant.id);
		var index = $scope.viewRestaurant.indexOf(restaurant);
		$scope.viewRestaurant.splice(index, 1);
		RestaurantService.get(function(data) {
			if (data) {
				$scope.viewRestaurant.push(data);
			} else {
				$scope.viewRestaurant = [];
				RestaurantService.registerVotes($scope.votes);
				$state.go("register");
			}
		});
	}

});
