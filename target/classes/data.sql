DROP TABLE IF EXISTS workers;

CREATE TABLE workers (
    id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR (50),
    surname VARCHAR (50)
);

INSERT INTO workers VALUES(1, 'Jan', 'Kowalski');
INSERT INTO workers VALUES(2, 'Jan', 'Kowalski');
INSERT INTO workers VALUES(3, 'Jan', 'Kowalski');
INSERT INTO workers VALUES(4, 'Jan', 'Kowalski');
INSERT INTO workers VALUES(5, 'Jan', 'Kowalski');
INSERT INTO workers VALUES(6, 'Jan', 'Kowalski');

