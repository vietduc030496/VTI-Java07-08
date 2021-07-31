package dao.impl;

import java.util.List;

import constant.SQLQuery;
import entity.SubjectScore;
import mapper.ScoreSubjectMapper;

public class SubjectScoreDAO extends AbstractDAO<SubjectScore>{

	public List<SubjectScore> getARGByIdStudent(long id){
		return queryCall(SQLQuery.CALL_STORED_AVG, new ScoreSubjectMapper(), id);
	}
}
