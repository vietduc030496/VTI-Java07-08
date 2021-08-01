package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MarkOfStudent {
    private int studentId;
    private String className;
    private String subjectName;
    private double mark;
}
