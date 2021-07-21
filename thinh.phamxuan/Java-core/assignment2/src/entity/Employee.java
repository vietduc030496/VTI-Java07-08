package entity;

public abstract class Employee implements Payable {
	private static int id=0;
	private int ssn;
	private String firstName;
	private String lastName;
	private String birthDate;
	private String phone;
	private String email;
	
	public Employee() {
		super();
	}

	




	public Employee( String firstName, String lastName, String birthDate, String phone,
			String email) {
		super();
		this.ssn = id++;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.phone = phone;
		this.email = email;
	}








	public static int getId() {
		return id;
	}






	public static void setId(int id) {
		Employee.id = id;
	}






	public int getSsn() {
		return ssn;
	}






	public void setSsn(int ssn) {
		this.ssn = ssn;
	}






	public String getFirstName() {
		return firstName;
	}






	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}






	public String getLastName() {
		return lastName;
	}






	public void setLastName(String lastName) {
		this.lastName = lastName;
	}






	public String getBirthDate() {
		return birthDate;
	}






	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}






	public String getPhone() {
		return phone;
	}






	public void setPhone(String phone) {
		this.phone = phone;
	}






	public String getEmail() {
		return email;
	}






	public void setEmail(String email) {
		this.email = email;
	}






	public void display() {
		System.out.println("ssn:" + ssn+ " firstName:"+firstName+ " lastName:"+lastName+" birthDate:" +birthDate+" phone:"+phone+ " email:"+email);
	}
}