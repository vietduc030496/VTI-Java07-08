package constant;

public class SQLConstant {
    private SQLConstant() {

    }

    public static final String INSERT_STUDENT = "insert into `student` (firstname, lastname, gender, DOB, address, phoneNumber,Email, IDclass) values (?,?,?,?,?,?,?,?);";
    public static final String SELECT_STUDENT = "select st.Idstudent, st.firstName, st.lastName, st.DOB, st.gender, cl.ClassName  " +
            "from `student` st left join `class` cl on st.Idclass = cl.Idclass;";
    public static final String SELECT_GENDERS = "With CTE1 AS(\n" +
            "\t\tSELECT \t\tcr.Idclass, cr.ClassName, gender,Idstudent\n" +
            "\t\tFROM\t\tstudent AS s\n" +
            "\t\tRIGHT JOIN\tclass AS cr\n" +
            "\t\tON\t\t\ts.Idclass = cr.Idclass),\n" +
            "CTE2 AS(\n" +
            "\t\tSELECT \t\tCTE1.Idclass, CTE1.gender, CTE1.Idstudent,count(*) num_of_male\n" +
            "        FROM\t\tCTE1\n" +
            "        WHERE\t\tCTE1.gender = \"Nam\"\n" +
            "        GROUP BY\tCTE1.Idclass\n" +
            "),\n" +
            "CTE3 AS(\n" +
            "\t\tSELECT \t\tCTE1.Idclass, CTE1.gender, CTE1.Idstudent,count(*) num_of_female\n" +
            "        FROM\t\tCTE1\n" +
            "        WHERE\t\tCTE1.gender = \"Nu\"\n" +
            "        GROUP BY\tCTE1.Idclass\n" +
            ")\n" +
            "SELECT \t\tCTE1.Idclass, CTE1.className, COALESCE(CTE2.num_of_male, 0) num_of_male, COALESCE(CTE3.num_of_female,0)num_of_female\n" +
            "FROM \t\tCTE1\n" +
            "LEFT JOIN\tCTE2\n" +
            "ON\t\t\tCTE1.Idclass = CTE2.Idclass\n" +
            "LEFT JOIN\tCTE3\n" +
            "ON\t\t\tCTE1.Idclass = CTE3.Idclass\n" +
            "Group BY\tCTE1.Idclass;";
    public static final String SELECT_TRANSCRIPT = "select st.Idstudent, cl.ClassName,sj.subjectName, tr.mark\n" +
            "from `student` as st\n" +
            "left join `transcript`as tr on\n" +
            "\tst.Idstudent = tr.Idstudent\n" +
            "left join `class` as cl on\n" +
            "\tst.IdClass= cl.IDclass\n" +
            "left join `subject` as sj on\n" +
            "\ttr.Idsubject= sj.Idsubject\n" +
            "where st.Idstudent =?;";
    public static final String SELECT_STUDENT_OF_CLASS = "Select CS.Idclass , COUNT(cs.Idclass)as So_Luong_Sinh_Vien\n" +
            "from(\n" +
            "select st.Idstudent, st.gender, cl.ClassName, cl.IDclass\n" +
            "from `student` st\n" +
            "left join `class` cl on\n" +
            "\tst.Idclass = cl.Idclass) as CS\n" +
            "group by cs.Idclass;";
    public static final String SELECT_MIN_OF_MARK_STUDENT = "select ma.Idsubject,ma.subjectName, ma.Idstudent, ma.firstName, ma.lastName, ma.gender, ma.DOB, min(ma.mark) as MinOfMark\n" +
            "from(select st.Idstudent,st.firstName, st.lastName, st.gender, st.DOB ,sj.IDsubject,sj.subjectName, tr.mark\n" +
            "from `student` as st\n" +
            "right join `transcript`as tr on\n" +
            "\tst.Idstudent = tr.Idstudent\n" +
            "left join `subject` as sj on\n" +
            "\ttr.Idsubject= sj.Idsubject)as ma\n" +
            "group by ma.subjectName;";
    public static final String STORE_PROCEDURE_TOP_5 = "CALL GET_Mark_of_5MAX_student_from_IdSubject(?);";
    public static final String STORE_PROCEDURE_AVG = "CALL GET_AVG_Mark_of_student(?);";
    public static final String FUNCTION_SUM_CREDIT = "select IDstudent, Sum_tuition(Idstudent) as TongHocPhi_VND\n" +
            "from student\n" +
            "where Idstudent = ?";
}
