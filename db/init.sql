CREATE DATABASE task7;

\c task7

--Task1--
CREATE TABLE employeesAge (
    id BIGINT NOT NULL PRIMARY KEY,
    employeeName VARCHAR(64) NOT NULL,
    age INT NOT NULL
);

--Task2--
CREATE TABLE departmentSalary (
    id BIGINT NOT NULL PRIMARY KEY,
    employeeName VARCHAR(64) NOT NULL,
    departmentName VARCHAR(64) NOT NULL,
    salary INT NOT NULL
);

--Task3--
CREATE TABLE departmentEmployee (
    id BIGINT NOT NULL PRIMARY KEY,
    employeeName VARCHAR(64) NOT NULL,
    departmentId INT NOT NULL
);

CREATE TABLE departmentLocation(
	departmentId BIGINT NOT NULL PRIMARY KEY, 
	departmentName VARCHAR(64) NOT NULL,
	location VARCHAR(64) NOT NULL
);

CREATE VIEW departmentEmployeeLocation AS
SELECT de.id, de.employeeName, dl.departmentName, dl.location
FROM departmentEmployee as de INNER JOIN departmentLocation as dl
ON de.departmentId = dl.departmentId;

--Task1--
INSERT INTO employeesAge (id, employeeName, age) 
VALUES (0, 'Кирилл', 18), (1, 'Саша', 20), (2, 'Катя', 25);

--Task2--
INSERT INTO departmentSalary (id, employeeName, departmentName, salary) 
VALUES (0, 'Кирилл', 'IT', 30000), (1, 'Иван', 'IT', 20000), (2, 'Маша', 'HR', 40000);

--Task3--
INSERT INTO departmentEmployee (id, employeeName, departmentId) 
VALUES (0, 'Кирилл', 1), (1, 'Иван', 1), (2, 'Маша', 2);

INSERT INTO departmentLocation (departmentId, departmentName, location) 
VALUES (0, 'IT', 'Саратов'), (1, 'HR', 'Москва');