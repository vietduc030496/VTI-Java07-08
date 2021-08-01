package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NumberOfGenderClass {
    private int classId;
    private String className;
    private int numberOfMale;
    private int numberOfFemale;
}
