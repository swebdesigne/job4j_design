insert into roles (name) values ('Responsible for ticket');

insert into users (name, role_id) values ('Igor', 1);

insert into rules (name) values ('Support');

insert into role_rules (role_id, rules_id) values (1, 1);

insert into category (name_category) values ('Trouble with network');

insert into state (status) values (1);

insert into item (description, user_id, category_id, state_id) values ('The trouble was resolved', 1, 1, 1);

insert into comments (comment_text, item_id) values ('Failed network', 1);

insert into attachs (name_file, item_id) values ('trouble_desc.txt', 1);