### 일단 호이스트에 대하 살펴보기 전..

Javascript는 일반적으로 "인터프리터" 혹은 "동적" 언어라고 표현한다. 하지만 Javascript는 컴파일러 언어이다. (관련한 내용은 [여기](https://dev.to/genta/is-javascript-a-compiled-language-20mf)를 읽어보면 어느 정도 이해가 간다.)

But... 타 컴파일 언어(예를 들어 Java나 C++와 같은)와는 다르게 자바스크립트 엔진이 컴파일러에서 하는 일의 상당 부분을 담당한다.

타 컴파일 언어(예를 들어 Java나 C++와 같은)처럼 실행 전 `컴파일레이션(compilation)`이라 불리우는 3단계의 과정을 거친다.

But... 자바스크립트 엔진은 컴파일레이션 뿐만 아니라 타프로그램 언어의 컴파일러보다 복잡한 부분을 담당하고 있다. (Modern 브라우저에서 JIT(Just in Time) 컴파일레이션을 사용한다고 하는데 이 부분이 아닐까 싶다. 관련해서 링크는 [여기](https://web.stanford.edu/class/cs98si/slides/overview.html)에서 찾아볼 수 있다.)


### Javascript 내의 호이스트(Hoist)
본격적으로 호이스팅에 대해서 살펴보도록 하자.

```javascript
var a = 2;
```

위의 한 줄의 코드는 우리의 입장에서 하나의 구문으로 보여질 수 있으나, 실제로는 2개의 구문으로 나눌 수 있다.

```javascript
var a; // 선언문
a = 2; // 대입문
```

이에 대해 `선언문`의 경우는 앞에서 설명한 컴파일레이션 단계에서 처리하며 이 과정에서 변수 a를 생성하고 메모리 공간을 확보하는 등의 일을 한다. 그리고 대입문의 경우 코드가 실행되는 과정에 처리된다. 컴파일레이션 단계에서 처리하는 부분을 이해하지 못한다면 아래와 같은 코드의 결과는 `1, undefined, 2` 라고 생각할 것이다.

```javascript
function fn (a) {
  console.log(a);
  var a;
  console.log(a);
  var a = 2;
  console.log(a);
}
fn(1);
```

하지만 이해한 후 위의 코드를 살펴보면 `1, 1, 2`인 것을 알 수 있다. 이를 컴파일레이션 단계에서 처리해주는 부분과 실행 단계에서 처리되어지는 부분을 나눠보면 아래와 같이 나눌 수 있다.

```javascript
function fn (a) {
  var a; // 컴파일레이션 단계에서 변수 a를 생성하고 메모리 공간을 확보하는 일을 한다.
  var a; // 변수 a가 중복이기 때문에 무시된다.
  var a; // 변수 a가 중복이기 때문에 무시된다.

  a = 1; // 실행 단계에서 인자를 변수 a에 대입한다.
  console.log(a);
  console.log(a);
  a = 2;
  console.log(a);
}
fn(1);
```

그렇다면 다음의 코드는 어떠할까?

```javascript
fn();
var fn;

function fn () {
  console.log(1);
}
fn = function () {
  console.log(2);
}
```

일단 결과부터 말하면 1이 실행된다. 코드를 살펴보면 변수가 먼저 선언되었음에도 불구하고 fn 함수가 실행되었다. 이를 통해 우리는 호이스팅의 우선순위가 선언의 우선순위가 아니라는 것과 함수 선언문은 함수의 표현도 함께 호이스팅 된다는 것을 알 수 있다.

그렇다면 let과 const는 어떻게 될까?

```javascript
console.log(a);
const a = 1;
```

위의 코드를 실행시켜보면 아래와 같은 에러가 발생하는 것을 볼 수 있다.

> VM98:1 Uncaught ReferenceError: Cannot access 'a' before initialization at <anonymous>:1:13

let으로 선언하더라도 동일하다. 그렇다면 let이나 const는 호이스팅이 이뤄지지 않는 것일까? 여기에서 중요한건 Not defined 에러가 아니라, `초기화 전에 변수에 접근할 수 없다` 라는 에러라는 것이다.

사실 모든 변수(var, let, const)와 함수 선언문은 호이스팅이 이뤄진다. 다만 차이는 var 변수는 undefined로 초기화가 된다는 점이고, const와 let은 초기화 되지 않은 상태로 호이스팅이 이뤄진다는 점이다. 관련해서 조금더 자세히 알고 싶다면 [여기](https://blog.bitsrc.io/hoisting-in-modern-javascript-let-const-and-var-b290405adfda)를 통해 살펴볼 수 있다. 이러한 테스트는 다음과 같은 코드를 통해 알 수 있다.

```javascript
const a = 1;
if (a) {
  console.log(a);
  const a = 2;
}
```

만약 호이스팅이 이뤄지지 않았다면 다음과 코드는 `1`이 찍혀야 하지만, 위와 같이 `Cannot access 'a' before initialization at <anonymous>:1:13` 에러가 발생하는 것을 알 수 있다. 이를 통해 const나 let의 경우 블럭 범위에서 호이스팅이 이뤄지고 있다는 것을 알 수 있다. 이를 우리는 TDZ(Temporal Dead Zone) 로 `해당 변수가 선언은 되어있지만, 아직 초기화가 되지않은 상태` 라고 표현한다.

변수의 생성 단계.
1. 선언 단계(Declaration phase)
변수를 실행 컨텍스트의 변수 객체(Variable Object)에 등록한다. 이 변수 객체는 스코프가 참조하는 대상이 된다.
2. 초기화 단계(Initialization phase)
변수 객체(Variable Object)에 등록된 변수를 위한 공간을 메모리에 확보한다. 이 단계에서 변수는 undefined로 초기화된다.
3. 할당 단계(Assignment phase)
undefined로 초기화된 변수에 실제 값을 할당한다.
