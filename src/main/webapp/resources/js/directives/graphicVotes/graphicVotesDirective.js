angular.module("voteRestaurant").directive('ngGraphicVotes', function() {

	var uniqueId = 1;

	Highcharts.getOptions().colors = Highcharts.map(Highcharts.getOptions().colors, function(color) {
		return {
			radialGradient : {
				cx : 0.5,
				cy : 0.3,
				r : 0.7
			},
			stops : [ [ 0, color ], [ 1, Highcharts.Color(color).brighten(-0.3).get('rgb') ] // darken
			]
		};
	});

	return {
		restrict : 'E',
		template : '<div id="{{::uniqueId}}" style="width: 100%; height: 400px;"></div>',
		controller : [ '$scope', 'VoteService', function($scope, VoteService) {
			$scope.getVotes = function() {
				VoteService.getVotes(function(data) {
					$scope.votes = data;
				});
			}
		} ],
		link : function(scope, element, attrs) {
			scope.uniqueId = 'ranking-livros-' + uniqueId++;
			scope.getVotes();

			scope.$watch('votes', function(newVal) {
				if (newVal) {
					Highcharts.chart(element[0], {
						chart : {
							plotBackgroundColor : null,
							plotBorderWidth : null,
							plotShadow : false
						},
						title : {
							text : 'Ranking dos Restaurantes'
						},
						tooltip : {
							pointFormat : '<b>{point.percentage:.1f}%</b>'
						},
						plotOptions : {
							pie : {
								allowPointSelect : true,
								cursor : 'pointer',
								showInLegend : true,
								dataLabels : {
									enabled : true,
									format : '<b>{point.name}</b>: {point.y}',
									style : {
										color : (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
									},
									connectorColor : 'silver'
								}
							}
						},
						series : [ {
							type : 'pie',
							name : 'Ranking dos Restaurantes',
							data : newVal
						} ]
					});
				}
			});

		}
	}
});
;
