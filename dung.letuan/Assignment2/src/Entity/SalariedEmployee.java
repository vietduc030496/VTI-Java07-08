package Entity;

public class SalariedEmployee extends Employee {
    private double commissionRate;
    private double grossSales;
    private double basicSalary;

    public double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(double commissionRate) {
        this.commissionRate = commissionRate;
    }

    public double getGrossSales() {
        return grossSales;
    }

    public void setGrossSales(double grossSales) {
        this.grossSales = grossSales;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public SalariedEmployee(String firstName, String lastName, String birthDate, String phone, String email,
                            double commissionRate, double grossSales, double basicSalary) {
        super(firstName, lastName, birthDate, phone, email);
        this.commissionRate = commissionRate;
        this.grossSales = grossSales;
        this.basicSalary = basicSalary;
    }

    public String toString() {
        return super.toString() + " - " + this.getCommissionRate() + " - " + this.getGrossSales() + " - " + this.getBasicSalary();
    }

    public void display() {
        System.out.println(this.toString());
    }

}
