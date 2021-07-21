/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee;

/**
 *
 * @author LENOVO
 */
public class Employee {
    private String firstName;
    private String lastName;
    private double saraly;

    public Employee() {
    }

    public Employee(String firstName, String lastName, double saraly) {
        this.firstName = firstName;
        this.lastName = lastName;
        if(saraly > 0.0){
            this.saraly = saraly;
        }
        else{
            this.saraly = 0.0;
        }
    }
    public double yearlySaraly(int give){
        double yearSaraly = 12*saraly + give*0.01*12*saraly;
        return yearSaraly;
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

    public double getSaraly() {
        return saraly;
    }

    public void setSaraly(double saraly) {
        if(saraly > 0.0){
            this.saraly = saraly;
        }
        else{
            this.saraly = 0.0;
        }
    }
    
}
