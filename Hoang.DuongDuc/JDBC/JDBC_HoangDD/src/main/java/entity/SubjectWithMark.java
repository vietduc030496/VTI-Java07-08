package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectWithMark {
    private int subjectId;
    private String subjectName;
    private double minOfMark;
    private int studentId;
    private String firstName;
    private String lastName;
    private String gender;
    private String dob;
    private double mark;

    public String toStringMinMark() {
        return "SubjectWithMinMarkOfStudent{" +
                "subjectId=" + subjectId +
                ", subjectName='" + subjectName + '\'' +
                ", minOfMark=" + minOfMark +
                ", studentId=" + studentId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", dob='" + dob + '\'' +
                '}';
    }

    public String toStringMark() {
        return "SubjectWithMinMarkOfStudent{" +
                "subjectId=" + subjectId +
                ", subjectName='" + subjectName + '\'' +
                ", studentId=" + studentId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", dob='" + dob + '\'' +
                ", mark=" + mark +
                '}';
    }
}
