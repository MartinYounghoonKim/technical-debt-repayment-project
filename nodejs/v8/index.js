function async1 () {
  setTimeout(() => {
    console.log("async1 함수 호출");
  }, 0)
}

function async2 () {
  setTimeout(() => {
    console.log("async2 함수 호출");
  }, 0)
}

function async3 () {
  setTimeout(() => {
    console.log("async3 함수 호출");
  }, 0)
}

async1();
async2();
async3();
