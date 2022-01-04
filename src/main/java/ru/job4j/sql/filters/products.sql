create database products;

create table type(
    id serial primary key,
    name varchar(255)
);

create table product(
    id serial primary key,
    name varchar(255),
    type_id int references type(id),
    expired_data date,
    price float
);

/* ================================================================================================ */
insert into type (name) values ('Сыр');
insert into type (name) values ('Молоко');
insert into type (name) values ('Хлеб');
insert into type (name) values ('Мороженое');

/* ================================================================================================ */
insert into product (name, type_id, expired_date, price) values ('Сыр плавленый копченый Аланталь', 1, '2022-02-01', 86);
insert into product (name, type_id, expired_date, price) values ('Сыр полутвердый BluDelice с голубой плесенью', 1, '2022-03-01', 1917);
insert into product (name, type_id, expired_date, price) values ('Набор элитных сыров', 1, '2022-12-02', 2029);
insert into product (name, type_id, expired_date, price) values ('Сыр Кабош Гауда', 1, '2022-12-05', 150);

insert into product (name, type_id, expired_date, price) values ('Мороженое молочное «Инмарко» эскимо попкорн', 4, '2022-11-02', 35);
insert into product (name, type_id, expired_date, price) values ('Мороженое BAHROMA сливочное чернослив грецкий орех', 4, '2022-01-04', 450);
insert into product (name, type_id, expired_date, price) values ('Мороженое Baskin Robbins черничное', 4, '2022-01-01', 631);
insert into product (name, type_id, expired_date, price) values ('Мороженое Bounty батончик', 4, '2022-03-01', 70);

insert into product (name, type_id, expired_date, price) values ('Хлеб отрубной', 3, '2022-11-02', 100);
insert into product (name, type_id, expired_date, price) values ('Хлеб черный', 3, '2022-03-02', 60);

insert into product (name, type_id, expired_date, price) values ('Молоко - 1%', 2, '2022-11-02', 35);
insert into product (name, type_id, expired_date, price) values ('Молоко - 12%', 2, '2022-03-02', 60);

/* ================================================================================================ */
-- 1. Написать запрос получение всех продуктов с типом "СЫР"
select * from product where type_id = 1;
select * from product where type_id in (select id from type where name = 'Сыр');

-- 2. Написать запрос получения всех продуктов, у кого в имени есть слово "мороженое"
select * from product where name like '%Мороженое%';
select * from product where lower(name) like '%мороженое%';

-- 3. Написать запрос, который выводит все продукты, срок годности которых уже истек
select * from product where expired_date < current_date;

-- 4. Написать запрос, который выводит самый дорогой продукт.
select * from product order by price desc limit 1;
select p.name, max(p.price) from product as p group by p.name limit 1

-- 5. Написать запрос, который выводит для каждого типа количество продуктов к нему принадлежащих. В виде имя_типа, количество
select t.name as type_name, count(t.name)
from product as p join type as t on p.type_id = t.id group by t.name;

-- 6. Написать запрос получение всех продуктов с типом "СЫР" и "МОЛОКО"
select t.name as type_name, count(t.name)
from product as p join type as t on p.type_id = t.id
where t.name = 'Сыр' OR t.name = 'Молоко' group by t.name;

-- Написать запрос, который выводит тип продуктов, которых осталось меньше 5 штук.
-- Под количеством подразумевается количество продуктов определенного типа. Например, если есть тип "СЫР" и продукты
-- "Сыр плавленный" и "Сыр моцарелла", которые ему принадлежат, то количество продуктов типа "СЫР" будет 2.
select t.name as type_name, count(t.name)
from product as p join type as t on p.type_id = t.id
group by t.name having count(t.name) < 5;

-- 8. Вывести все продукты и их тип.
select p.name, t.name from product as p join type as t on p.type_id = t.id order by t.name;