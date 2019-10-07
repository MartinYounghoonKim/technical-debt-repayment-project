function func1 (a, b) {
  return func2(a + b, a);
}

function func2 (a, b) {
  return a * b;
}

function calculate (a, b) {
  const res = func1(a, b);
  console.log(res);
}

calculate(1,2);
