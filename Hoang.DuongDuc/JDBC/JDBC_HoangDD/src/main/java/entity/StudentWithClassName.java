package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentWithClassName {
    private int studentId;
    private String firstName;
    private String lastName;
    private String gender;
    private String dob;
    private String ClassName;

    @Override
    public String toString() {
        return "StudentWithClassName{" +
                "studentId=" + studentId +
                ", Name='" + firstName + " " + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", dob='" + dob + '\'' +
                ", ClassName='" + ClassName + '\'' +
                '}';
    }
}
