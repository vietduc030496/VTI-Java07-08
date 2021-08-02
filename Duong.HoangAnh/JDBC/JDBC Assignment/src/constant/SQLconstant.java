package constant;

public class SQLconstant {

	private SQLconstant() {
	}

	public static final String INSERT_STUDENT = "INSERT INTO Student(firstName, lastName, gender, birthDay, address, phone, email)"
			+ "VALUE (?, ?, ?, ?, ?, ?, ?);";
	public static final String SHOW_ALL_STUDENT = "CALL show_student()";

	public static final String SELECT_MALE_FEMALE_IN_CLASS = "CALL show_amount_male_female_in_class()";

	public static final String SHOW_MARK_BOARD_STUDENT = "CALL show_mark_board_student(?);";

	public static final String SELECT_ALL_CLASS = "SELECT * FROM Class;";

	public static final String SELECT_STUDENT_IN_CLASS = "CALL show_student_in_class(?)";

	public static final String COUNT_STUDENT_IN_CLASS = "CALL count_student_class(?, ?)";

	public static final String SELECT_ALL_SUBJECT = "SELECT subjectID, subjectName FROM Subject;";

	public static final String FIND_STUDENT_MIN_MARK = "CALL find_student_min_mark(?);";

	public static final String FIND_THREE_TOP_MARK = "CALL find_top_three_mark(?);";

	public static final String SELECT_STUDENT_IN_THREE_TOP = "CALL select_student_top_three_mark(?, ?);";

	public static final String GET_SUBJECT_NAME = "SELECT subjectName FROM Subject WHERE subjectID = ?;";

	public static final String AVERAGE_MARK_STUDENT = "CALL average_mark_student(?, ?);";

	public static final String SUM_CREDITS_STUDENT = "CALL calc_amount_monney(?, ?);";
}
