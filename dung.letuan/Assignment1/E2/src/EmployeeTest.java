public class EmployeeTest {
    public static void main(String[] args) {
        Employee e1 = new Employee("Le Van", "A", 100);
        System.out.println(e1.getLastName() + " : " + e1.getMonthSalary() * 12);
        Employee e2 = new Employee("Nguyen Thi", "B", 200);
        System.out.println(e2.getLastName() + " : " + e2.getMonthSalary() * 12);
        System.out.println(e1.getLastName() + " after raised: " + e1.getMonthSalary() * 12 * 1.1);
        System.out.println(e2.getLastName() + " after raised: " + e2.getMonthSalary() * 12 * 1.1);
    }
}
