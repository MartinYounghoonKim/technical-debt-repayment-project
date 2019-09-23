var cnt = 0;
const app = document.getElementById("app");

app.innerText = cnt;

document.addEventListener("scroll", func1);

function func1 () {
  cnt++;
  console.log(cnt);
  setTimeout(() => {
    app.innerText = cnt;
  }, 1000)
}
