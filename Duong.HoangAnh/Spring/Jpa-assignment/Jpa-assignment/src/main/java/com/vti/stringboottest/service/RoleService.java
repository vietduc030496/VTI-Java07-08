package com.vti.stringboottest.service;

import com.vti.stringboottest.dto.RoleDTO;
import com.vti.stringboottest.entity.Role;

public interface RoleService {
	public void save(RoleDTO roleDto);
	
	public Role findById(Long id);
}
