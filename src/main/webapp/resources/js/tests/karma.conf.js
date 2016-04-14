module.exports = function(config) {
	config.set({
		basePath : '',
		frameworks : [ 'jasmine' ],
    files: [
      'node_modules/highcharts/highcharts.js',
      'node_modules/angular/angular.js',
      'node_modules/angular-mocks/angular-mocks.js',
      'node_modules/angular-resource/angular-resource.js',
      'node_modules/angular-ui-router/release/angular-ui-router.js',
      'node_modules/angular-animate/angular-animate.js',
      '../app.js',
      '../controllers/*.js',
      '../directives/graphicVotes/*.js',
      '../services/*.js',
      'specs/*.js'
    ],
		reporters : [ 'progress' ],
		port : 9876,
		colors : true,
		// possible values: config.LOG_DISABLE || config.LOG_ERROR ||
		// config.LOG_WARN || config.LOG_INFO || config.LOG_DEBUG
		logLevel : config.LOG_INFO,
		autoWatch : true,
		browsers : [ 'PhantomJS' ],
		singleRun : true
  });
};
