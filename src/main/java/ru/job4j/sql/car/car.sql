create database car;

create table body_car(
    id serial primary key,
    name varchar(255)
);

create table engine(
    id serial primary key,
    name varchar(255) not null unique
);

create table transmission(
    id serial primary key,
    name varchar(255) not null unique
);

create table model_car(
    id serial primary key,
    name varchar(250),
    body_car_id int references body_car(id),
    engine_id int references engine(id),
    transmission_id int references transmission(id)
);

/* ================================================================================================ */
insert into body_car (name) values ('sedan');
insert into body_car (name) values ('coupe');
insert into body_car (name) values ('pickup truck');
insert into body_car (name) values ('minivan');

insert into engine (name) values ('102');
insert into engine (name) values ('170');
insert into engine (name) values ('215');
insert into engine (name) values ('250');
insert into engine (name) values ('300');

insert into transmission (name) values ('Automatic Transmission');
insert into transmission (name) values ('Manual Transmission');
insert into transmission (name) values ('Automated Manual Transmission');
insert into transmission (name) values ('Continuously Variable Transmission');

insert into model_car (name, body_car_id, engine_id, transmission_id)
values ('Mazda 3', 1, 2, 1);

insert into model_car (name, body_car_id, engine_id, transmission_id)
values ('Honday accent', 1, 1, 2);

insert into model_car (name, body_car_id, engine_id, transmission_id)
values ('Mercedes-Benz GLC Coupe 250 I (C253)', 2, 2, 3);

insert into model_car (name, body_car_id, engine_id, transmission_id)
values ('Toyota Tundra CrewMax II Рестайлинг', 3, 5, 3);

-- 1) Вывести список всех машин и все привязанные к ним детали.
select mc.name as model, bc.name as body_car, e.name as angine, t.name as transmission
from model_car as mc
join body_car as bc on mc.body_car_id = bc.id
join engine as e on mc.engine_id = e.id
join transmission as t on mc.transmission_id = t.id;

-- 2) Вывести отдельно детали (1 деталь - 1 запрос), которые не используются НИ в одной машине,
-- кузова, двигатели, коробки передач.
select * from body_car where id not in (select body_car_id from model_car);
select * from engine where id not in (select engine_id from model_car);
select * from transmission where id not in (select transmission_id from model_car);
