package dao;

import java.util.List;

import entity.Student;

public interface IStudentDAO {

	Student findOne(Long id);
	
	List<Student> findAll();

	Long save(Student lop);
	
	void update(Student lop);
	
	void delete(long id);
}
