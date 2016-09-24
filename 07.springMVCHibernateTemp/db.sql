DROP DATABASE if exists springmvchibernate;
CREATE DATABASE springmvchibernate default CHARACTER set utf8;
use springmvchibernate;
CREATE TABLE employee(
	id INT NOT NULL auto_increment, 
	name VARCHAR(50) NOT NULL,
	joining_date DATE NOT NULL,
	salary DOUBLE NOT NULL,
	ssn VARCHAR(30) NOT NULL UNIQUE,
	PRIMARY KEY (id)
);
