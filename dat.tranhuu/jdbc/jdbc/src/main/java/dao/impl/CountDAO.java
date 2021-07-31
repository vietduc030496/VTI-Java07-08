package dao.impl;

import java.util.List;

import constant.SQLQuery;
import mapper.CountMapper;

public class CountDAO extends AbstractDAO<Integer>{

	public Integer countStudentByGender(String gender, Long lopId) {
		List<Integer> lops=  query(SQLQuery.COUNT_STUDENT_BY_GENDER, new CountMapper(), gender.toUpperCase(),lopId);
		return lops.isEmpty() ? null : lops.get(0);
	}
	
	public Integer countStudentByLop( Long lopId) {
		List<Integer> lops=  query(SQLQuery.COUNT_STUDENT_BY_LOP, new CountMapper(),lopId);
		return lops.isEmpty() ? null : lops.get(0);
	}
}
