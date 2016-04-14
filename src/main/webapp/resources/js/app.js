var app = angular.module("voteRestaurant", [ 'ngResource','ui.router', 'ngAnimate' ]);

app.config(function($stateProvider, $urlRouterProvider) {

	$urlRouterProvider.otherwise('/vote');

	$stateProvider.state('vote', {
		url : '/vote',
		templateUrl : 'resources/views/home.jsp',
		controller : 'voteController'
	}).state('register', {
		url : '/register',
		templateUrl : 'resources/views/register.jsp',
		controller : 'registerController'
	})
	.state('ranking', {
		url : '/ranking',
		templateUrl : 'resources/views/ranking.jsp'
	});

});