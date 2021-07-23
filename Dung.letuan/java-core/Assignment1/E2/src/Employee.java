public class Employee {
    private String firstName;
    private String lastName;
    private double monthSalary;

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

    public double getMonthSalary() {
        return monthSalary;
    }

    public void setMonthSalary(double monthSalary) {
        if(monthSalary < 0) this.monthSalary = 0.0;
        else this.monthSalary = monthSalary;
    }

    public Employee(String firstName, String lastName, double monthSalary) {
        this.firstName = firstName;
        this.lastName = lastName;
        if(monthSalary < 0) this.monthSalary = 0.0;
        else this.monthSalary = monthSalary;
    }


}
