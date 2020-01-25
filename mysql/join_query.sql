CREATE DATABASE martin_study;

use martin_study;

create table member
(
    member_id BIGINT auto_increment PRIMARY KEY ,
    name VARCHAR(50) not null,
    team_id BIGINT not null,
    constraint
        foreign key (team_id) references team (team_id)
);

create table team
(
    team_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    team_name varchar(50) NOT NULL
);


INSERT INTO team VALUES (DEFAULT, 'team1');
INSERT INTO team VALUES (DEFAULT, 'team2');

INSERT INTO member VALUES (DEFAULT, 'Martin', 1);
INSERT INTO member VALUES (DEFAULT, 'Martin Junior', 1);

INSERT INTO member VALUES (DEFAULT, 'Irene', 2);
INSERT INTO member VALUES (DEFAULT, 'Irene Junior', 2);

SELECT * FROM team;
SELECT * FROM member;

SELECT M.member_id, M.name, M.team_id, T.team_name team_name
FROM member m
JOIN team t ON m.team_id = t.team_id;
