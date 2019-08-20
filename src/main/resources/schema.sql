DROP TABLE IF EXISTS EMPLOYEES;
DROP TABLE IF EXISTS USERS;
DROP TABLE IF EXISTS PRODUCTS;
DROP TABLE IF EXISTS MOVIES;
DROP TABLE IF EXISTS authorities;
DROP INDEX IF EXISTS ix_auth_username;
DROP TABLE IF EXISTS ADDRESS;
CREATE TABLE EMPLOYEES (ID INT AUTO_INCREMENT PRIMARY KEY, NAME VARCHAR(100) NOT NULL, DOB DATE NOT NULL, EMAIL VARCHAR(50));

INSERT INTO EMPLOYEES (NAME, DOB, EMAIL) VALUES ('Siva', TO_DATE('1990-07-25', 'yyyy-MM-DD'), 'siva@trainings.com');
INSERT INTO EMPLOYEES (NAME, DOB, EMAIL) VALUES ('Charan', TO_DATE('1991-06-24', 'yyyy-MM-DD'), 'charan@trainings.com');
INSERT INTO EMPLOYEES (NAME, DOB, EMAIL) VALUES ('Vikram', TO_DATE('1995-08-22', 'yyyy-MM-DD'), 'vikram@trainings.com');
INSERT INTO EMPLOYEES (NAME, DOB, EMAIL) VALUES ('Shankar', TO_DATE('1996-05-05', 'yyyy-MM-DD'), 'shankar@trainings.com');

CREATE TABLE ADDRESS(
ID INT AUTO_INCREMENT PRIMARY KEY,
EMPLOYEE_ID INT REFERENCES EMPLOYEES(ID),
STREET VARCHAR(50),
CITY VARCHAR(50),
STATE VARCHAR(50),
PINCODE INT);
INSERT INTO ADDRESS(EMPLOYEE_ID,STREET,CITY,STATE,PINCODE) VALUES(1,'street-1','guntur','andhra',522403);
INSERT INTO ADDRESS(EMPLOYEE_ID,STREET,CITY,STATE,PINCODE) VALUES(1,'street-2','hyderabad','telangana',500090);