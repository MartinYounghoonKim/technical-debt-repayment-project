function func1 () {
  throw new Error("에러가 발생했습니다.")
}

function func2 () {
  func1();
}

function main() {
  func2();
}

main();
