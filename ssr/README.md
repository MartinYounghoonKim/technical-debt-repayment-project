## 랜더링 방식
- SSR(Server side rendering): 클라이언트 사이드 혹은 유니버셜 앱을 HTML 형태로 서버에서 랜더링 한다.
- CSR(Client side rendering): DOM을 이용하여 브라우저에서 앱을 랜더링 한다.
- Rehydration: 서버에서 랜더링한 HTML DOM과 데이터를 클라이언트 뷰에서 재사용한다.
- Prerendering: build 시, 클라이언트 사이드 애플리케이션을 실행한 결과물을 스태틱한 리소스로 저장한다.

## Performance
- TTFB(Time to first bype): anchor 링크를 클릭한 후, 해당 컨텐츠의 first bit(뭐지 이게)이 회신올때까지의 시간
- FP(First paint): 사용자가 첫번째 Pixel을 볼 수 있는 시간
- FCP(First contentful paint): 요청한 컨텐츠 내용이 보이기까지 걸리는 시간 
- TTI(Time to interaction): 사용자가 인터렉션을 취할 수 있을때까지 걸리는 시간

## Server rendering 특징
- 유저가 요청하는 URI에 해당하는 페이지를 서버에서 HTML 템플릿 형태로 제작
- 이미 데이터 바인딩도 되어있기 때문에 클라이언트 사이드에서의 추가적 비용(Round trip)이 발생하지 않음
- FP와 FCP가 빠름
- Javascript 로딩으로 인해 생길 수 있는 페이지 로딩을 줄일 수 있다. 
- 단, 서버에서 페이지를 생성하는 데 걸리는 시간이 있어 TTFB가 느려질 수 있음.
- React의 경우 renderToString() 혹은 NextJS 와 같은 프레임워크를 이용하면 구현 가능
- Vue의 경우 NuxtJS 혹은 Server render guide를 통해 구현 가능

### Server rendering 종류
#### Static Rendering
- 미리 HTML 파일을 생성(hexo나 지킬 블로그와 같다고 생각하면 될듯)
- 빠른 FP, FCP, TTI를 제공
- 요청이 왔을 때 `즉석에서 HTML을 생성하지 않기 때문`에 빠른 TTFB을 제공
- 이미 정적 파일이 존재하기 때문에 엣지 캐싱을 할 수 있다는 장점이 있음

