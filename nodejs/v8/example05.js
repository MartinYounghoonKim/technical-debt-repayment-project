const app = document.getElementById("app");
app.addEventListener("click", async function () {
  await main();
});

function func1 () {
  setTimeout(() => {
    alert("func1");
    return 1
  }, 10000);
}
function func2 () {
  setTimeout(() => {
    alert("func2");
    return 2
  }, 20000);
}
function func3 () {
  setTimeout(() => {
    alert("func3");
    return 3
  }, 30000);
}
function func4 () {
  setTimeout(() => {
    alert("func4");
    return 1
  }, 40000);
}


async function main () {
  alert(111);
  await func1();
  await func2();
  await func3();
  await func4();
}
