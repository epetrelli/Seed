var gulp = require('gulp');
var gls = require('gulp-live-server');

var DEV_DIR  = './src/main/webapp/';
var PUBLISH_PORT = 8082;

var server;

gulp.task('default', ['serve_dev']);

gulp.task('serve_dev', function() {
    server = gls.static(DEV_DIR, PUBLISH_PORT);
    server.start();
    console.log("Serving folder " + DEV_DIR + " on port " + PUBLISH_PORT + ".");

    gulp.watch([DEV_DIR + '**/*.css', DEV_DIR + '**/*.html'], function (file) {
        server.notify.apply(server, [file]);
        console.log("Changes applied");
    });
    console.log("Watching...")
});


gulp.task('dist', function() {

});
