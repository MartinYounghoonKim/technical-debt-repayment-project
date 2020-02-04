CREATE DATABASE mysql_tutorial;

USE mysql_tutorial;

CREATE TABLE join_table_a (
  id INT NOT NULL
);

CREATE TABLE join_table_b (
    id INT NOT NULL
);

CREATE TABLE join_table_c (
    id INT NOT NULL,
    name VARCHAR(10)
);

INSERT INTO join_table_a VALUES (1);
INSERT INTO join_table_a VALUES (2);
INSERT INTO join_table_a VALUES (3);

INSERT INTO join_table_b VALUES (3);
INSERT INTO join_table_b VALUES (4);
INSERT INTO join_table_b VALUES (5);

INSERT INTO join_table_c VALUES (3, 'Martin');
INSERT INTO join_table_c VALUES (4, 'Irene');

SELECT * FROM join_table_a
UNION SELECT * from join_table_b;

SELECT id FROM join_table_a
UNION SELECT id from join_table_b
UNION SELECT id FROM join_table_c;

SELECT * FROM join_table_a
UNION SELECT * from join_table_b ORDER BY id;

SELECT id AS c FROM join_table_a
UNION ALL SELECT id AS c from join_table_b ORDER BY c;


