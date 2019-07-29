## 글로벌 컨피그 설정
JEST의 설정 중 globalSetup을 제공하기는 하나, 사실 내가 하고자하는 것은 테스트 suites 중 하나의 스토리에 대해서 적용하고 싶었다. 하지만 globalSetup 옵션을 사용할 경우 모든 테스트 케이스에 대하여 적용이 되기 때문에 내가 원하는 기능은 아니였다.

window 객체에 선언되어 있는 경우는 아래와 같이 값이 추가되어 있는 경우에 해당한다.

```js
window.__FOO__ = {
  bar: "bar",
  isAuthenticated: false
}
```

이전 프로젝트를 진행하면서 굉장히 골치 아팠던... 여튼 이러한 문제를 해결하기 위해 찾던 중 [다음의 링크](https://blog.cloudboost.io/how-to-mock-es6-modules-and-globals-with-jest-814de9b24c6d)를 찾게 되었다. 이 글을 작성한 분 역시 나와 마찬가지은 경우를 경험했던 듯하다.

일단 위의 예제에서는 jQuery 라이브러리를 리액트와 함께 쓰는 경우가 없길 바라지만 그런 경우가 있다면... 이라는 이야기를 한다. jQuery를 이용해본 사용자라면 알 것이다. jQuery는 window 객체에 $를 추가한다는 것을... 아마도 위의 작성자 역시 React 프로젝트에는 별도로 jQuery 라이브러리가 설치되어 있을 것이며, 프로젝트와는 별개로 jquery를 끌어다 사용하고 있는 경우였던 것 같다. 그래서 링크를 참고하여 나는 다음과 같이 해결하였다.

```typescript
declare global {
  namespace NodeJS {
    interface Global {
      __FOO__: {
        bar: string;
        isAuthenticated: boolean;
      }
    }
  }
}

describe("글로벌 객체 __FOO__에 대해서", () => {
    describe("인증되지 않은 __FOO__에 대해서", () => {
        beforeEach(() => {
          global.__FOO__ = {
            bar: "foo_bar",
            isAuthenticated: false
          };
        });
        afterEach(() => {
          delete global.__FOO__;
        });
        it("__FOO__.bar의 값은 foo_bar이다.", () => {
          expect(__FOO__.bar).toEqual("foo_bar");
        });
        it("__FOO__.isAuthenticated의 값은 false이다.", () => {
          expect(__FOO__.isAuthenticated).toEqual(false);
        });
    });
    describe("인증된 __FOO__에 대해서", () => {
        beforeEach(() => {
          global.__FOO__ = {
            bar: "foo_bar",
            isAuthenticated: true
          };
        });
        afterEach(() => {
          delete global.__FOO__;
        });
        it("__FOO__.bar의 값은 foo_bar이다.", () => {
          expect(__FOO__.bar).toEqual("foo_bar");
        });
        it("__FOO__.isAuthenticated의 값은 true이다.", () => {
          expect(__FOO__.isAuthenticated).toEqual(true);
        });
    });
});
``` 

위의 에제를 살펴보면 describe 블럭을 기준으로 global 객체에 대한 인증값 isAuthenticated을 beforeEach를 이용하여 각각 선언하였다. 만약 각각의 테스트 suite 당 별개의 config를 설정하고자 한다면 위의 예제와 같이 describe 블럭으로 나누면 된다. 
