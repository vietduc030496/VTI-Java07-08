package service;

import java.util.List;

import dao.impl.LopDAO;
import entity.Lop;

public class LopService {

	private LopDAO lopDAO;
	
	public LopService(LopDAO lopDAO) {
		this.lopDAO=lopDAO;
	}
	
	public List<Lop> findAll(){
		return this.lopDAO.findAll();
	}
	
}
