use assignment12;

insert into `Department`(DepartmentName) value("sale");
insert into `Department`(DepartmentName) value("Marketing");
insert into `Department`(DepartmentName) value("ki thuat");
insert into `Department`(DepartmentName) value("nhan su");
insert into `Department`(DepartmentName) value("tai chinh");
insert into `Department`(DepartmentName) value("ke toan");
insert into `Department`(DepartmentName) value("giam doc");
insert into `Department`(DepartmentName) value("thu ki");
insert into `Department`(DepartmentName) value("ban hang");
insert into `Department`(DepartmentName) value("pho giam doc");

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

insert into `Account`(Email, UserName, FullName, DepartmentID, PositionID) value("thanhtrung251@gmail.com", "thanhtrung", "Luong thanh trung dai nhat", 10, 10);
insert into `Account`(Email, UserName, FullName, DepartmentID, PositionID) value("thanhtrung251gmp1@gmail.com", "thanhtrung1", "Tuong thanh trung dai nhat", 3, 1);
insert into `Account`(Email, UserName, FullName, DepartmentID, PositionID) value("thanhtrung251gmp2@gmail.com", "thanhtrung2", "Luong thanh trung 2", 2, 2);
insert into `Account`(Email, UserName, FullName, DepartmentID, PositionID) value("thanhtrung251gmp3@gmail.com", "thanhtrung3", "Luong thanh trung 3", 3, 3);
insert into `Account`(Email, UserName, FullName, DepartmentID, PositionID) value("thanhtrung251gmp4@gmail.com", "thanhtrung4", "Luong thanh trung 4", 4, 4);
insert into `Account`(Email, UserName, FullName, DepartmentID, PositionID) value("thanhtrung251gmp5@gmail.com", "thanhtrung5", "Luong thanh trung 5", 5, 5);
insert into `Account`(Email, UserName, FullName, DepartmentID, PositionID) value("thanhtrung251gmp6@gmail.com", "thanhtrung6", "Luong thanh trung 6", 6, 6);
insert into `Account`(Email, UserName, FullName, DepartmentID, PositionID) value("thanhtrung251gmp7@gmail.com", "thanhtrung7", "Luong thanh trung 7", 7, 7);
insert into `Account`(Email, UserName, FullName, DepartmentID, PositionID) value("thanhtrung251gmp8@gmail.com", "thanhtrung8", "Luong thanh trung 8", 8, 8);
insert into `Account`(Email, UserName, FullName, DepartmentID, PositionID) value("thanhtrung251gmp9@gmail.com", "thanhtrung9", "Luong thanh trung 9", 9, 9);

insert into `Group`(GroupName, CreatorID,CreateDate) value("nhom 1", 1, now());
insert into `Group`(GroupName, CreatorID, CreateDate) value("nhom 2", 1, now());
insert into `Group`(GroupName, CreatorID, CreateDate) value("nhom 3", 1, now());
insert into `Group`(GroupName, CreatorID, CreateDate) value("nhom 4", 4, "2019-11-20");
insert into `Group`(GroupName, CreatorID, CreateDate) value("nhom 5", 4, "2019-10-20");
insert into `Group`(GroupName, CreatorID, CreateDate) value("nhom 6", 4, "2019-9-20");
insert into `Group`(GroupName, CreatorID, CreateDate) value("nhom 7", 4, "2019-11-21");
insert into `Group`(GroupName, CreatorID, CreateDate) value("nhom 8", 2, "2019-12-20");
insert into `Group`(GroupName, CreatorID) value("nhom 9", 2);
insert into `Group`(GroupName, CreatorID) value("nhom 10", 2);

insert into `GroupAccount`(GroupID, AccountID) value(2, 2);
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

insert into `Question`(Content, CategoryID, TypeID, CreatorID,CreateDate) value("cau hoi php", 2, 1, 1,'2020-03-05');
insert into `Question`(Content, CategoryID, TypeID, CreatorID,CreateDate) value("cau hoi java", 1, 3, 1, '2020-04-05');
insert into `Question`(Content, CategoryID, TypeID, CreatorID,CreateDate) value("cau hoi c#", 4, 3, 1, '2020-05-05');
insert into `Question`(Content, CategoryID, TypeID, CreatorID,CreateDate) value("cau hoi ruby", 3, 2, 1, '2019-12-20');
insert into `Question`(Content, CategoryID, TypeID, CreatorID,CreateDate) value("cau hoi postman", 2, 1, 1, '2020-09-05');
insert into `Question`(Content, CategoryID, TypeID, CreatorID,CreateDate) value("cau hoi ado.net", 2, 1, 1, '2020-07-05');
insert into `Question`(Content, CategoryID, TypeID, CreatorID,CreateDate) value("cau hoi c++", 1, 1, 2, '2020-06-05');
insert into `Question`(Content, CategoryID, TypeID, CreatorID,CreateDate) value("cau hoi sql", 2, 2, 2, '2020-05-05');
insert into `Question`(Content, CategoryID, TypeID, CreatorID,CreateDate) value("cau hoi python", 4, 2, 2, '2020-04-05');
insert into `Question`(Content, CategoryID, TypeID, CreatorID,CreateDate) value("cau hoi asp.net", 2, 1, 2, '2020-03-05');

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

insert into `Exam`(`Code`, Title, CategoryID, Duration, CreatorID,CreateDate) value("adawdawf","dawdaw",1,60,1, now());
insert into `Exam`(`Code`, Title, CategoryID, Duration, CreatorID,CreateDate) value("gtrg","dawdaw",1,120,2, now());
insert into `Exam`(`Code`, Title, CategoryID, Duration, CreatorID,CreateDate) value("gju","dawdaw",2,90,1, now());
insert into `Exam`(`Code`, Title, CategoryID, Duration, CreatorID,CreateDate) value("kukil","dawdaw",2,120,2,"2019-12-20");
insert into `Exam`(`Code`, Title, CategoryID, Duration, CreatorID,CreateDate) value("loerg","dawdaw",3,45,1,"2019-01-20");
insert into `Exam`(`Code`, Title, CategoryID, Duration, CreatorID,CreateDate) value("vrvd","dawdaw",3,90,4,"2019-11-20");
insert into `Exam`(`Code`, Title, CategoryID, Duration, CreatorID,CreateDate) value("erfgrg","dawdaw",4,120,1,"2019-9-20");
insert into `Exam`(`Code`, Title, CategoryID, Duration, CreatorID,CreateDate) value("cbvcb","dawdaw",4,60,3,"2019-12-21");
insert into `Exam`(`Code`, Title, CategoryID, Duration, CreatorID,CreateDate) value("juty","dawdaw",3,90,1,"2029-12-20");
insert into `Exam`(`Code`, Title, CategoryID, Duration, CreatorID,CreateDate) value("adawdawf","dawdaw",4,120,4, now());
insert into `Exam`(`Code`, Title, CategoryID, Duration, CreatorID,CreateDate) value("adawdawf","dawdaw",3,45,1, now());

insert into `ExamQuestion`(ExamID, QuestionID) value(1,2);
insert into `ExamQuestion`(ExamID, QuestionID) value(2,2);
insert into `ExamQuestion`(ExamID, QuestionID) value(3,2);
insert into `ExamQuestion`(ExamID, QuestionID) value(4,2);
insert into `ExamQuestion`(ExamID, QuestionID) value(6,2);
insert into `ExamQuestion`(ExamID, QuestionID) value(6,5);
insert into `ExamQuestion`(ExamID, QuestionID) value(6,3);
insert into `ExamQuestion`(ExamID, QuestionID) value(3,6);
insert into `ExamQuestion`(ExamID, QuestionID) value(1,4);
insert into `ExamQuestion`(ExamID, QuestionID) value(1,6);

-- Question 2: L???y t???t c??? c??c ph??ng ban
SELECT * FROM Department;

-- Question 3: L???y ra id c???a ph??ng ban "Sale"
SELECT 		DepartmentID 
FROM 		Department 
WHERE 		DepartmentName = N'Sale';

-- Question 4: l???y ra th??ng tin account c?? full name d??i nh???t v?? s???p x???p ch??ng theo th??? t??? gi???m d???n
SELECT 		* 
FROM 		`Account` 
WHERE 		LENGTH(Fullname) = (SELECT MAX(LENGTH(Fullname)) FROM `Account`)
ORDER BY 	Fullname DESC;

-- Question 5: L???y ra th??ng tin account c?? full name d??i nh???t v?? thu???c ph??ng ban c?? id = 3
SELECT *
FROM `Account`
where LENGTH(Fullname) = (SELECT MAX(LENGTH(Fullname)) FROM `Account`) AND DepartmentID=3;
-- Question 6: l???y ra t??n group ???? tham gia tr?????c ng??y 20/12/2019
SELECT GroupName
FROM `Group`
WHERE CreateDate < '2019-12-20';