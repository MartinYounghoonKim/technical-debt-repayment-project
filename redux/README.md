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

## Reducer와 State
- State는 불변의 객체로 이뤄져야 한다. 간단한 예를 들어 Object.freeze를 통해 Object의 불변 객체로 만들어줄 수 있다.

```js
const state = {
  a: 1
}

Object.freeze(state);
```

하지만 freeze는 얕은 동결만 지원한다. 만약 깊은 동결을 해야하는 경우 아래와 같이 재귀함수를 통해 지원할 수 있다.

```js
const state = {
  a: {
    b: 1
  }
};

function deepFreeze (obj) {
  var propNames = Object.getOwnPropertyNames(obj);
  for (let name of propNames) {
    let value = obj[name];
  
    obj[name] = value && typeof value === "object" ? 
    deepFreeze(value) : value;
    console.log(obj[name]);
  }
  return Object.freeze(obj);
}
deepFreeze(state);
```

## State
- 
- 모듈 단위의 상태
- `앱 전체 상태 트리`를 가지고 있는 스토어
- 핵심은 단일 객체 트리를 가지고 있어야 함

Todo Store에 대한 Reducer는 다음과 같다.

```js
const todo = (state, action) => {
  switch (action.type) {
    case 'ADD_TODO':
      return {
        id: action.id,
        text: action.text,
        completed: false
      };
    case 'TOGGLE_TODO':
      if (state.id === action.id) {
        return {
          ...state,
          completed: !state.completed,
        };
      }
      return state;
    default:
      return state;
  }
}

const todos = (state = [], action) => {
  switch (action.type) {
    case 'ADD_TODO':
      return [
        ...state,
        todo(undefined, action)
      ];
    case 'TOGGLE_TODO':
      return state.map(t => todo(t, action));
    default:
      return state;
  }
};
```

여기에서 필터 기능을 추가하기 위해 visibilityFilter Reducer 함수를 추가한다.

```js
const visibilityFilter = (state = "SHOW_ALL", action) => {
  switch (action.type) {
    case 'SET_VISIBILITY_FILTER':
      return action.filter;
    default:
      return state;
  }
}
```

두개의 Reducer를 아래와 같이 결합 될 수 있다.

```js
const todoApp = (state = {}, action) => {
  return {
    todos: todos(
      state.todos,
      action
    ),
    visibilityFilter: visibilityFilter(
      state.vivisibilityFilter,
      action
    )
  }
}
```

하지만 다행히도 리덕스에서는 이러한 API를 combineReducer 라는 메소드로 제공한다.

```js
const todoApp = combineReducer({
  todos,
  visibilityFilter
})
```
