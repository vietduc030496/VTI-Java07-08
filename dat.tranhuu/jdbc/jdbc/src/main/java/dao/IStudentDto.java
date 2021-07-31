package dao;

import java.util.List;

import dto.StudentDto;

public interface IStudentDto extends GenericDAO<StudentDto>{

	List<StudentDto> findAll();
}
