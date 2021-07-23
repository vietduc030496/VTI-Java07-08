INSERT INTO `group` (createDate)
VALUES		("2022-11-11");

DROP TRIGGER IF EXISTS trigger_create_Time;
DELIMITER $$
	CREATE TRIGGER  trigger_create_Time
    BEFORE INSERT ON `group`
    FOR EACH ROW
    BEGIN
		IF NEW.createDate > NOW() THEN
			SET NEW.createDate = NOW();
		END IF;
    END $$
DELIMITER ;
SELECT * FROM `group`;

#Question 2 : Tao trigger khong cho phep them user vao dept "Sale", khi them hien thong bao 
INSERT INTO `account`(username, departmentID)
VALUES		("Hieunguyen",1);
DROP TRIGGER IF EXISTS trigger_no_add_user;
DELIMITER $$
	CREATE TRIGGER  trigger_no_add_user
    BEFORE INSERT ON `account` 
    FOR EACH ROW
    BEGIN
		IF NEW.departmentID = 1 THEN
			SIGNAL SQLSTATE	'45000'
			SET message_text ='Department Sale cannot add more user';
		END IF;
    END $$
DELIMITER ;

#Question 3 : Cau hinh 1 group co nhieu nhat la 5 user
DELIMITER $$
    CREATE TRIGGER trigger_Max_Account
    BEFORE INSERT ON groupaccount
    FOR EACH ROW
    BEGIN
        DECLARE counters int DEFAULT(SELECT count(*) FROM groupaccount 
									GROUP BY groupID);
        IF counters = 3 THEN 
            SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = "Beyond the limit 5 user each group";
        END IF;
    END $$
DELIMITER ;
SELECT counters ;
INSERT INTO groupaccount VALUES (1,3,"2021-11-11");

#Question 4 : Cau hinh 1 bai thi co nhieu nhat la 10 question

#Question 5: Tao trigger khong cho phep nguoi dung xoa tai khoan co email "admin@gmail.com", con lai thi co the xoa
DROP TRIGGER IF EXISTS trigger_disallow_delete;
DELIMITER $$
    CREATE TRIGGER trigger_disallow_delete
    BEFORE DELETE ON `account`
    FOR EACH ROW
    BEGIN
		IF OLD.email ="admin@gmail.com" THEN
            SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = "This is admin's account. You can't delete";
        END IF;
    END $$
DELIMITER ;
DELETE FROM `account` AS acc
WHERE		acc.email =  "admin@gmail.com";

#Question 6: tạo trigger cho phép người dùng khi tạo account không điền vào departmentID thì sẽ được phân vào phòng ban "phong cho"
DROP TRIGGER IF EXISTS trigger_deparment_auto;
DELIMITER $$
    CREATE TRIGGER trigger_deparment_auto
    BEFORE INSERT ON `account`
    FOR EACH ROW
    BEGIN
		IF NEW.departmentID ="" THEN
            SET  NEW.departmentID = 6;
        END IF;
    END $$
DELIMITER ;

INSERT INTO `account` VALUES (null, 'hieudepzai@gmail.com', 'hieudepzai', 'hieunguyen',"", 3,'2021-07-23');


#Question 8: Viết trigger sửa lại dữ liệu cho đúng: nếu người dùng nhập vào gender của account là nam nữ,
#chưa xác định thì sẽ đổi lại thành M, F, U cho giống với hình ở database
DROP TRIGGER IF EXISTS trigger_update_data;
DELIMITER $$
    CREATE TRIGGER trigger_update_data
    BEFORE INSERT ON `account`
    FOR EACH ROW
    BEGIN
		
    END $$
DELIMITER ;








