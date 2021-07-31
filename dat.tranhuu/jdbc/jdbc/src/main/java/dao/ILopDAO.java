package dao;

import java.util.List;

import entity.Lop;

public interface ILopDAO extends GenericDAO<Lop>{

	Lop findOne(Long id);
	
	List<Lop> findAll();

	Long save(Lop lop);
	
	void update(Lop lop);
	
	void delete(long id);
}
