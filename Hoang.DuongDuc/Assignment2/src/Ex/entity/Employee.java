package Ex.entity;

public abstract class Employee {
    public static int nextUserId = 1;
    private String ssn;
    private String firstName;
    private String lastName;
    private String birthDate;
    private String phone;
    private String mail;

    public Employee() {
    }

    public Employee(String ssn, String firstName, String lastName, String birthDate, String phone, String mail) {
        this.ssn = ssn;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.phone = phone;
        this.mail = mail;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void display() {
        if(this instanceof HourlyEmployee) {
            ((HourlyEmployee) this).display();
        } else {
            ((SalariedEmployee) this).display();
        }
    }
}
