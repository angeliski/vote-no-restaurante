angular.module('voteRestaurant').service('RestaurantService', ['$resource','$http', function($resource, $http) {
	var that = this, resource = $resource('restaurant/:id'), count = 0, userVotes;
	
	that.restaurants = resource.query();
	that.getCachedRestaurant = function(cb) {
		var restaurant = that.restaurants[count++]
		if (!restaurant) {
			count = 0;
		}
		cb(restaurant);
	}

	that.get = function(cb) {
		that.restaurants.$promise.then(function() {
			that.getCachedRestaurant(cb);
		});
	}

	that.registerVotes = function(votes) {
		userVotes = votes;
	}

	that.vote = function(name, email, cb) {
		var data = {
			name : name,
			email : email,
			votes : userVotes
		}
		$http({
			url : 'vote',
			method : "POST",
			data : JSON.stringify(data)
		}).success(cb);
	}

}]);