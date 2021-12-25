create table roles(
	id serial primary key,
	name text
);

create table users(
	id serial primary key,
	name text,
	role_id int references roles(id)
);

create table rules(
	id serial primary key,
	name text
);

create table role_rules(
	id serial primary key,
	role_id int references roles(id),
	rules_id int references rules(id)
);

create table category(
	id serial primary key,
	name_category varchar(20)
);

create table state(
	id serial primary key,
	status int
);

create table item(
	id serial primary key,
	description varchar(255),
	user_id int references users(id),
	category_id int references category(id),
	state_id int references state(id)
);

create table comments(
	id serial primary key,
	comment_text text,
	item_id int references item(id)
);

create table attachs(
	id serial primary key,
	name_file varchar(20),
	item_id int references item(id)
);