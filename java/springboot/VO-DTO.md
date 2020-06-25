## DAO (Data Access Object)
- 실제 DB dp wjqrms
- Service 와 DB를 연결
- DB 테이블 내의 Column 만을 속성으로 가지는 클래스

## DTO (Data Transfer Object)
- 계층간 데이터 교환 객체
- DB 에서 얻은 data를 Service or Controller 로 보낼 때 사용하는 객체
- 로직은 존재하지 않으며, Getter/Setter만 가짐

## VO (Value Object)
- DTO 와 비슷, but ReadOnly 속성만 가짐
- 특정 비즈니스를 담는 객체 (DTO 와 차이점)
