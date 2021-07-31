package constant;

public class SQLQuery {

	public static final String SELECT_ALL_LOP = "SELECT * FROM tbl_lop ;";

	public static final String SELECT_LOP_BY_ID = "SELECT * FROM tbl_lop WHERE id = ? ; ";
	
	public static final String INSERT_LOP = "INSERT INTO tbl_lop(name,year) VALUES (?,?);";
	
	public static final String SELECT_LOP_BY_NAME = "SELECT * FROM tbl_lop WHERE name = ? ; ";
	
	
	///////////////////////////////////////////////////////////////////////////////////////////
	
	public static final String SELECT_ALL_STUDENT = "SELECT * FROM tbl_student ;";

	public static final String SELECT_STUDENT_BY_ID = "SELECT * FROM tbl_student WHERE id = ? ; ";
	
	public static final String INSERT_STUDENT = "INSERT INTO tbl_student(name,first_name,gender,dob,address,phone,email,lop_id) VALUES (?,?,?,?,?,?,?,?);";
	
	public static final String SELECT_STUDENT_BY_NAME = "SELECT * FROM tbl_student WHERE name = ? ; ";
	
	public static final String SELECT_ALL_STUDENTDTO = "SELECT s.id,s.name,s.first_name"
			+ ",s.gender,s.dob,s.address,s.phone,s.email,s.lop_id,l.name AS lop_name,l.year AS lop_year FROM tbl_student s INNER JOIN tbl_lop l on l.id = s.lop_id;";
	
	public static final String COUNT_STUDENT_BY_GENDER = "SELECT COUNT(id) as count FROM tbl_student s WHERE s.gender = ? and s.lop_id = ? ; ";
	
	public static final String COUNT_STUDENT_BY_LOP = "SELECT COUNT(id) as count FROM tbl_student s WHERE s.lop_id = ? ; ";
	
	public static final String SELECT_STUDENT_BY_LOP = "SELECT * FROM tbl_student WHERE lop_id = ? ; ";
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static final String SELECT_SCORE_BY_STUDENT = "SELECT l.name AS lop_name,ss.subject_id ,ss.student_id,ss.score,s.name AS subject_name,s1.name as name, s1.first_name  FROM tbl_subject_score ss "
			+ " INNER JOIN tbl_subject s on s.id = ss.subject_id "
			+ " INNER JOIN tbl_student s1 on s1.id = ss.student_id"
			+ " INNER JOIN tbl_lop l on l.id = s1.lop_id"
			+ " WHERE s1.id = ? ;";
	
	public static final String SELECT_SUBJECT_BY_SCORE_MIN = "SELECT subject_id,subject_name,score,name,first_name,lop_name,student_id FROM (SELECT (ROW_NUMBER() OVER (PARTITION BY ss.subject_id ORDER BY ss.score DESC)) AS RowNumber, "
			+ "ss.subject_id,ss.score ,s1.name AS subject_name,s2.name,s2.first_name,ss.student_id,l.name AS lop_name "
			+ "FROM tbl_subject_score ss "
			+ "INNER JOIN tbl_subject s1 ON s1.id = ss.subject_id "
			+ "INNER JOIN tbl_student s2 ON s2.id = ss.student_id "
			+ "INNER JOIN tbl_lop l ON l.id = s2.lop_id) AS tbl WHERE tbl.RowNumber =1 ;";
	
	public static final String SELECT_STUDENT_BY_SCORE_SUBJECT= "SELECT s.id,s.name,s.first_name,s.gender,s.dob,s.address,s.phone,s.email,s.lop_id "
			+ " FROM tbl_student s INNER JOIN tbl_subject_score ss on ss.student_id = s.id "
			+ " WHERE ss.subject_id = ? AND ss.score = ? ";
	
	public static final String CALL_STORED_TOP5_SUBJECT="{call get_student_top5_score_subject(?)}";
	
	public static final String CALL_STORED_AVG="{call get_arv_score(?)}";
	
	public static final String CALL_FUNCTION_TOTALS="{ ? = call get_totals(?)}";
	
	public static final Integer FEE = 500;
}
