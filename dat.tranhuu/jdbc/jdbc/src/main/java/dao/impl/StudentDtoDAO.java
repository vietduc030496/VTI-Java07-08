package dao.impl;

import java.util.List;

import constant.SQLQuery;
import dao.IStudentDto;
import dto.StudentDto;
import mapper.StudentDtoMapper;

public class StudentDtoDAO extends AbstractDAO<StudentDto> implements IStudentDto{

	@Override
	public List<StudentDto> findAll() {
		return query(SQLQuery.SELECT_ALL_STUDENTDTO, new StudentDtoMapper());
	}

}
