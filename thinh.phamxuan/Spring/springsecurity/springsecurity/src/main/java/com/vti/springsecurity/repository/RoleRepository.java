package com.vti.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vti.springsecurity.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
	Role findByName(String name);
}
