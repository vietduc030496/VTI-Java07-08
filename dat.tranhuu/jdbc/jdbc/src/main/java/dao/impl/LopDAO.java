package dao.impl;

import java.util.List;

import constant.SQLQuery;
import dao.ILopDAO;
import entity.Lop;
import mapper.LopMapper;

public class LopDAO extends AbstractDAO<Lop> implements ILopDAO{

	@Override
	public Lop findOne(Long id) {
		List<Lop> lops=  query(SQLQuery.SELECT_LOP_BY_ID, new LopMapper(), id);
		return lops.isEmpty() ? null : lops.get(0);
	}

	@Override
	public List<Lop> findAll() {
		return query(SQLQuery.SELECT_ALL_LOP, new LopMapper());
	}

	@Override
	public Long save(Lop lop) {
		return insert(SQLQuery.INSERT_LOP, lop.getName(),lop.getYear());
	}

	@Override
	public void update(Lop lop) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

}
