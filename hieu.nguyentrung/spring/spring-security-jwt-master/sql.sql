-- auto-generated definition
create table department_table
(
    id   serial      not null
        constraint department_table_pk
        primary key,
    departmentName varchar(20) not null
);

alter table department_table
    owner to postgres;

-- auto-generated definition
create table employee_table
(
    id       serial not null
        constraint employee_table_pk
        primary key,
    login    varchar(50),
    password varchar(500),
    department_id  integer
        constraint employee_table_role_table_id_fk
        references department_table
);

alter table employee_table
    owner to postgres;

create unique index employee_table_login_uindex
    on employee_table (login);

