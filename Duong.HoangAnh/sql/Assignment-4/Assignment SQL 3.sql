use Exam;

insert into `Department`(DepartmentName) value("sannam");
insert into `Department`(DepartmentName) value("ac");
insert into `Department`(DepartmentName) value("sale");
insert into `Department`(DepartmentName) value("marketing");
insert into `Department`(DepartmentName) value("p1");
insert into `Department`(DepartmentName) value("p2");
insert into `Department`(DepartmentName) value("p3");
insert into `Department`(DepartmentName) value("d1");
insert into `Department`(DepartmentName) value("d2");
insert into `Department`(DepartmentName) value("d3");

insert into `Position`(PositionName) value("dev");
insert into `Position`(PositionName) value("intern");
insert into `Position`(PositionName) value("hr");
insert into `Position`(PositionName) value("test");
insert into `Position`(PositionName) value("PM");
insert into `Position`(PositionName) value("scrum master");
insert into `Position`(PositionName) value("pm");
insert into `Position`(PositionName) value("gd");
insert into `Position`(PositionName) value("mk");
insert into `Position`(PositionName) value("sd");

insert into `Account`(Email, UserName, FullName, DepartmentID, PositionID, CreateDate) value("duong@gmail.com", "duongduong", "hoang anh duong", 2, 1,now());
insert into `Account`(Email, UserName, FullName, DepartmentID, PositionID, CreateDate) value("duowngwqe@gmail.com", "duongduong1", "nguyen anh duong", 4, 1,now());
insert into `Account`(Email, UserName, FullName, DepartmentID, PositionID, CreateDate) value("duowengeqw@gmail.com", "duongduong2", "tran anh duong", 5, 1, now());
insert into `Account`(Email, UserName, FullName, DepartmentID, PositionID, CreateDate) value("duqweoneqwg@gmail.com", "duongduong3", "dang anh duong", 6, 4, now());
insert into `Account`(Email, UserName, FullName, DepartmentID, PositionID, CreateDate) value("duoeqneqwg@gmail.com", "duongduong4", "nguyen anh truong", 7, 4, "2019-09-20");
insert into `Account`(Email, UserName, FullName, DepartmentID, PositionID, CreateDate) value("duewowqeng@gmail.com", "duongduong5", "truong anh duong", 4, 4, "2019-12-30");
insert into `Account`(Email, UserName, FullName, DepartmentID, PositionID, CreateDate) value("duoeqnqeqwg@gmail.com", "duongduong6", "Duong anh duongo", 2, 4, "2019-12-25");
insert into `Account`(Email, UserName, FullName, DepartmentID, PositionID, CreateDate) value("duongeqw@gmail.com", "duongduong7", "dung anh duong", 3, 5, "2019-12-21");
insert into `Account`(Email, UserName, FullName, DepartmentID, PositionID, CreateDate) value("duoewngeqw@gmail.com", "duongduong8", "lo anh duong", 3, 5, "2019-9-20");
insert into `Account`(Email, UserName, FullName, DepartmentID, PositionID, CreateDate) value("duoeqeqwng@gmail.com", "duongduong", "vo lua da0", 3, 6, "2019-11-20");

insert into `Group`(GroupName, CreatorID,CreateDate) value("hello", 1, now());
insert into `Group`(GroupName, CreatorID, CreateDate) value("hihihi", 1, now());
insert into `Group`(GroupName, CreatorID, CreateDate) value("hahaha", 1, now());
insert into `Group`(GroupName, CreatorID, CreateDate) value("hohoho", 4, "2019-11-20");
insert into `Group`(GroupName, CreatorID, CreateDate) value("hehehe", 4, "2019-10-20");
insert into `Group`(GroupName, CreatorID, CreateDate) value("yeyeye", 4, "2019-9-20");
insert into `Group`(GroupName, CreatorID, CreateDate) value("yoyoyo", 4, "2019-11-21");
insert into `Group`(GroupName, CreatorID, CreateDate) value("lololo", 2, "2019-12-20");
insert into `Group`(GroupName, CreatorID) value("liilil", 2);
insert into `Group`(GroupName, CreatorID) value("lalala", 2);

insert into `GroupAccount`(GroupID, AccountID) value(1, 2);
insert into `GroupAccount`(GroupID, AccountID) value(1, 1);
insert into `GroupAccount`(GroupID, AccountID) value(1, 3);
insert into `GroupAccount`(GroupID, AccountID) value(1, 4);
insert into `GroupAccount`(GroupID, AccountID) value(1, 5);
insert into `GroupAccount`(GroupID, AccountID) value(2, 9);
insert into `GroupAccount`(GroupID, AccountID) value(2, 8);
insert into `GroupAccount`(GroupID, AccountID) value(2, 7);
insert into `GroupAccount`(GroupID, AccountID) value(2, 6);
insert into `GroupAccount`(GroupID, AccountID) value(2, 4);

insert into  `TypeQuestion`(TypeName) value("trac nhiem");
insert into  `TypeQuestion`(TypeName) value("tu luan");
insert into  `TypeQuestion`(TypeName) value("essay");
insert into  `TypeQuestion`(TypeName) value("mutil");
insert into  `TypeQuestion`(TypeName) value("ly");
insert into  `TypeQuestion`(TypeName) value("hoa");
insert into  `TypeQuestion`(TypeName) value("su");
insert into  `TypeQuestion`(TypeName) value("anh");
insert into  `TypeQuestion`(TypeName) value("sinh");
insert into  `TypeQuestion`(TypeName) value("gdcd");

insert into `CategoryQuestion`(CategoryName) value("java");
insert into `CategoryQuestion`(CategoryName) value(".net");
insert into `CategoryQuestion`(CategoryName) value("sql");
insert into `CategoryQuestion`(CategoryName) value("ruby");
insert into `CategoryQuestion`(CategoryName) value("postman");
insert into `CategoryQuestion`(CategoryName) value("c++");
insert into `CategoryQuestion`(CategoryName) value("html");
insert into `CategoryQuestion`(CategoryName) value("css");
insert into `CategoryQuestion`(CategoryName) value("javascript");
insert into `CategoryQuestion`(CategoryName) value("c#");

insert into `Question`(Content, CategoryID, TypeID, CreatorID,CreateDate) value("gsfadadffawedfaw", 2, 1, 1,now());
insert into `Question`(Content, CategoryID, TypeID, CreatorID,CreateDate) value("gsfadadffawedfaw dawdawd", 1, 3, 1, now());
insert into `Question`(Content, CategoryID, TypeID, CreatorID,CreateDate) value("gsfadadf fawedfaw dawdaw", 4, 3, 1, now());
insert into `Question`(Content, CategoryID, TypeID, CreatorID,CreateDate) value("gsfa dadf faw edfaw dwad", 3, 2, 1, "2019-12-20");
insert into `Question`(Content, CategoryID, TypeID, CreatorID,CreateDate) value("gsf adad ffawedfaw dwd", 2, 1, 1, "2019-11-20");
insert into `Question`(Content, CategoryID, TypeID, CreatorID,CreateDate) value("gsfad adffaw edfaw dwad", 2, 1, 1, "2019-10-20");
insert into `Question`(Content, CategoryID, TypeID, CreatorID,CreateDate) value("gsfad adffaw edfaw daw", 1, 1, 2, "2019-12-21");
insert into `Question`(Content, CategoryID, TypeID, CreatorID,CreateDate) value("gsfad adff awedfaw awda", 2, 2, 2, "2019-12-30");
insert into `Question`(Content, CategoryID, TypeID, CreatorID,CreateDate) value("gsfad adffaw edfaw dawd", 4, 2, 2, "2019-12-20");
insert into `Question`(Content, CategoryID, TypeID, CreatorID,CreateDate) value("gsfa dadffaw edfaw dawdaw", 2, 1, 2, "2010-12-20");

insert into `Answer`(Content, QuestionID, isCorrect) value("dawdaw dawdawd awd awd", 1, true);
insert into `Answer`(Content, QuestionID, isCorrect) value("dawdaw dawdawd awd awd", 1, false);
insert into `Answer`(Content, QuestionID, isCorrect) value("dayu nu wdaw dawdyumujm hyh awd awd awd", 1, null);
insert into `Answer`(Content, QuestionID, isCorrect) value("dawduytnnaw dawdaj htjht jtwd awd awd", 1, null);
insert into `Answer`(Content, QuestionID, isCorrect) value("dawdaw dawdaj tywd awd awd", 4, null);
insert into `Answer`(Content, QuestionID, isCorrect) value("dawudaw dadwdawd awadwd awd", 5, true);
insert into `Answer`(Content, QuestionID, isCorrect) value("dawdaw dawd tjty awd awd awd", 6, null);
insert into `Answer`(Content, QuestionID, isCorrect) value("dawd aw dawdt jawdawd awd awd", 8, true);
insert into `Answer`(Content, QuestionID, isCorrect) value("dawd nyaw dawdatwd awd awd", 9, null);
insert into `Answer`(Content, QuestionID, isCorrect) value("dawd yaw dawdawd awd awd", 3, false);

insert into `Exam`(Code_Exam, Title, CategoryID, Duration, CreatorID,CreateDate) value("adawdawf","dawdaw",1,"10:59:11",1, now());
insert into `Exam`(Code_Exam, Title, CategoryID, Duration, CreatorID,CreateDate) value("gtrg","dawdaw",1,"01:31:11",2, now());
insert into `Exam`(Code_Exam, Title, CategoryID, Duration, CreatorID,CreateDate) value("gju","dawdaw",2,"01:31:11",1, now());
insert into `Exam`(Code_Exam, Title, CategoryID, Duration, CreatorID,CreateDate) value("kukil","dawdaw",2,"05:31:11",2,"2019-12-20");
insert into `Exam`(Code_Exam, Title, CategoryID, Duration, CreatorID,CreateDate) value("loerg","dawdaw",3,"16:31:11",1,"2019-01-20");
insert into `Exam`(Code_Exam, Title, CategoryID, Duration, CreatorID,CreateDate) value("vrvd","dawdaw",3,"09:31:11",4,"2019-11-20");
insert into `Exam`(Code_Exam, Title, CategoryID, Duration, CreatorID,CreateDate) value("erfgrg","dawdaw",4,"08:31:11",1,"2019-9-20");
insert into `Exam`(Code_Exam, Title, CategoryID, Duration, CreatorID,CreateDate) value("cbvcb","dawdaw",4,"06:31:11",3,"2019-12-21");
insert into `Exam`(Code_Exam, Title, CategoryID, Duration, CreatorID,CreateDate) value("juty","dawdaw",3,"01:31:11",1,"2029-12-20");
insert into `Exam`(Code_Exam, Title, CategoryID, Duration, CreatorID,CreateDate) value("adawdawf","dawdaw",4,"01:31:11",4, now());
insert into `Exam`(Code_Exam, Title, CategoryID, Duration, CreatorID,CreateDate) value("adawdawf","dawdaw",3,"91:31:11",1, now());

insert into `ExamQuestion`(ExamID, QuestionID) value(1,2);
insert into `ExamQuestion`(ExamID, QuestionID) value(2,2);
insert into `ExamQuestion`(ExamID, QuestionID) value(3,2);
insert into `ExamQuestion`(ExamID, QuestionID) value(4,2);
insert into `ExamQuestion`(ExamID, QuestionID) value(6,2);
insert into `ExamQuestion`(ExamID, QuestionID) value(6,2);
insert into `ExamQuestion`(ExamID, QuestionID) value(6,3);
insert into `ExamQuestion`(ExamID, QuestionID) value(1,2);
insert into `ExamQuestion`(ExamID, QuestionID) value(1,4);
insert into `ExamQuestion`(ExamID, QuestionID) value(1,6);

select * from `Department`;

select d.DepartmentID from `Department` d where d.DepartmentName like "sale";

select * from `Account` a order by length(a.FullName) DESC;

select * from `Account` a where a.AccountID = 3 order by length(a.FullName) DESC limit 1;

select g.GroupName from `Group` g where g.CreateDate < "20191220";  

select a.QuestionID from `Answer` a
group by a.QuestionId
having COUNT(a.QuestionId) >= 4;

select e.Code_Exam from `Exam` e
where e.Duration >= 60 and e.CreateDate < "20191220";

select * from `Group` g
order by g.CreateDate desc 
limit 5;

select count(a.AccountID) from `Account` a
group by a.DepartmentID
having a.DepartmentID = 2;

select * from `Account` a
where a.FullName like "D%o";

delete from `Exam` e
where e.CreateDate < '20191220';

delete from `Question` q
where q.Content like 'câu hỏi%';

update `Account` a
set a.FullName = 'Nguyễn Bá Lộc', a.Email = 'loc.nguyenba@vti.com.vn'
where a.AccountID = '5';

update `GroupAccount` ga
set ga.GroupID = '4'
where ga.AccountID = '5';	