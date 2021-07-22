#Question 1:Tạo view có chứa danh sách nhân viên thuộc phòng ban sale
SELECT * FROM `account`
WHERE departmentID = ( SELECT departmentID FROM department
						WHERE departmentName ="Sale");
                        
#Question 2: Tạo view có chứa thông tin các account tham gia vào nhiều group nhất 
SELECT * FROM `account`
WHERE accountID IN ( SELECT accountID FROM groupaccount
					 GROUP BY accountID
                     HAVING count(*) = ( SELECT max(counts.acc_count) FROM 
											(SELECT count(*) AS acc_count FROM groupaccount
													GROUP BY accountID) AS counts)
					);

#Question 3:Tạo view có chứa câu hỏi có những content quá dài (content quá 300 từ được coi là quá dài) 
#và xóa nó đi 
WITH cte3 AS (
	SELECT questionID,
			content,
            categoryID,
            typeID,
            creatorID,
            createDate
	FROM question
    WHERE length(content) > 300)
DELETE FROM cte3;

#Question 4:Tạo view có chứa danh sách các phòng ban có nhiều nhân viên nhất 
SELECT dept.DepartmentID, DepartmentName, count(*) AS num_of_employee
FROM department AS dept 
join `account` AS acc
ON dept.DepartmentID = acc.DepartmentID
GROUP BY acc.DepartmentID
HAVING num = (SELECT max(c) FROM 
					(SELECT count(*) AS c 
                     FROM `account` AS acc1 
                     GROUP BY acc1.DepartmentID) AS cs);

#Question 5: Tạo view có chứa tất các các câu hỏi do user họ Nguyễn tạo 
WITH cte5 AS (
	SELECT q.questionID,
			q.content,
            q.categoryID,
            q.typeID,
            q.creatorID,
            q.createDate,
            acc.fullname
	FROM question AS q INNER JOIN `account` AS acc
    ON q.creatorID = acc.accountID
    WHERE acc.fullname LIKE "nguyen%")
SELECT * FROM cte5;