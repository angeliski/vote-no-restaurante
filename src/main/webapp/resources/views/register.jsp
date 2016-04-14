<div class="full flex flex-center-align">
	<div class="col-md-offset-2 col-md-8">
		<h2>Conte nos mais sobre você!</h2>
		<form class="form-usuario" role="form" name="registerForm">
			<input type="text" class="form-control" placeholder="Nome"
				ng-required="true" ng-model="name" name="name" autofocus> <input
				type="email" class="form-control" name="email" ng-model="email"
				placeholder="Email" ng-required="true">
			<button class="btn btn-lg btn-primary btn-block"
				ng-disabled="registerForm.$invalid"
				ng-click="vote(name,email)" type="button">Confirmar</button>
		</form>
		<hr
			ng-show="(registerForm.name.$invalid && registerForm.name.$dirty) || (registerForm.email.$invalid && registerForm.email.$dirty)">
			
		<div ng-show="registerForm.name.$invalid && registerForm.name.$dirty"
			class="alert alert-danger">Por favor preencha o nome</div>
		<div
			ng-show="registerForm.email.$invalid && registerForm.email.$dirty"
			class="alert alert-danger">Por favor preencha um email válido</div>
	</div>


</div>