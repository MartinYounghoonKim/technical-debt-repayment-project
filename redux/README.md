## Egghead의 `Dan Abromov`에 대한 강의 학습하기
- Redux의 첫번째 핵심 컨셉: 애플리케이션이 간단하든 복잡하든 State의 트리는 하나의 자바스크립트 Object로 이루어져있다.
- Redux의 두번째 핵심 컨셉: State tree는 읽기 전용이다.
    - State는 직접적으로 변경할 수 없다.
    - 만약 변경하려면 액션을 디스패치해야 한다.
    - 액션은 Plain Javascript Object이다.

Redux 라이브러리의 createStore는 총 3가지 메소드를 지원한다.
1. getState: 현재의 State를 받아올 수 있다.
2. subscribe: 현재의 State를 구독하고 있다가 Dispatch 함수가 실행될때 실행된다.
3. dispatch: Plain Object에 해당하는 액션을 디스패치하여 State 값을 변경시켜준다.

```js
// reducer
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

const render = () => {
  document.body.innerText = store.getState();
}

store.subscribe(render);

render();
document.addEventListener("click", () => {
  store.dispatch({ type: "increment" });
});
```

복잡할 것 같은 createStore의 예시를 살펴보면 생각보다 간단한 것을 알 수 있다.

```js
const createStore = (reducer) => {
  let state;
  let listners = [];
  const getState = () => state;
  const dispatch = (action) => {
    state = reducer(state, action);
    listners.forEach(listner => listner());
  }
  const subscribe = listner => {
    listners.push(listner);
    return () => {
      listners => listners.filter(l => l !== listner);
    }
  }
  dispatch({});
  return { getState, dispatch, subscribe }
}
```
