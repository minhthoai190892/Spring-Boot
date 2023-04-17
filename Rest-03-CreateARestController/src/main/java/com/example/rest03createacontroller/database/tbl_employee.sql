create database if not exists mydb;
use mydb;

-- table structure 
drop table if exists tbl_employee;
create table tbl_employee(
	id int not null auto_increment primary key,
    age int not null,
    name varchar(255) not null,
    email varchar(255) not null,
    department varchar(255) not null,
    location varchar(255) not null
);
-- insert data 
insert into tbl_employee(name,age,email,department,location)
 values("employee 1",22,"employee1@gmail.com","IT","city"),
 ("employee 3",33,"employee3@gmail.com","Sales","city"),
		("employee 2",25,"employee2@gmail.com","ITasd","city");
