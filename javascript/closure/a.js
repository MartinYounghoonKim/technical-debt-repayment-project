function fn () {
  return {
    a: 0,
    b: function () {
      this.a++;
    },
    c: function () {
      var b = this.a;
      setTimeout(() => {
        console.log(b);
      }, 1000)
    }
  }
}

var a = fn();
a.b();
a.b();
a.c();
a.b();
a.b();
