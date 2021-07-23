package Entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Employee {
    private static int size = 0;
    private int ssn;
    private String firstName;
    private String lastName;
    private String birthDate = "0";
    private String phone = "0";
    private String email = "0";

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

    public Employee(String firstName, String lastName, String birthDate, String phone, String email) {
        super();
        this.ssn = size;
        size += 1;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.phone = phone;
        this.email = email;
    }

    public Employee() {
        super();
    }

    public Employee(String firstName, String lastName) {
        super();
        this.ssn = size;
        size += 1;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = "Unknown";
        this.phone = "Unknown";
        this.email = "Unknown";
    }

    public String toString() {
        return this.getSsn() + " - " + this.getFirstName() + " " + this.getLastName() + " - " + this.getBirthDate() + " - " + this.getPhone() + " - " + this.getEmail();
    }

    public abstract void display();
}
