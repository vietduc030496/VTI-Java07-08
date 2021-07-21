package ExerciseTwo;

public class Employee {
	private String firstName;
	private String lastName;
	private int salary;
	public Employee() {
		setFirstName(null);
		setLastName(null);
		setSalary(0);
	}
	public Employee(String fName, String lName, int sal) {
		setFirstName(fName);
		setLastName(lName);
		setSalary(sal);
	}
	public Employee(String fName, String lName) {
		setFirstName(fName);
		setLastName(lName);
		setSalary(0);
	}
	public void setFirstName(String fName) {
		firstName = fName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setLastName(String lName) {
		lastName = lName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setSalary(int sal) {
		salary = sal;
	}
	public int getSalary() {
		return salary;
	}
}
