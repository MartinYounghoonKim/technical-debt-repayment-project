// https://www.youtube.com/watch?v=riVFM9YnYck
// https://www.youtube.com/watch?v=Q0iNAxzgSbI
function fn () {
  var a = 1;
  return function () {
    console.log(a++);
  }
}

var a = fn();
a();
