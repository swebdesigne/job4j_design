create table orders(
	id serial primary key,
	customer_id int,
	order_date date,
	amount float
);

create table items(
	id serial primary key,
	item_name varchar(255),
	item_description text
);

create table items_orders(
	id serial primary key,
	orders_id int references orders(id),
	items_id int references items(id)
);