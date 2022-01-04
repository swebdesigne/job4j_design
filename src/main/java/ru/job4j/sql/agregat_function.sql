create database devices;

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
insert into devices (name, price) values ('Samsung Galaxy Note 10', 5000.99);
insert into devices (name, price) values ('Samsung Galaxy Note 10', 11000.99);

insert into devices (name, price) values ('Iphone 12', 10000);
insert into devices (name, price) values ('Iphone 12', 10000);
insert into devices (name, price) values ('Iphone 12', 12000);
insert into devices (name, price) values ('Iphone 12', 8000);

insert into devices (name, price) values ('One Plus One 8', 3000);
insert into devices (name, price) values ('One Plus One 8', 7000);
insert into devices (name, price) values ('One Plus One 8', 1000);

/* ================================================================================================ */
insert into people (name) values ('Igor');
insert into people (name) values ('Alina');
insert into people (name) values ('Fedor');

/* ================================================================================================ */
insert into devices_people (device_id, people_id) values (1, 1);
insert into devices_people (device_id, people_id) values (1, 3);

insert into devices_people (device_id, people_id) values (2, 1);
insert into devices_people (device_id, people_id) values (2, 2);

insert into devices_people (device_id, people_id) values (3, 1);
insert into devices_people (device_id, people_id) values (3, 2);
insert into devices_people (device_id, people_id) values (3, 3);

/* ================================================================================================ */
-- Вывод средней цены устройства
select avg(d.price) from devices;

-- Средняя стоимость устройства для каждого человека
select p.name, d.name, d.price
from devices_people as dp
join people p
on dp.people_id = p.id
join devices as d on dp.device_id = d.id;

-- Средняя стоимость устройства, где ср. стоимость устрайства > 5000 для каждого человека
select p.name, avg(d.price)
from devices_people as dp
join people p
on dp.people_id = p.id
join devices as d on dp.device_id = d.id
group by p.name having avg(d.price) > 5000;




