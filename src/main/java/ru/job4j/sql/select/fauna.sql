create database fauna;
create table fauna (
    id serial primary key,
    name text,
    avg_age int,
    discovery_date date
);

/* ================================================================================================ */
insert into fauna (name, avg_age, discovery_date) values ('fish_salmon', 365, '1987-06-12');
select * from fauna where name like 'fish%';

/* ================================================================================================ */
insert into fauna (name, avg_age, discovery_date) values ('dog_pudel', 10000, '1900-01-01');
insert into fauna (name, avg_age, discovery_date) values ('dog_spanial', 21000, '1900-01-01');
insert into fauna (name, avg_age, discovery_date) values ('dog_mops', 15000, '1900-01-01');
select * from fauna where avg_age BETWEEN 10000 AND 21000;

/* ================================================================================================ */
insert into fauna (name, avg_age) values ('elephant', 30000);
select * from fauna where discovery_date is null;
select * from fauna where discovery_date < '1950-01-01';