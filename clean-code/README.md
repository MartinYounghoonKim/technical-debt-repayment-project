## 큰 단위를 작은 단위로
모듈 안의 하나의 함수가 커지면 코드 자체가 읽기 힘들어진다. 그렇기 때문에 함수를 관심사별 작은 단위로 나누어주는 것이 굉장히 중요하다.
 
### 1. 설명 변수
- 거대한 표현을 쪼개는 방법 중 하나로서, `하위 표현을 담고 있는 변수`이다.

```js
const filteredTodos = todos.filter(v => v.isDone);
if (filteredTodos.length > 0) {
  // do something
}
```

### 2. 요약 변수
- 커다란 코드 덩어리를 짧은 이름으로 대체하여 관리에 용이하게 한다.

```js
const isDocumentOwner = request.user_id === document.owner_id;

if (isDocumentOwner) {
  // do something
}
```

### 3. 드모르간 법칙
- 아래의 코드는 이해하기 쉽지 않다.
- 이러한 경우 `not을 분배하고, and/or를 바꿔라` 라는 법칙만 이해하면 된다.

```js
const not = !a && !b && !c; // !(a || b || c) 
// 혹은
const not = !(a && b && c); // !a || !b || !c
```

이해하기 굉장히 힘들다... 마찬가지로 이와 같은 코드가 있다고 가정한다면..

```js
if (!(file_exists && !is_pretected)) {
  // do something
}
```

위의 법칙을 적용해서 아래와 같이 수정한다.

```js
if (!file_exists && is_pretected) {
  // do something
}
``` 

### 4. 쇼트 서킷 논리(short-circuit logic) 오용 말기
- 대부분의 프로그래밍 언어에서 불리언 연산은 쇼트 서킷 평가를 수행

```js
const available = !(basket = findBasket(id)) || !isOccupy(basket))   
```

