package com.vti.stringboottest.service.implement;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.stringboottest.dto.RoleDTO;
import com.vti.stringboottest.entity.Role;
import com.vti.stringboottest.repository.RoleRepository;
import com.vti.stringboottest.service.RoleService;

@Service
public class RoleServiceImplement implements RoleService {

	@Autowired
	RoleRepository roleRepository;

	@Override
	public void save(RoleDTO roleDto) {
		Role role = new Role();
		role.setName(roleDto.getName());
		roleRepository.save(role);
	}

	@Override
	public Role findById(Long id) {
		Optional<Role> roleOp = roleRepository.findById(id);
		Role role = null;
		if (roleOp.isPresent()) {
			role = roleOp.get();
		}
		return role;
	}
}
