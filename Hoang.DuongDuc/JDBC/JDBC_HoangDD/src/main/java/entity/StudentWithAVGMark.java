package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentWithAVGMark {
    private int studentId;
    private String firstName;
    private String lastName;
    private String gender;
    private String dob;
    private double markAVG;
}
