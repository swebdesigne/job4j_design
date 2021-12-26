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
insert into devices (name, price) values ('Samsung Galaxy Note 10', 7000.99);
insert into devices (name, price) values ('Iphone 12', 10000);
insert into devices (name, price) values ('One Plus One 8', 3000);

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
select p.name, avg(d.price) from devices as d, people as p
where d.id in (select device_id from devices_people where people_id = p.id)
group by p.name;

select p.name, d.price from devices as d, people as p
where d.id in (select device_id from devices_people where people_id = p.id)
and price > 5000 order by p.name asc;





