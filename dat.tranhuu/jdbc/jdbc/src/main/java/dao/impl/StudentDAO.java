package dao.impl;

import java.util.List;

import constant.SQLQuery;
import dao.IStudentDAO;
import entity.Student;
import mapper.StudentMapper;

public class StudentDAO extends AbstractDAO<Student> implements IStudentDAO {

	@Override
	public Student findOne(Long id) {
		List<Student> lops = query(SQLQuery.SELECT_STUDENT_BY_ID, new StudentMapper(), id);
		return lops.isEmpty() ? null : lops.get(0);
	}
	
	public List<Student> findByLop(Long id) {
		return  query(SQLQuery.SELECT_STUDENT_BY_LOP, new StudentMapper(), id);
	}
	
	public List<Student> findByScoreSubject(Long id, float score) {
		return  query(SQLQuery.SELECT_STUDENT_BY_SCORE_SUBJECT, new StudentMapper(), id,score);
	}
	
	public List<Student> findByTopScore(Long id) {
		return  queryCall(SQLQuery.CALL_STORED_TOP5_SUBJECT, new StudentMapper(), id);
	}
	
	public Integer getTotal(long id) {
		return queryCallFunction(SQLQuery.CALL_FUNCTION_TOTALS, id);
	}

	@Override
	public List<Student> findAll() {
		return query(SQLQuery.SELECT_ALL_STUDENT, new StudentMapper());
	}

	@Override
	public Long save(Student lop) {

		return insert(SQLQuery.INSERT_STUDENT, lop.getName(), lop.getFirstName(), lop.getGender(), lop.getDob(),
				lop.getAddress(), lop.getPhone(), lop.getEmail(), lop.getLopId());
	}

	@Override
	public void update(Student lop) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub

	}

}
