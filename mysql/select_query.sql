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

# CHAR의 범위를 초과하는 경우 에러가 난다.
INSERT INTO user
VALUES (default, 'Martin', '12345678900', default);

SELECT * FROM user;



