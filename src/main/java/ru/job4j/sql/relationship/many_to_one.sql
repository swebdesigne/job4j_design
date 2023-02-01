-- one-to-many
-- писатель может иметь множество книг
-- конкрентная книга принадлежит только одному писателю
create table writer
(
    id          serial primary key,
    name_writer varchar(255)
);

create table books
(
    id         serial primary key,
    title_book varchar(255),
    book_id    int references writer (id)
);
