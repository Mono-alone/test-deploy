create table person
(
    id   uuid primary key default gen_random_uuid(),
    name varchar(255) not null,
    age  int          not null,
    check (age between 0 and 150)
);
