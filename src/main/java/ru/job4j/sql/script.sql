create database test;
create table employee(
	id serial primary key,
	name varchar(255),
	surname varchar(255),
	age integer,
	salary float
);
insert into employee (name, surname, age, salary) values ('Igor', 'Sivolobov', 33, 70.23);
select * from employee;
update employee set salary = 40.23 where name = 'Igor'; 
delete from employee where name = 'Igor';
drop table employee;
