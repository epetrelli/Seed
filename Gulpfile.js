var gulp = require('gulp');
var connect = require('gulp-connect');

var src = './src/main/webapp';
var filesToReload = src + '/**/*.{html,js,css}';

gulp.task('connect', function() {
    connect.server({
        root: src,
        livereload: true,
        port:8081
    });
});

gulp.task('reload', function () {
    gulp.src(filesToReload)
        .pipe(connect.reload());
});

gulp.task('watch', function () {
    gulp.watch([filesToReload], ['reload']);
});

gulp.task('default', ['connect', 'watch']);