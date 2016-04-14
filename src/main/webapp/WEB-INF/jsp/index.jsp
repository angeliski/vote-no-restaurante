<!DOCTYPE html>
<html ng-app="voteRestaurant">
<head>
<title>Vote no Restaurante</title>
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/style.css">
<link rel="stylesheet" href="resources/css/animations.css">
</head>
<body>

	<div class="container">
		<div class="full view-slide-in" ui-view></div>
	</div>


	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.5.3/angular.js"></script>
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.5.3/angular-animate.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/angular-ui-router/0.2.18/angular-ui-router.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.5.3/angular-resource.min.js"></script>


	<script type="text/javascript" src="resources/js/app.js"></script>
	<script type="text/javascript"
		src="resources/js/services/restaurantServices.js"></script>
	<script type="text/javascript"
		src="resources/js/services/voteServices.js"></script>

	<script type="text/javascript"
		src="resources/js/directives/graphicVotes/graphicVotesDirective.js"></script>

	<script type="text/javascript"
		src="resources/js/controllers/voteController.js"></script>
	<script type="text/javascript"
		src="resources/js/controllers/registerController.js"></script>

	<script type="text/javascript"
		src="https://code.highcharts.com/highcharts.js"></script>
</body>
</html>