package exercise2;

public class EmployeeTest {
	public static void main(String[] args) {
		Employee e1= new Employee("trung", "luong thành", 1000);
		Employee e2= new Employee("trung2", "lương 2", 2000);
		System.out.println("lương năm của nv1:"+e1.getMonsalary()*12);
		System.out.println("lương năm của nv2:"+e2.getMonsalary()*12);
		e1.setMonsalary(e1.getMonsalary()*1.1);
		e2.setMonsalary(e2.getMonsalary()*1.1);
		System.out.println("luong sau khi tăng 10%");
		System.out.println("lương năm của nv1:"+e1.getMonsalary()*12);
		System.out.println("lương năm của nv2:"+e2.getMonsalary()*12);
		
	}
}
