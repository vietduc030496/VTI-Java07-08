package dao.impl;

import java.util.List;

import constant.SQLQuery;
import dto.ScoreDto;
import mapper.ScoreMapper;

public class ScoreDtoDAO extends AbstractDAO<ScoreDto>{

	public List<ScoreDto> findByStudent(Long id){
		return query(SQLQuery.SELECT_SCORE_BY_STUDENT, new ScoreMapper(), id);
	}
	
	public List<ScoreDto> findByScoreMin(){
		return query(SQLQuery.SELECT_SUBJECT_BY_SCORE_MIN, new ScoreMapper());
	}
}
