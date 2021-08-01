package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TuitionOfStudent {
    private int studentId;
    private int tuition;

    @Override
    public String toString() {
        return "TuitionOfStudent{" +
                "studentId=" + studentId +
                ", tuition=" + tuition + "VND" +
                '}';
    }
}
