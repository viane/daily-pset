var gulp = require('gulp')
var ts = require('gulp-typescript')
var browserify = require('gulp-browserify')
var merge = require('merge2')
var tsProject = ts.createProject({declaration: true})
var gulpSequence = require('gulp-sequence')
var concat = require('gulp-concat')

gulp.task('scripts', function() {
  var tsResult = gulp.src('src/**/*.ts').pipe(tsProject())
  return merge([
    // Merge the two output streams, so this task is finished when the IO of both operations is done.
    tsResult.dts.pipe(gulp.dest('built/definitions')),
    tsResult.js.pipe(gulp.dest('built/js'))
  ])
})

gulp.task('complie-main', () => {
  gulp.src(['built/js/main.js']).pipe(browserify({insertGlobals: true})).pipe(gulp.dest('./built/js/'))
})

gulp.task('watch', function() {
  gulpSequence('scripts', 'complie-main')(function(err) {
    if (err)
      console.log(err)
  })
  gulp.watch('src/**/*.ts', (event) => {
    gulpSequence('scripts', 'complie-main')(function(err) {
      if (err)
        console.log(err)
    })
  })
})

gulp.task('compress', function() {
  return gulp.src('./built/js/*.js')
    .pipe(concat('allInOne.js'))
    .pipe(gulp.dest('./built/js/'))
})
