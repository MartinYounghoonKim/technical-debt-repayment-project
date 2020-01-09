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

# CHAR의 범위를 초과하는 경우 에러가 난다. 만약 strict mode가 설정되어 있지 않다면 나머지 값은 길이에 맞게 짤리고 저장은 될 것이다.
INSERT INTO user
VALUES (default, 'Martin', '12345678900', default);

SELECT * FROM user;

# UNSIGNED 키워드를 이용하여 payment 테이블 생성
use select_tutorial;
create table payment
(
    uid BIGINT not null,
    total_consume_mount int(255) UNSIGNED default 0 not null,
    constraint uid
        foreign key (uid) references user (uid)
);

# 정상적인 데이터 대입
INSERT INTO payment
VALUES (1, 1000);

SELECT * FROM payment
WHERE uid=1;

# UNSIGNED 이기 때문에 음수값은 대입 불가능
INSERT INTO payment
VALUES (1, -1);

# 최대값 대입 가능
INSERT INTO payment
VALUES (1, 4294967295);

# 최대값 초과시 대입불가능
INSERT INTO payment
VALUES (1, 4294967296);

# Duplicate foreign key constraint name 'uid' 가 왜 뜨는 것일까?
use select_tutorial;
CREATE TABLE wallet (
    user_id BIGINT not null,
    dollar DECIMAL(5, 2) NOT NULL default 0, # 다섯자리의 숫자와 2자리의 소수점 자리수 -999.99 ~ 999.99
    mileage FLOAT NOT NULL default 0,
    constraint user_id
        foreign key (user_id) references user (uid)
);
# DECIMAL 범위 안의 값은 정상적으로 대입 가능
INSERT INTO wallet
VALUES (2, 10.91);

INSERT INTO wallet
VALUES (2, 100.91);

# DECIMAL 범위 안이더라도 자리수가 넘으면 짤린다.
INSERT INTO wallet
VALUES (2, 10.912);

INSERT INTO wallet
VALUES (1, 100.91231);

# 허나 범위를 넘어가면 대입 불가능
INSERT INTO wallet
VALUES (1, 1000.9);

# FLOAT
INSERT INTO wallet
VALUES (2, 10.916, 10.916); # DECIMAL 은 자릿수 초과시 반올림

INSERT INTO wallet
VALUES (2, 10.91, 10.91);

SELECT * FROM wallet;

SELECT SUM(dollar) FROM wallet WHERE user_id=2;
SELECT SUM(mileage) FROM wallet WHERE user_id=2; # FLOAT 값은 불분명함

DROP TABLE wallet;
