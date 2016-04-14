'use strict';

describe('Directive: graphicVotes', function() {
	beforeEach(module('voteRestaurant'));

	var $httpBackend, element, scope;

	beforeEach(inject(function(_$httpBackend_, $rootScope, $compile) {
		element = angular.element('<ng-graphic-votes></ng-graphic-votes>');

		scope = $rootScope;
		$httpBackend = _$httpBackend_

		$httpBackend.whenGET("vote").respond([ {
			"name" : "McDonald's",
			"votes" : 0
		}, {
			"name" : "Burger King",
			"votes" : 0
		}, {
			"name" : "Spolleto",
			"votes" : 0
		}, {
			"name" : "Sushi Isao",
			"votes" : 0
		}, {
			"name" : "Fogo de chão",
			"votes" : 0
		} ]);
		
		$httpBackend.expectGET("vote");

		$compile(element)(scope);
		scope.$digest();
	}));

	it("should have the correct element in the view", function() {
		var div = element.find('div');
	    expect(div.length).toBe(1);
	});
});