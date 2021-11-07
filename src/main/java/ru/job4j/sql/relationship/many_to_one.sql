create table addresses(
	id serial primary key,
	address varchar(255)
);

create table customers (
	id serial primary key,
	custmer_name varchar(255),
	address_id int references addresses(id)
);
