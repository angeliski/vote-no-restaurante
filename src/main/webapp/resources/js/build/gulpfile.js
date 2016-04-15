var cssFolder = "../../css/",
	jsFolder = "../",
	distFolder="../../dist/",
	gulp = require('gulp'), 
	minifyCss = require("gulp-minify-css"),
	uglify = require("gulp-uglify")
	concat = require('gulp-concat'),
	rename = require('gulp-rename');

gulp.task('build-css', function() {
	return gulp.src(cssFolder + "**/*.css")
	.pipe(concat('compile-style.css'))
	.pipe(rename('style.min.css'))
	.pipe(minifyCss())
	.pipe(gulp.dest(distFolder));
});

gulp.task('build-js', function() {
	return gulp.src(['!../**/*.min.js','jsFolder + "app.js','!./node_modules/**/','!./**/*.js',jsFolder + '**/*.js','!../tests/**/*.js'])
	.pipe(concat('compile-script.js'))
	.pipe(rename('script.min.js'))
	.pipe(uglify())
	.pipe(gulp.dest(distFolder));
});

gulp.task('default',['build-js','build-css'], function() {  
	
});