var gulp = require('gulp');
var gls = require('gulp-live-server');
var typescript = require('gulp-tsc');

var DEV_DIR  = './src/main/webapp/';
var TEMP_DIR = './target/tmp/'; // working on it dir
var DIST_DIR = './target/seed-1.0-SNAPSHOT-connect/';

var server = gls.static(DEV_DIR, 8081);

gulp.task('default', ['compile'], function() {

    server.start();
    console.log("serving")

    //use gulp.watch to trigger server actions(notify, start or stop)
    gulp.watch([DEV_DIR + '**/*.css', DEV_DIR + '**/*.html'], function (file) {
        server.notify.apply(server, [file]);
    });
    console.log("watching")
});

gulp.task('compile', function() {
    console.log("compiled...");
    gulp.src([DEV_DIR + '**/*.ts'])
        .pipe(typescript())
        .pipe(gulp.dest(DIST_DIR))
});


