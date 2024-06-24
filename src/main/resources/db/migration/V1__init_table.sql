create table author
(
    id serial not null,
    first_name varchar(50),
    last_name varchar(50),
    date_of_birth timestamp,
    year_of_birth integer,
    primary key (id)
);