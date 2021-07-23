package Entity;

public class HourlyEmployee extends Employee {
    private double wage;
    private double workingHours;

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public double getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(double workingHours) {
        this.workingHours = workingHours;
    }

    public HourlyEmployee(String firstName, String lastName, String birthDate, String phone, String email,
                          double wage, double workingHours) {
        super(firstName, lastName, birthDate, phone, email);
        this.wage = wage;
        this.workingHours = workingHours;
    }

    public String toString() {
        return super.toString() + " - " + this.getWage() + " - " + this.getWorkingHours();
    }

    public void display() {
        System.out.println(this.toString());
    }
}
