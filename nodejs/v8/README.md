Javascript 는 `싱글 스레드` 프로그래밍 언어
`싱글 쓰레드` 라는 말은 call stack(콜스택)이 하나라는 의미를 뜻한다.
call stack이 하나라는 의미는 한번의 하나의 일만 할 수 있다.

[예제1](example01.js);

이러한 코드는 문제가 없다.


만약 비동기가 존재하지 않는다면 네트워크 실행 후, 응답값이 늦게오게되면 무한 대기하는 상황이 생길 수도 있으면 요즘 같이 Javascript로 화면을 그라는 경우라면 아마도 랜더링이 되지 않거나 랜더링되는 속도가 굉장히 늦어질 것이다.