package Bai2;

public class Employee {
    private String fname;
    private String lname;
    private double msalary;

    public Employee() {
    }

    public Employee(String fname, String lname, double msalary) {
        this.fname = fname;
        this.lname = lname;
        this.msalary = msalary;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public double getMsalary() {
        return msalary;
    }

    public void setMsalary(double msalary) {
        if (msalary <0){
            msalary = 0.0;
        }
        this.msalary = msalary;
    }
    public double Ysalary(Employee e){

        double mluong;
        mluong = e.msalary * 12;
        return mluong;
    }
    public String EmpInfo(Employee emp){
        String inf = "";
        inf += emp.getFname() + " " + emp.getLname() + "\nluong thang:" +emp.getMsalary();
        return inf;
    }
}
