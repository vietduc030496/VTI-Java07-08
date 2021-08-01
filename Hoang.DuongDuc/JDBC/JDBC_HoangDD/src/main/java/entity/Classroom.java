package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Classroom {
    private int classId;
    private String className;
    private String scholastic;
    private int amountStudent;

    @Override
    public String toString() {
        return "Classroom{" +
                "classId=" + classId +
                ", amountStudent=" + amountStudent +
                '}';
    }
}
