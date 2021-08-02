package entity;

public class ClassSchool {
	private int classID;
	private String className;
	private String schoolYear;

	public ClassSchool() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClassSchool(int classID, String className, String schoolYear) {
		super();
		this.classID = classID;
		this.className = className;
		this.schoolYear = schoolYear;
	}

	public int getClassID() {
		return classID;
	}

	public void setClassID(int classID) {
		this.classID = classID;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getSchoolYear() {
		return schoolYear;
	}

	public void setSchoolYear(String schoolYear) {
		this.schoolYear = schoolYear;
	}

	@Override
	public String toString() {
		return "Class [classID=" + classID + ", className=" + className + ", schoolYear=" + schoolYear + "]";
	}

}
