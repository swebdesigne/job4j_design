create database company;

create table emploers (
    id serial primary key,
    name varchar(255),
    department_id int references departments(id)
);

create table departments(
    id serial primary key,
    name varchar(255)
);

/* ================================================================================================ */
insert into departments (name) values ('JAVA developer');
insert into departments (name) values ('Javascript developer');
insert into departments (name) values ('PHP developer');
insert into departments (name) values ('HR');
insert into departments (name) values ('PM');

/* ================================================================================================ */
insert into emploers (name, department_id) values ('Igor', 1);
insert into emploers (name, department_id) values ('Evgeniy', 2);
insert into emploers (name, department_id) values ('Andrey', 3);
insert into emploers (name, department_id) values ('Irina', 4);
insert into emploers (name, department_id) values ('Andrey', 5);

/* ================================================================================================ */

-- 2. Выполнить запросы с left, rigth, full, cross соединениями
select e.name, d.name from emploers as e left join departments as d on e.department_id = d.id;
select e.name, d.name from emploers as e right join departments as d on e.department_id = d.id;
select e.name, d.name from emploers as e full join departments as d on e.department_id = d.id;
select e.name, d.name from emploers as e cross join departments as d;

-- 3. Используя left join найти департаменты, у которых нет работников
select d.name, e.name from departments as d left join emploers as e
on d.id = e.department_id where e.name is null;

-- 4. Используя left и right join написать запросы, которые давали бы одинаковый результат
-- (порядок вывода колонок в эти запросах также должен быть идентичный).
select d.name, e.name from emploers as e left join departments as d
on e.department_id = d.id;

select d.name, e.name from emploers as e right join departments as d
on e.department_id = d.id where e.name is not null;

-- 5. Создать таблицу teens с атрибутами name, gender и заполнить ее.
-- Используя cross join составить все возможные разнополые пары
create table teens(
    id serial primary key,
    name varchar(255),
    gender varchar(10)
);

insert into teens (name, gender) values ('Igor', 'man');
insert into teens (name, gender) values ('Alina', 'woman');
insert into teens (name, gender) values ('Boris', 'man');
insert into teens (name, gender) values ('Evgenia', 'woman');
insert into teens (name, gender) values ('Petr', 'man');
insert into teens (name, gender) values ('Galina', 'woman');

select concat(t1.name, '(', t1.gender, ')', ' + ', t2.name, '(', t2.gender, ')')
from teens as t1 cross join teens as t2 where t1.name <> t2.name;
