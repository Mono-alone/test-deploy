create table person
(
    id   bigint primary key generated always as identity,
    name varchar(255) not null,
    age  int,
    check (age between 0 and 150)
);
