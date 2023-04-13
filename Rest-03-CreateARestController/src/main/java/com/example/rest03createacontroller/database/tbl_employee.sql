create database if not exists mydb;
use mydb;

-- table structure 
drop table if exists tbl_employee;
create table tbl_employee(
	id int not null auto_increment primary key,
    age int not null,
    name varchar(255) not null,
    email varchar(255) not null,
    department varchar(255) not null
);
-- insert data 
insert into tbl_employee(name,age,email,department)
 values("employee 1",22,"employee1@gmail.com","IT"),
		("employee 2",25,"employee2@gmail.com","ITasd");
