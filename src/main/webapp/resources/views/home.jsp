<div class="full flex flex-around flex-center-align">
	<div class="selectable repeat-animation hide-fade" ng-click="vote(restaurant)"
		ng-repeat="restaurant in viewRestaurant ">
		<img alt="{{restaurant.name}}" src="{{restaurant.imgUrl}}"
			class="img-restaurant img-responsive center-block"> <span>{{restaurant.name}}</span>
	</div>
</div>