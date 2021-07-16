package ExerciseTwo;

public class EmployeeTest {
	private Employee one = new Employee("one", "johns", 1000);
	private Employee two = new Employee("two", "james", 1500);
	public Employee getEmployeeOne() {
		return one;
	}
	public Employee getEmployeeTwo() {
		return two;
	}
	public void setEmployeeOne(String fName, String lName, int salary) {
		one.setFirstName(fName);
		one.setLastName(lName);
		one.setSalary(salary);
	}
	public void setEmployeeTwo(String fName, String lName, int salary) {
		two.setFirstName(fName);
		two.setLastName(lName);
		two.setSalary(salary);
	}
	public void displaySalary() {
		System.out.println("Yearly salary one: " + one.getSalary()*12 + "  Yearly salary two: " + two.getSalary()*12);
		System.out.println("10% raise");
		System.out.println("Yearly salary one: " + (int)(one.getSalary()*12*1.1) + "  Yearly salary two: " + (int)(two.getSalary()*12*1.1));
	}
}
