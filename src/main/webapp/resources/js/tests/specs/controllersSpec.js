'use strict';
describe('testing controllers', function() {
	var $httpBackend, rootScope, scope, stateMock, restaurantMock, passPromise, registerController, name, email, restaurants;
	
	restaurants = [{id: 1},{id: 2},{id: 3},{id: 4},{id: 5}];

	beforeEach(module('voteRestaurant'));

	beforeEach(inject(function($rootScope, $state, $controller, RestaurantService) {
		rootScope = $rootScope;
		RestaurantService.vote = function(name, vote, cb) {
			if (cb)
				cb();
		};

		RestaurantService.get = function(cb) {
			RestaurantService.restaurants = restaurants;
			if (cb)
				RestaurantService.getCachedRestaurant(cb);
		};
		restaurantMock = RestaurantService;

		scope = $rootScope.$new();
		stateMock = $state;
	}));

	

	describe('registerController', function() {
		beforeEach(inject(function(_$httpBackend_, $controller) {
			$httpBackend = _$httpBackend_;
			registerController = $controller('registerController', {
				$scope : scope,
				$state : stateMock,
				RestaurantService : restaurantMock,
			});
		}));

		it('should have assigned vote function', function() {
			expect(scope.vote).toBeDefined();
		});

		it('should call vote', function() {
			$httpBackend.whenGET("restaurant").respond({});
			$httpBackend.expectGET("restaurant");

			$httpBackend.expectPOST("vote").respond({});
			$httpBackend.expectPOST("vote");
			spyOn(restaurantMock, 'vote').and.callThrough();

			name = "Name";
			email = "email";
			scope.vote(name, email);

			expect(restaurantMock.vote).toHaveBeenCalledWith(name, email, jasmine.any(Function));
		});
	});

	describe('voteController', function() {
		beforeEach(inject(function(_$httpBackend_, $controller) {
			$httpBackend = _$httpBackend_;
			registerController = $controller('voteController', {
				$scope : scope,
				$state : stateMock,
				RestaurantService : restaurantMock,
			});
		}));

		it('should have assigned viewRestaurant', function() {
			expect(scope.viewRestaurant).toBeDefined();
			expect(scope.viewRestaurant).toContain(restaurants[0]);
			expect(scope.viewRestaurant).not.toContain(restaurants[2]);
		});

		it('call vote function should update viewRestaurant', function() {
			scope.vote(restaurants[0]);
			
			expect(scope.viewRestaurant).toBeDefined();
			expect(scope.viewRestaurant).toContain(restaurants[2]);
			expect(scope.viewRestaurant).not.toContain(restaurants[0]);

			
		});
		
		it('on the ended vote need call state and reset view', function() {
			spyOn(stateMock, 'go').and.callThrough();
			
			scope.vote(restaurants[1]);
			scope.vote(restaurants[2]);
			scope.vote(restaurants[3]);
			scope.vote(restaurants[4]);
			
			expect(scope.viewRestaurant.length).toBe(0);
			expect(stateMock.go).toHaveBeenCalledWith("register");
			
		});
	});
});

