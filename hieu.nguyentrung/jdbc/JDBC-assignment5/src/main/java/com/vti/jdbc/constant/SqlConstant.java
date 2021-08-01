package com.vti.jdbc.constant;

public class SqlConstant {
	private SqlConstant() {
	}

	public static final String INSERT_STUDENT = "INSERT INTO student(classID, firstName,`name`, gender, birthDate, address, phoneNumber, email ) "
			+"VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
	
	public static final String SELECT_STUDENT = "SELECT	studentID, CONCAT(firstName,\" \" , `name`)AS fullName , birthDate, gender, className\r\n"
			+ "FROM			student AS s\r\n"
			+ "NATURAL JOIN	classroom AS cr;";
	public static final String SELECT_NUM_OF_STUDENT = "With CTE1 AS(\r\n"
			+ "		SELECT 		cr.classID,className, gender,studentID\r\n"
			+ "		FROM		student AS s\r\n"
			+ "		RIGHT JOIN	classroom AS cr\r\n"
			+ "		ON			s.classID = cr.classID),\r\n"
			+ "CTE2 AS(\r\n"
			+ "		SELECT 		CTE1.classID, CTE1.gender, CTE1.studentID , count(*) num_of_male\r\n"
			+ "        FROM		CTE1\r\n"
			+ "        WHERE		CTE1.gender = \"Male\"\r\n"
			+ "        GROUP BY	CTE1.classID\r\n"
			+ "        \r\n"
			+ "),\r\n"
			+ "CTE3 AS(\r\n"
			+ "		SELECT 		CTE1.classID, CTE1.gender, CTE1.studentID,count(*) num_of_female\r\n"
			+ "        FROM		CTE1\r\n"
			+ "        WHERE		CTE1.gender = \"Female\"\r\n"
			+ "        GROUP BY	CTE1.classID\r\n"
			+ ")\r\n"
			+ "SELECT 		CTE1.classID,CTE1.className, CTE2.num_of_male, CTE3.num_of_female\r\n"
			+ "FROM 		CTE1\r\n"
			+ "LEFT JOIN	CTE2\r\n"
			+ "ON			CTE1.classID = CTE2.classID\r\n"
			+ "LEFT JOIN	CTE3\r\n"
			+ "ON			CTE1.classID = CTE3.classID\r\n"
			+ "Group BY	CTE1.classID;";
	public static final String SELECT_TRANSCRIPT = "WITH CTE1 AS(\r\n"
			+ "	SELECT		studentID, t.subjectID, subjectName\r\n"
			+ "    FROM		transcript AS t\r\n"
			+ "    LEFT JOIN	`subject` AS s\r\n"
			+ "    ON			t.subjectID = s.subjectID\r\n"
			+ ")\r\n"
			+ "SELECT			s.studentID, cr.className, CTE1.subjectName, t.score\r\n"
			+ "FROM			student AS s\r\n"
			+ "NATURAL JOIN	classroom AS cr\r\n"
			+ "NATURAL JOIN	transcript AS t\r\n"
			+ "NATURAL JOIN	CTE1;";
	public static final String SELECT_COUNT_EACH_CLASS ="SELECT cr.classID,className, count(s.classID) AS num_of_student\r\n"
			+ "FROM		student AS s\r\n"
			+ "RIGHT JOIN	classroom AS cr\r\n"
			+ "ON			s.classID = cr.classID\r\n"
			+ "GROUP By	s.classID;";
	public static final String SELECT_STUDENT_EACH_CLASS ="SELECT s.classID,className, studentID, firstName, `name`, gender, birthDate\r\n"
			+ "FROM		student AS s\r\n"
			+ "NATURAL JOIN	classroom AS cr\r\n"
			+ "ORDER BY	classID;";
	public static final String SELECT_MIN_SCORE_OF_STUDENT ="SELECT	s.subjectID, subjectName, t.studentID, stu.firstName, stu.`name`, gender, MIN(t.score) AS minScore\r\n"
			+ "FROM			`subject` AS s\r\n"
			+ "NATURAL JOIN	transcript AS t\r\n"
			+ "NATURAL JOIN	student AS stu\r\n"
			+ "GROUP BY		subjectName;";
	public static final String CALL_PROCEDURE_FIVE_SCORE = "CALL get_max_score(?);";
	
	public static final String CALL_PROCEDURE_AVG_SCORE = "CALL get_avg_score(?)";
	
	public static final String FUNC_CALC_TUISION = "{? = CALL get_tuition(?)}";
}
