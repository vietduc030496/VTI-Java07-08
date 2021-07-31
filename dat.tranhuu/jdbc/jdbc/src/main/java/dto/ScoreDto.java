package dto;

public class ScoreDto {

	private Long studentId;
	private Long subjectId;
	private float socre;
	private String name;
	private String firstName;
	private String subjectName;
	private String lopName;
	
	
	public Long getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}
	public Long getStudentId() {
		return studentId;
	}
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	public float getSocre() {
		return socre;
	}
	public void setSocre(float socre) {
		this.socre = socre;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public String getLopName() {
		return lopName;
	}
	public void setLopName(String lopName) {
		this.lopName = lopName;
	}
	
	
}
