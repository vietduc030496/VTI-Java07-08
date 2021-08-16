package com.vti.SpringJPA_VTI.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vti.SpringJPA_VTI.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{
	Role findByName(String name);
}
