use vti1;
create table tbl_department(
id bigint auto_increment primary key unique,
name varchar(255)
);
create table tbl_position(
id bigint auto_increment primary key unique,
name varchar(255)
);
create table tbl_account(
id bigint auto_increment primary key unique,
email varchar(255) unique,
username varchar(255) unique,
fullname varchar(255),
created_date datetime,
department_id bigint,
position_id bigint,
FOREIGN KEY (department_id) REFERENCES tbl_department(id),
FOREIGN KEY (position_id) REFERENCES tbl_position(id)
);

create table tbl_group(
id bigint auto_increment primary key unique,
name varchar(255),
created_date datetime,
account_id bigint,
FOREIGN KEY (account_id) REFERENCES tbl_account(id)
);

create table tbl_group_account(
group_id bigint,
join_date datetime,
account_id bigint,
FOREIGN KEY (account_id) REFERENCES tbl_account(id),
FOREIGN KEY (group_id) REFERENCES tbl_group(id)
);

create table tbl_type_question(
id bigint auto_increment primary key unique,
name varchar(255)
);

create table tbl_category_question(
id bigint auto_increment primary key unique,
name varchar(255)
);

create table tbl_question(
id bigint auto_increment primary key unique,
content text,
created_date datetime,
type_id bigint,
category_id bigint,
account_id bigint,
FOREIGN KEY (account_id) REFERENCES tbl_account(id),
FOREIGN KEY (type_id) REFERENCES tbl_type_question(id),
FOREIGN KEY (category_id) REFERENCES tbl_category_question(id)
);

create table tbl_answer(
id bigint auto_increment primary key unique,
content text,
is_correct bit(1),
question_id bigint,
FOREIGN KEY (question_id) REFERENCES tbl_question(id)
);

create table tbl_exam(
id bigint auto_increment primary key unique,
code varchar(255) unique,
title varchar(255),
durantion bigint,
created_date datetime,
category_id bigint,
FOREIGN KEY (category_id) REFERENCES tbl_category_question(id),
account_id bigint,
FOREIGN KEY (account_id) REFERENCES tbl_account(id)
);

create table tbl_exam_question(
question_id bigint,
FOREIGN KEY (question_id) REFERENCES tbl_question(id),
exam_id bigint,
FOREIGN KEY (exam_id) REFERENCES tbl_exam(id)
);

