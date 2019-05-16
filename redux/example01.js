const counter = (state = 0, action) => {
  switch (action.type) {
    case "increment":
      return state + 1;
    case "decrement":
      return state - 1;
    default:
      return state;
  }
}

const { createStore } = Redux;
// const createStore = (reducer) => {
//   let state;
//   let listners = [];
//   const getState = () => state;
//   const dispatch = (action) => {
//     state = reducer(state, action);
//     listners.forEach(listner => listner());
//   }
//   const subscribe = listner => {
//     listners.push(listner);
//     return () => {
//       listners => listners.filter(l => l !== listner);
//     }
//   }
//   dispatch({});
//   return { getState, dispatch, subscribe }
// }
const store = createStore(counter);

const render = () => {
  document.body.innerText = store.getState();

}
store.subscribe(render)
render();
document.addEventListener("click", () => {
  store.dispatch({ type: "increment" });
});