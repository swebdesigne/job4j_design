create database devices;

create table people(
    id serial primary key,
    name varchar(255)
);

create table devices(
    id serial primary key,
    name varchar(255),
    price float
);

create table people(
    id serial primary key,
    name varchar(255)
);

create table devices_people(
    id serial primary key,
    device_id int references devices(id),
    people_id int references people(id)
);

/* ================================================================================================ */
insert into devices (name, price) values ('Samsung Galaxy Note 10', 93.99);
insert into devices (name, price) values ('Iphone 12', 120);
insert into devices (name, price) values ('One Plus One 8', 65);

/* ================================================================================================ */
insert into people (name) values ('Igor');
insert into people (name) values ('Alina');
insert into people (name) values ('Fedor');

/* ================================================================================================ */
insert into devices_people (device_id, people_id) values (1, 1);
insert into devices_people (device_id, people_id) values (2, 1);
insert into devices_people (device_id, people_id) values (3, 1);
insert into devices_people (device_id, people_id) values (2, 2);
insert into devices_people (device_id, people_id) values (3, 3);

/* ================================================================================================ */
select avg(price) from devices where id in (select device_id from devices_people where people_id = 1);
select min(price) from devices where id in (select device_id from devices_people where people_id = 1) group by price having min(price)
< 90;

select p.name, d.price from devices as d, people as p where d.id in (select device_id from devices_people where people_id = p.id) order by p.name;
select p.name, min(d.price) from devices as d, people as p where d.id in (select device_id from devices_people where people_id = p.id)
group by p.name;

select p.name, max(d.price) from devices as d, people as p where d.id in (select device_id from devices_people where people_id = p.id)
group by p.name;
select p.name, avg(d.price) from devices as d, people as p where d.id in (select device_id from devices_people where people_id = p.id)
group by p.name having avg(price) > 50;

select * from devices where id in (select device_id from devices_people where people_id = 1);
select * from devices where id in (select device_id from devices_people where people_id =
(select id from people where name = 'Igor'));



