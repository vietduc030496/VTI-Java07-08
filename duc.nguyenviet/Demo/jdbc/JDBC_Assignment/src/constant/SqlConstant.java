package constant;

public class SqlConstant {

	private SqlConstant() {
	}

	public static final String SELECT_ALL_DEPT = "SELECT * FROM Department;";

	public static final String SELECT_DEPT_BY_ID = "SELECT * FROM Department WHERE DepartmentID = ?;";

}
