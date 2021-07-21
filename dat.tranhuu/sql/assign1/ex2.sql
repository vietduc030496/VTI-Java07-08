use vti1;
insert into tbl_department(name) values ("department 1");
insert into tbl_department(name) values ("department 2");
insert into tbl_department(name) values ("department 3");
insert into tbl_department(name) values ("department 4");
insert into tbl_department(name) values ("department 5");
insert into tbl_department(name) values ("department 6");
insert into tbl_department(name) values ("department 7");
insert into tbl_department(name) values ("department 8");
insert into tbl_department(name) values ("department 9");
insert into tbl_department(name) values ("department 10");
insert into tbl_department(name) values ("sale");

insert into tbl_position(name) values ("position 1");
insert into tbl_position(name) values ("position 2");
insert into tbl_position(name) values ("position 3");
insert into tbl_position(name) values ("position 4");
insert into tbl_position(name) values ("position 5");
insert into tbl_position(name) values ("position 6");
insert into tbl_position(name) values ("position 7");
insert into tbl_position(name) values ("position 8");
insert into tbl_position(name) values ("position 9");
insert into tbl_position(name) values ("position 10");
insert into tbl_position(name) values ("position 11");
insert into tbl_position(name) values ("developer");

insert into tbl_account(email,username,fullname,created_date,department_id,position_id) 
values ("email1@gmail.com","username1","fullname1","2021-07-19 06:41:46","1","1");
insert into tbl_account(email,username,fullname,created_date,department_id,position_id) 
values ("email2@gmail.com","username2","fullname2","2021-07-18 06:41:46","1","2");
insert into tbl_account(email,username,fullname,created_date,department_id,position_id) 
values ("email3@gmail.com","username3","fullname3","2021-07-17 06:41:46","2","1");
insert into tbl_account(email,username,fullname,created_date,department_id,position_id) 
values ("email4@gmail.com","username4","fullname4","2021-07-16 06:41:46","3","4");
insert into tbl_account(email,username,fullname,created_date,department_id,position_id) 
values ("email5@gmail.com","username5","fullname5","2021-07-15 06:41:46","4","5");
insert into tbl_account(email,username,fullname,created_date,department_id,position_id) 
values ("email6@gmail.com","username6","fullname6","2021-07-14 06:41:46","5","5");
insert into tbl_account(email,username,fullname,created_date,department_id,position_id) 
values ("email7@gmail.com","username7","fullname7","2021-07-13 06:41:46","5","6");
insert into tbl_account(email,username,fullname,created_date,department_id,position_id) 
values ("email8@gmail.com","username8","fullname8","2021-07-12 06:41:46","7","8");
insert into tbl_account(email,username,fullname,created_date,department_id,position_id) 
values ("email9@gmail.com","username9","fullname9","2021-07-11 06:41:46","8","7");
insert into tbl_account(email,username,fullname,created_date,department_id,position_id) 
values ("email10@gmail.com","username10","fullname10","2021-07-10 06:41:46","9","5");
insert into tbl_account(email,username,fullname,created_date,department_id,position_id) 
values ("email11@gmail.com","username11","fullname11","2021-07-9 06:41:46","7","9");
insert into tbl_account(email,username,fullname,created_date,department_id,position_id) 
values ("email12@gmail.com","username12","fullname12","2021-07-8 06:41:46","4","8");
insert into tbl_account(email,username,fullname,created_date,department_id,position_id) 
values ("email13@gmail.com","username13","fullname13","2021-07-9 06:41:46","7","6");
insert into tbl_account(email,username,fullname,created_date,department_id,position_id) 
values ("email14@gmail.com","username14","fullname14","2021-07-8 06:41:46","4","9");
insert into tbl_account(email,username,fullname,created_date,department_id,position_id) 
values ("email15@gmail.com","username15","fullname15","2021-07-16 06:41:46","3","4");
insert into tbl_account(email,username,fullname,created_date,department_id,position_id) 
values ("email16@gmail.com","username16","Dao","2021-07-16 06:41:46","3","4");
insert into tbl_account(email,username,fullname,created_date,department_id,position_id) 
values ("email17@gmail.com","username17","Django","2021-07-16 06:41:46","3","4");
insert into tbl_account(email,username,fullname,created_date,department_id,position_id) 
values ("email18@gmail.com","username18","saler","2021-07-16 06:41:46","11","4");
insert into tbl_account(email,username,fullname,created_date,department_id,position_id) 
values ("email19@gmail.com","username19","abc Nguyễn ádasd","2021-07-16 06:41:46","11","4");

insert into tbl_group(name,created_date,account_id) values ("name1","2021-07-8 06:41:46","1");
insert into tbl_group(name,created_date,account_id) values ("name2","2021-07-9 06:41:46","2");
insert into tbl_group(name,created_date,account_id) values ("name3","2021-07-10 06:41:46","3");
insert into tbl_group(name,created_date,account_id) values ("name4","2021-07-11 06:41:46","4");
insert into tbl_group(name,created_date,account_id) values ("name5","2021-07-12 06:41:46","5");
insert into tbl_group(name,created_date,account_id) values ("name6","2021-07-13 06:41:46","6");
insert into tbl_group(name,created_date,account_id) values ("name7","2021-07-14 06:41:46","7");
insert into tbl_group(name,created_date,account_id) values ("name8","2021-07-15 06:41:46","8");
insert into tbl_group(name,created_date,account_id) values ("name9","2021-07-16 06:41:46","9");
insert into tbl_group(name,created_date,account_id) values ("name10","2021-07-17 06:41:46","10");
insert into tbl_group(name,created_date,account_id) values ("name11","2021-07-18 06:41:46","11");

insert into tbl_group_account(join_date,group_id,account_id) values ("2021-07-18 06:41:46",1,2);
insert into tbl_group_account(join_date,group_id,account_id) values ("2021-07-19 06:41:46",2,3);
insert into tbl_group_account(join_date,group_id,account_id) values ("2021-07-18 06:41:46",3,4);
insert into tbl_group_account(join_date,group_id,account_id) values ("2021-07-19 06:41:46",4,5);
insert into tbl_group_account(join_date,group_id,account_id) values ("2021-07-19 06:41:46",5,6);
insert into tbl_group_account(join_date,group_id,account_id) values ("2021-07-18 06:41:46",6,7);
insert into tbl_group_account(join_date,group_id,account_id) values ("2021-07-18 06:41:46",7,8);
insert into tbl_group_account(join_date,group_id,account_id) values ("2021-07-19 06:41:46",8,9);
insert into tbl_group_account(join_date,group_id,account_id) values ("2021-07-18 06:41:46",9,10);
insert into tbl_group_account(join_date,group_id,account_id) values ("2021-07-17 06:41:46",10,11);
insert into tbl_group_account(join_date,group_id,account_id) values ("2021-07-17 06:41:46",10,11);
insert into tbl_group_account(join_date,group_id,account_id) values ("2021-07-17 06:41:46",10,11);
insert into tbl_group_account(join_date,group_id,account_id) values ("2021-07-17 06:41:46",10,11);
insert into tbl_group_account(join_date,group_id,account_id) values ("2021-07-17 06:41:46",10,11);
insert into tbl_group_account(join_date,group_id,account_id) values ("2021-07-17 06:41:46",10,11);
insert into tbl_group_account(join_date,group_id,account_id) values ("2021-07-18 06:41:46",9,10);
insert into tbl_group_account(join_date,group_id,account_id) values ("2021-07-18 06:41:46",9,10);
insert into tbl_group_account(join_date,group_id,account_id) values ("2021-07-18 06:41:46",9,10);
insert into tbl_group_account(join_date,group_id,account_id) values ("2021-07-18 06:41:46",9,10);
insert into tbl_group_account(join_date,group_id,account_id) values ("2021-07-18 06:41:46",9,10);
insert into tbl_group_account(join_date,group_id,account_id) values ("2021-07-18 06:41:46",9,10);
insert into tbl_group_account(join_date,group_id,account_id) values ("2021-07-18 06:41:46",9,10);
insert into tbl_group_account(join_date,group_id,account_id) values ("2021-07-18 06:41:46",9,10);

insert into tbl_type_question(name) values ("type1");
insert into tbl_type_question(name) values ("type2");
insert into tbl_type_question(name) values ("type3");
insert into tbl_type_question(name) values ("type4");
insert into tbl_type_question(name) values ("type5");
insert into tbl_type_question(name) values ("type6");
insert into tbl_type_question(name) values ("type7");
insert into tbl_type_question(name) values ("type8");
insert into tbl_type_question(name) values ("type9");
insert into tbl_type_question(name) values ("type10");
insert into tbl_type_question(name) values ("tự luận");
insert into tbl_type_question(name) values ("trắc nghiệm");

insert into tbl_category_question(name) values ("category1");
insert into tbl_category_question(name) values ("category2");
insert into tbl_category_question(name) values ("category3");
insert into tbl_category_question(name) values ("category4");
insert into tbl_category_question(name) values ("category5");
insert into tbl_category_question(name) values ("category6");
insert into tbl_category_question(name) values ("category7");
insert into tbl_category_question(name) values ("category8");
insert into tbl_category_question(name) values ("category9");
insert into tbl_category_question(name) values ("category10");

insert into tbl_question(content,created_date,type_id,category_id,account_id) 
values ("content1","2021-07-17 06:41:46",1,1,1);
insert into tbl_question(content,created_date,type_id,category_id,account_id) 
values ("content2","2021-07-18 06:41:46",1,2,1);
insert into tbl_question(content,created_date,type_id,category_id,account_id) 
values ("content3","2021-07-19 06:41:46",2,3,1);
insert into tbl_question(content,created_date,type_id,category_id,account_id) 
values ("content4","2021-07-18 06:41:46",7,5,4);
insert into tbl_question(content,created_date,type_id,category_id,account_id) 
values ("content5","2021-07-17 06:41:46",2,4,5);
insert into tbl_question(content,created_date,type_id,category_id,account_id) 
values ("content6","2021-07-18 06:41:46",2,3,4);
insert into tbl_question(content,created_date,type_id,category_id,account_id) 
values ("content7","2021-07-19 06:41:46",5,8,6);
insert into tbl_question(content,created_date,type_id,category_id,account_id) 
values ("content8","2021-07-17 06:41:46",4,5,1);
insert into tbl_question(content,created_date,type_id,category_id,account_id) 
values ("content9","2021-07-18 06:41:46",8,4,5);
insert into tbl_question(content,created_date,type_id,category_id,account_id) 
values ("content10","2021-07-18 06:41:46",2,3,4);
insert into tbl_question(content,created_date,type_id,category_id,account_id) 
values ("câu hỏi 1","2021-07-18 06:41:46",2,3,4);
insert into tbl_question(content,created_date,type_id,category_id,account_id) 
values ("câu hỏi 2","2021-07-18 06:41:46",2,3,4);
insert into tbl_question(content,created_date,type_id,category_id,account_id) 
values ("câu hỏi 3","2021-07-18 06:41:46",2,3,4);
insert into tbl_question(content,created_date,type_id,category_id,account_id) 
values ("câu hỏi 4","2021-07-18 06:41:46",11,3,4);
insert into tbl_question(content,created_date,type_id,category_id,account_id) 
values ("câu hỏi 5","2021-07-18 06:41:46",12,3,4);
insert into tbl_question(content,created_date,type_id,category_id,account_id) 
values ("câu hỏi dài hơn 300 ký jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj","2021-07-18 06:41:46",12,3,4);
insert into tbl_question(content,created_date,type_id,category_id,account_id) 
values ("câu hỏi của nguyễn","2021-07-18 06:41:46",12,3,19);

insert into tbl_answer(content,is_correct,question_id) values ("anwser1",1,1);
insert into tbl_answer(content,is_correct,question_id) values ("anwser2",0,2);
insert into tbl_answer(content,is_correct,question_id) values ("anwser3",1,3);
insert into tbl_answer(content,is_correct,question_id) values ("anwser4",0,4);
insert into tbl_answer(content,is_correct,question_id) values ("anwser5",1,5);
insert into tbl_answer(content,is_correct,question_id) values ("anwser6",0,6);
insert into tbl_answer(content,is_correct,question_id) values ("anwser7",1,7);
insert into tbl_answer(content,is_correct,question_id) values ("anwser8",0,8);
insert into tbl_answer(content,is_correct,question_id) values ("anwser9",1,9);
insert into tbl_answer(content,is_correct,question_id) values ("anwser10",0,10);
insert into tbl_answer(content,is_correct,question_id) values ("anwser11",0,10);
insert into tbl_answer(content,is_correct,question_id) values ("anwser12",0,10);
insert into tbl_answer(content,is_correct,question_id) values ("anwser13",0,10);
insert into tbl_answer(content,is_correct,question_id) values ("anwser14",0,10);
insert into tbl_answer(content,is_correct,question_id) values ("anwser15",0,10);


insert into tbl_exam(code,title,durantion,created_date,category_id,account_id) 
values ("code1","title1",90,"2021-07-18 06:41:46",2,3);
insert into tbl_exam(code,title,durantion,created_date,category_id,account_id) 
values ("code2","title2",90,"2021-07-19 06:41:46",1,2);
insert into tbl_exam(code,title,durantion,created_date,category_id,account_id) 
values ("code3","title3",90,"2021-07-19 06:41:46",2,3);
insert into tbl_exam(code,title,durantion,created_date,category_id,account_id) 
values ("code4","title4",90,"2021-07-19 06:41:46",3,4);
insert into tbl_exam(code,title,durantion,created_date,category_id,account_id) 
values ("code5","title5",90,"2021-07-19 06:41:46",4,5);
insert into tbl_exam(code,title,durantion,created_date,category_id,account_id) 
values ("code6","title6",90,"2021-07-18 06:41:46",5,6);
insert into tbl_exam(code,title,durantion,created_date,category_id,account_id) 
values ("code7","title7",90,"2021-07-18 06:41:46",2,7);
insert into tbl_exam(code,title,durantion,created_date,category_id,account_id) 
values ("code8","title8",90,"2021-07-18 06:41:46",4,7);
insert into tbl_exam(code,title,durantion,created_date,category_id,account_id) 
values ("code9","title9",90,"2021-07-18 06:41:46",5,7);
insert into tbl_exam(code,title,durantion,created_date,category_id,account_id) 
values ("code10","title10",90,"2021-07-19 06:41:46",5,9);
insert into tbl_exam(code,title,durantion,created_date,category_id,account_id) 
values ("code11","title10",90,"2019-07-19 06:41:46",5,8);

insert into tbl_exam_question(question_id,exam_id) values (1,2);
insert into tbl_exam_question(question_id,exam_id) values (2,3);
insert into tbl_exam_question(question_id,exam_id) values (3,4);
insert into tbl_exam_question(question_id,exam_id) values (4,5);
insert into tbl_exam_question(question_id,exam_id) values (5,6);
insert into tbl_exam_question(question_id,exam_id) values (6,7);
insert into tbl_exam_question(question_id,exam_id) values (7,8);
insert into tbl_exam_question(question_id,exam_id) values (8,9);
insert into tbl_exam_question(question_id,exam_id) values (9,1);
insert into tbl_exam_question(question_id,exam_id) values (5,5);