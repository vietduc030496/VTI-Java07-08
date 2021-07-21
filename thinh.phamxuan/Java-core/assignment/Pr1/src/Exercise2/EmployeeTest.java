package Exercise2;

public class EmployeeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee employee1=new Employee("Pham","Thinh",1000);
		Employee employee2=new Employee("Pham","Trung",200);
		System.out.println(employee1.getYearlySalary());
		System.out.println(employee2.getYearlySalary());
		employee1.setMonthlySalary(employee1.getMonthlySalary()*1.1);
		employee2.setMonthlySalary(employee2.getMonthlySalary()*1.1);
		System.out.println(employee1.getYearlySalary());
		System.out.println(employee2.getYearlySalary());
	}

}
