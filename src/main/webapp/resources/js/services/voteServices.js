angular.module('voteRestaurant').service('VoteService', function($resource, $http) {
	var resource = $resource('vote/:id');
	
	this.getVotes = function(cb) {
		var votes = resource.query();
		votes.$promise.then(function() {
			var graphicData = [];
			for (var index = 0; index < votes.length; index++) {
				var vote = votes[index];
				graphicData.push([vote.name, vote.votes]);
			}
			cb(graphicData);
		});
	}
});