# 스키마 생성
create schema select_tutorial;

# 해당 스키마 사용
use select_tutorial;

# user 테이블 생성
CREATE TABLE user (
    uid     BIGINT NOT NULL AUTO_INCREMENT,
    name    VARCHAR(10) NOT NULL,
    password CHAR(10) NOT NULL,
    join_date DATETIME NOT NULL DEFAULT NOW(),
    PRIMARY KEY (uid)
);

# 샘플 데이터 삽입
INSERT INTO user
VALUES (default, 'Martin', '1234567890', default);

-- CHAR의 범위를 초과하는 경우 에러가 난다. 만약 strict mode 가 설정되어 있지 않다면 나머지 값은 길이에 맞게 짤리고 저장은 될 것이다.
INSERT INTO user
VALUES (default, 'Martin', '12345678900', default);

SELECT * FROM user;

# UNSIGNED 키워드를 이용하여 payment 테이블 생성
use select_tutorial;
DROP TABLE payment;
create table payment
(
    uid BIGINT not null,
    total_consume_mount int(255) UNSIGNED default 0 not null,
    constraint uid
        foreign key (uid) references user (uid)
);

# UNSIGNED 이기 때문에 음수값은 대입 불가능
INSERT INTO payment (uid)
VALUES (1);

select * from payment;

# 최대값 대입 가능
INSERT INTO payment
VALUES (1, 4294967295);

# 최대값 초과시 대입불가능
INSERT INTO payment
VALUES (1, 4294967296);

create table payment1
(
    uid BIGINT not null,
    total_consume_mount int(10) ZEROFILL default 0 not null
);

DESC payment1;
# ZEROFILL 범위 안의 값을 대입(default 값 역시 자리수가 동일하게 채워짐)
INSERT INTO payment1
VALUES (1, 11);

# 아래의 Query는 날렸을 떄, 0으로 채워지는 것을 확인할 수 있다.
SELECT * FROM payment1
WHERE uid=1;

# Duplicate foreign key constraint name 'uid' 가 왜 뜨는 것일까?
use select_tutorial;
CREATE TABLE wallet (
    user_id BIGINT not null,
    dollar DECIMAL(5, 2) NOT NULL default 0, # 다섯자리의 숫자와 2자리의 소수점 자리수 -999.99 ~ 999.99
    mileage FLOAT NOT NULL default 0,
    constraint user_id
        foreign key (user_id) references user (uid)
);

DESC wallet;
# DECIMAL 범위 안의 값은 정상적으로 대입 가능
INSERT INTO wallet (user_id, dollar)
VALUES (2, 10.91); # default를 0으로 부여했는데 왜 "Column count doesn't match value count at row" 에러가 뜨는지?

INSERT INTO wallet (user_id, dollar)
VALUES (2, 100.91);

# DECIMAL 범위 안이더라도 자리수가 넘으면 짤린다. 라는 것처럼 표현하는데 실제 반올림이 된다. 왜일까?
INSERT INTO wallet (user_id, dollar)
VALUES (2, 10.917);

INSERT INTO wallet (user_id, dollar)
VALUES (1, 100.91231);

# 허나 범위를 넘어가면 대입 불가능
INSERT INTO wallet (user_id, dollar)
VALUES (1, 1000.9);

# FLOAT
INSERT INTO wallet
VALUES (2, 10.916, 10.916);

INSERT INTO wallet
VALUES (2, 10.91, 10.91);

INSERT INTO wallet
VALUES (2, 10.91, 10.91);

SELECT * FROM wallet;

SELECT SUM(dollar) decimal_type, SUM(mileage) float_type FROM wallet WHERE user_id=2;
SELECT SUM(mileage) FROM wallet WHERE user_id=2; # FLOAT 값은 불분명함


## TIME

DROP TABLE time_table;
CREATE TABLE time_table (
    ts TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    d DATE DEFAULT DATE(NOW()) NOT NULL,
    dt DATETIME DEFAULT NOW() NOT NULL # ON UPDATE CURRENT_TIMESTAMP
);

# Reference https://dev.mysql.com/doc/refman/8.0/en/date-and-time-functions.html#function_current-timestamp

DESC time_table;
SELECT NOW();
SELECT CURTIME();
SELECT DATE('2003-12-31 01:02:03');
SELECT DATE(NOW());
SELECT LOCALTIME;
SELECT LOCALTIMESTAMP;

SELECT CURRENT_DATE;
SELECT CURRENT_TIME;
SELECT CURRENT_TIMESTAMP;

INSERT INTO time_table
values (NOW(), CURRENT_TIMESTAMP);

SELECT * FROM time_table;

INSERT INTO time_table (d)
VALUES (DATE('2003-12-31 01:02:03'));

INSERT INTO time_table (dt)
VALUES (NOW());

DROP TABLE enum_test;
CREATE TABLE enum_test (
  size ENUM('x-small', 'small', 'medium', 'large', 'x-large') NOT NULL,
  size2 ENUM('x-small', 'small', 'medium', 'large', 'x-large')
);

SELECT * FROM enum_test ORDER BY size;
SELECT * FROM enum_test ORDER BY CAST(size AS CHAR);

INSERT INTO enum_test
VALUES (5, 4);

-- reference: https://yahwang.github.io/posts/32
CREATE TABLE set_test (
   size SET('x-small', 'small', 'medium', 'large', 'x-large') -- 1, 2, 4, 8, 16
);

SELECT * FROM set_test WHERE size & 1 AND size & 4; -- 비트연산 활용 (자기 자신 Decimal 값)
SELECT * FROM set_test WHERE size='x-small,medium';

-- 아래의 query는 SELECT * FROM set_test WHERE size & 5; 와 같은 결과 반환
SELECT * FROM set_test WHERE size LIKE '%x-small%';

-- FIND_IN_SET 는 저장된 순서값을 반환(있냐 없냐 여부를 알 수 있다)
SELECT FIND_IN_SET('x-large', size) as a FROM set_test;
SELECT * FROM set_test WHERE FIND_IN_SET('x-small', size) > 0;
SELECT FIND_IN_SET('m', size) as a FROM set_test;

INSERT INTO set_test
VALUES (16);

-- 테이블 초기화
TRUNCATE set_test;
