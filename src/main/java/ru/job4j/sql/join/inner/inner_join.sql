create database employees;

create table employee (
id serial primary key,
name varchar (20),
surname varchar (20),
age int);

create table salary (
id serial primary key,
salary int);

insert into employee (name, surname, age) values ('Igor', 'Sivolobov', 34);
insert into salary (salary) values (40);

insert into employee (name, surname, age) values ('Boris', 'Sivolobov', 35);
insert into salary (salary) values (50);

select * from employee join salary on employee.id = salary.id;
select * from employee as e join salary as s on e.id = s.id;
select e.name, e.age, s.salary from employee as e join salary as s on e.id = s.id;
select e.name, e.age, s.salary from employee as e join salary as s on e.id = s.id where s.salary < 50;
select e.name, e.age, s.salary from employee as e join salary as s on e.id = s.id where e.age > 34 and s.salary < 50;
