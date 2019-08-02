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
const store = createStore(counter);

const Counter = ({
    value
}) => (
    <div>
      <h1>{value}</h1>
    </div>
);

const render = () => {
  ReactDom.render(
      <Counter value={store.getState()}/>,
      document.getElementById('root')
  );
}
render();
