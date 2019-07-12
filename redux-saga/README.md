## 기본적인 함수 작성

타입스크립트로 작성된 SAGA 모듈 하나의 기본 함수는 아래와 같이 작성한다.

```typescript
const FETCH_USER = "SAGA@@FETCH_USER";

interface IFetchUser {
  type: typeof FETCH_USER;
  payload: {
    uid: string;
  }
};

function* fetchUser (action: IFetchUser) {
  const { uid } = action.payload;
  yield put({ type: "FETCH_USER_REQUEST" });
  try {
    const response = yield call(fetchUserService, { uid });
    yield put({ type: "FETCH_USER_SUCCESS" }, response.data);
  } catch (e) {
    yield put({ type: "FETCH_USER_FAILURE" }, response.message);
  }
}

export default function* () {
  yield takeEvery(FETCH_USER, fetchUser);
}
```

디스패치된 "FETCH_USER" 액션에 대하여 fetchUser 함수를 실행시킨다. 이 때, takeEvery를 사용하면 동시에 해당 함수를 호출하는 것을 허용한다. 만약 동시에 허용하는 것을 원하지 않는다면 takeLatest를 사용할 수 있다.

```typescript
// ...

export default function* () {
  yield takeLatest(FETCH_USER, fetchUser);
}
```

만약 fetchUser 함수가 PENDING 상태일 때 다시 "FETCH_USER" 액션이 디스패치된다면 PENDING 상태의 기존 함수를 취소하고 최근 함수를 실행시킨다.


